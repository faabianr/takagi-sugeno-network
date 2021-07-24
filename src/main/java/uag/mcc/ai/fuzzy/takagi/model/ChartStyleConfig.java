package uag.mcc.ai.fuzzy.takagi.model;

import lombok.Builder;
import lombok.Data;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.Marker;

import java.awt.*;

@Builder
@Data
public class ChartStyleConfig {

    private int width;
    private int height;
    private Styler.ChartTheme theme;
    private BasicStroke[] seriesLines;
    private boolean plotBorderVisible;
    private int markerSize;
    private Styler.LegendPosition legendPosition;
    private boolean tooltipEnabled;
    private boolean plotGridLinesVisible;
    private Font titleFont;
    private Font tooltipFont;
    private Styler.ToolTipType toolTipType;
    private Marker[] seriesMarkers;

}
