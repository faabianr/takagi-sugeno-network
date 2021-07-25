package uag.mcc.ai.fuzzy.takagi.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChartData {

    public static final String X = "x";
    public static final String Y = "y";

    private List<Curve> curves;
    private int index;
    private String title;
    private String xAxisTitle;
    private String yAxisTitle;
    private ChartStyleConfig styleConfig;

}
