package uag.mcc.ai.fuzzy.takagi.services;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uag.mcc.ai.fuzzy.takagi.model.ChartData;
import uag.mcc.ai.fuzzy.takagi.model.ChartStyleConfig;
import uag.mcc.ai.fuzzy.takagi.model.Curve;

import java.util.Arrays;
import java.util.Collections;

@Builder
@Slf4j
public class CurveSynthesis {

    private static final int TOTAL_POINTS = 120;

    private final double m1;
    private final double m2;
    private final double m3;
    private final double de1;
    private final double de2;
    private final double de3;
    private final double p1;
    private final double p2;
    private final double p3;
    private final double q1;
    private final double q2;
    private final double q3;

    @Builder.Default
    private final ChartService chartService = new ChartService();

    public void execute() {
        log.info("starting Takagi Sugeno Network Sample");

        Double[] x = new Double[TOTAL_POINTS];
        Double[] y = new Double[TOTAL_POINTS];
        Double[] mf1 = new Double[TOTAL_POINTS];
        Double[] mf2 = new Double[TOTAL_POINTS];
        Double[] mf3 = new Double[TOTAL_POINTS];

        for (int i = 0; i < 120; i++) {
            x[i] = i / 10.0;
            mf1[i] = Math.exp((-Math.pow((x[i] - m1), 2)) / (2 * Math.pow(de1, 2)));
            mf2[i] = Math.exp((-Math.pow((x[i] - m2), 2)) / (2 * Math.pow(de2, 2)));
            mf3[i] = Math.exp((-Math.pow((x[i] - m3), 2)) / (2 * Math.pow(de3, 2)));

            double b = mf1[i] + mf2[i] + mf3[i];

            double a1 = mf1[i] * (p1 * x[i] + q1);
            double a2 = mf2[i] * (p2 * x[i] + q2);
            double a3 = mf3[i] * (p3 * x[i] + q3);

            double a = a1 + a2 + a3;
            y[i] = a / b;
        }

        Curve tempMf1Curve = new Curve("mf1(x)", Arrays.asList(x), Arrays.asList(mf1));
        Curve tempMf2Curve = new Curve("mf2(x)", Arrays.asList(x), Arrays.asList(mf2));
        Curve tempMf3Curve = new Curve("mf3(x)", Arrays.asList(x), Arrays.asList(mf3));
        Curve tempCurve = new Curve("y(x)", Arrays.asList(x), Arrays.asList(y));

        ChartData tempMfChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(0)
                .title("Temperature Membership Functions")
                .xAxisTitle(ChartData.X)
                .yAxisTitle(ChartData.Y)
                .curves(Arrays.asList(tempMf1Curve, tempMf2Curve, tempMf3Curve))
                .build();

        ChartData tempChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(0)
                .title("Temperature")
                .xAxisTitle("Month")
                .yAxisTitle("Temperature")
                .curves(Collections.singletonList(tempCurve))
                .build();

        ChartData rainMfChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(0)
                .title("Rainfall Membership Functions")
                .xAxisTitle(ChartData.X)
                .yAxisTitle(ChartData.Y)
                .curves(Arrays.asList(tempMf1Curve, tempMf2Curve, tempMf3Curve))
                .build();

        ChartData rainChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(0)
                .title("Rainfall")
                .xAxisTitle("Month")
                .yAxisTitle("Precipitacion")
                .curves(Collections.singletonList(tempCurve))
                .build();


        chartService.displayCharts(tempMfChartData, tempChartData, rainMfChartData, rainChartData);

    }

}
