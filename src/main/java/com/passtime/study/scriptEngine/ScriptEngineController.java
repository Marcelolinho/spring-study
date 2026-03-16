package com.passtime.study.scriptEngine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/script")
public class ScriptEngineController {

    private final ScriptEngineStudy scriptEngineStudy;

    public ScriptEngineController(ScriptEngineStudy scriptEngineStudy) {
        this.scriptEngineStudy = scriptEngineStudy;
    }

    @GetMapping
    public String helloWorldFromPython() {
        return scriptEngineStudy.interpretPython();
    }

    @GetMapping("/object")
    public List<?> helloWorldObject() {
        return scriptEngineStudy.pythonArticleScraper();
    }
}
