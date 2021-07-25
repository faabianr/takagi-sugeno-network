package uag.mcc.ai.fuzzy.takagi.services;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uag.mcc.ai.fuzzy.takagi.model.ChartData;
import uag.mcc.ai.fuzzy.takagi.model.ChartStyleConfig;
import uag.mcc.ai.fuzzy.takagi.model.Chromosome;
import uag.mcc.ai.fuzzy.takagi.model.Curve;

import java.util.Arrays;

@Builder
@Slf4j
public class CurveSynthesis {

    private static final int TOTAL_POINTS = 120;

    private final Chromosome tempChromsome;
    private final Chromosome rainChromosome;

    @Builder.Default
    private final ChartService chartService = new ChartService();

    public void execute() {
        log.info("starting Takagi Sugeno Network Sample");

        tempChromsome.evaluate();
        rainChromosome.evaluate();

        ChartData tempMfChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(0)
                .title("Temperature Membership Functions")
                .xAxisTitle(ChartData.X)
                .yAxisTitle(ChartData.Y)
                .curves(Arrays.asList(tempChromsome.getMf1Curve(), tempChromsome.getMf2Curve(), tempChromsome.getMf3Curve()))
                .build();

        ChartData tempChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(1)
                .title("Temperature")
                .xAxisTitle("Month")
                .yAxisTitle("Temperature")
                .curves(Arrays.asList(tempChromsome.getCurve(), tempReferenceCurve()))
                .build();

        ChartData rainMfChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(2)
                .title("Rainfall Membership Functions")
                .xAxisTitle(ChartData.X)
                .yAxisTitle(ChartData.Y)
                .curves(Arrays.asList(rainChromosome.getMf1Curve(), rainChromosome.getMf2Curve(), rainChromosome.getMf3Curve()))
                .build();

        ChartData rainChartData = ChartData.builder()
                .styleConfig(ChartStyleConfig.builder().build())
                .index(3)
                .title("Rainfall")
                .xAxisTitle("Month")
                .yAxisTitle("Precipitacion")
                .curves(Arrays.asList(rainChromosome.getCurve(), rainReferenceCurve()))
                .build();


        chartService.displayCharts(tempMfChartData, tempChartData, rainMfChartData, rainChartData);

    }

    private Curve tempReferenceCurve() {
        Double[] x = new Double[12];
        Double[] y = new Double[12];

        for (int i = 0; i < x.length; i++) {
            x[i] = (double) i;
        }

        y[0] = 24.0;
        y[1] = 26.0;
        y[2] = 29.0;
        y[3] = 31.0;
        y[4] = 32.0;
        y[5] = 30.0;
        y[6] = 27.0;
        y[7] = 27.0;
        y[8] = 27.0;
        y[9] = 27.0;
        y[10] = 26.0;
        y[11] = 25.0;

        return new Curve("Reference", Arrays.asList(x), Arrays.asList(y));
    }

    private Curve rainReferenceCurve() {
        Double[] x = new Double[12];
        Double[] y = new Double[12];

        for (int i = 0; i < x.length; i++) {
            x[i] = (double) i;
        }

        y[0] = 19.0;
        y[1] = 18.0;
        y[2] = 18.0;
        y[3] = 18.5;
        y[4] = 18.8;
        y[5] = 28.0;
        y[6] = 35.0;
        y[7] = 31.0;
        y[8] = 28.0;
        y[9] = 20.8;
        y[10] = 19.0;
        y[11] = 18.5;

        return new Curve("Reference", Arrays.asList(x), Arrays.asList(y));
    }

}
