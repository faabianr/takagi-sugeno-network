package uag.mcc.ai.fuzzy.takagi.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ChartData {

    public static final String X = "x";
    public static final String Y = "y";

    private int index;
    private String title;
    private String seriesName;
    private String xAxisTitle;
    private String yAxisTitle;
    @Builder.Default
    private List<Double> xValues = new ArrayList<>();
    @Builder.Default
    private List<Double> yValues = new ArrayList<>();
    private ChartStyleConfig styleConfig;

}
