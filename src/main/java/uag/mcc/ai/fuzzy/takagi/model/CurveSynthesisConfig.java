package uag.mcc.ai.fuzzy.takagi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CurveSynthesisConfig {

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

}
