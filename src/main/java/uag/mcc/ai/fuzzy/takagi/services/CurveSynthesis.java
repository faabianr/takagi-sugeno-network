package uag.mcc.ai.fuzzy.takagi.services;

import lombok.extern.slf4j.Slf4j;
import uag.mcc.ai.fuzzy.takagi.model.CurveSynthesisConfig;

@Slf4j
public class CurveSynthesis {

    public void execute(CurveSynthesisConfig config) {
        log.info("starting Takagi Sugeno Network Sample with config: {}", config);
    }

}
