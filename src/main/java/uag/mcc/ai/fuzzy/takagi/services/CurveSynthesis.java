package uag.mcc.ai.fuzzy.takagi.services;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import uag.mcc.ai.fuzzy.takagi.model.ChartData;
import uag.mcc.ai.fuzzy.takagi.model.ChartStyleConfig;
import uag.mcc.ai.fuzzy.takagi.model.Chromosome;

import java.util.Arrays;
import java.util.Collections;

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
                .curves(Collections.singletonList(tempChromsome.getCurve()))
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
                .curves(Collections.singletonList(rainChromosome.getCurve()))
                .build();


        chartService.displayCharts(tempMfChartData, tempChartData, rainMfChartData, rainChartData);

    }

}
