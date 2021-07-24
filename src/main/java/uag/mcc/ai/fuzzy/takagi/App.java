package uag.mcc.ai.fuzzy.takagi;

import uag.mcc.ai.fuzzy.takagi.model.CurveSynthesisConfig;
import uag.mcc.ai.fuzzy.takagi.services.CurveSynthesis;

public class App {

    public static void main(String[] args) {
        CurveSynthesis curveSynthesis = new CurveSynthesis();

        CurveSynthesisConfig config = CurveSynthesisConfig.builder()
                .m1(0)
                .de1(2.5)
                .m2(6)
                .de2(2)
                .m3(12)
                .de3(2.5)
                .p1(10)
                .q1(10)
                .p2(0)
                .q2(0)
                .p3(10)
                .q3(0)
                .build();

        curveSynthesis.execute(config);

    }

}
