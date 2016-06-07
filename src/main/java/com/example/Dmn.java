package com.example;


import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Dmn {
    private final DmnDecision dmn;
    private final DmnEngine dmnEngine;

    public Dmn() throws FileNotFoundException {
        dmnEngine = DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();

        dmn = dmnEngine.parseDecision("dmn", new FileInputStream("dmn.dmn"));
    }

    public DmnDecisionTableResult eval(double sum) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sum", sum);
        return dmnEngine.evaluateDecisionTable(dmn, map);
    }
}
