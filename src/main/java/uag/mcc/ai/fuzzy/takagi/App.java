package uag.mcc.ai.fuzzy.takagi;

import uag.mcc.ai.fuzzy.takagi.model.Chromosome;
import uag.mcc.ai.fuzzy.takagi.services.CurveSynthesis;

public class App {

    public static void main(String[] args) {
        Chromosome tempChromosome = Chromosome.builder()
                .m1(0)
                .m2(6)
                .m3(12)
                .de1(3.5)
                .de2(1)
                .de3(3.5)
                .p1(3)
                .p2(0.5)
                .p3(-0.2)
                .q1(24)
                .q2(25)
                .q3(30)
                .build();

        Chromosome rainChromosome = Chromosome.builder()
                .m1(0)
                .m2(5)
                .m3(12)
                .de1(2.5)
                .de2(2)
                .de3(2)
                .p1(1)
                .p2(3.8)
                .p3(1)
                .q1(20)
                .q2(10)
                .q3(10)
                .build();

        CurveSynthesis curveSynthesis = CurveSynthesis.builder()
                .tempChromsome(tempChromosome)
                .rainChromosome(rainChromosome)
                .build();

        curveSynthesis.execute();
    }

}
