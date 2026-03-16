package com.passtime.study.scriptEngine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@Slf4j
public class ScriptEngineStudy {

    private final ObjectMapper objectMapper;

    public ScriptEngineStudy(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String interpretPython() {
//        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("python");
        try {
            ProcessBuilder pb = new ProcessBuilder();
//            pb.command("/home/maker/env/bin/activate");
            pb.command("/home/maker/env/bin/python", "-u", "/home/maker/Documentos/python_scripts/java_test.py");
            log.debug("buscou o arquivo!");
//        Reader reader
//        scriptEngine.

            Process process = pb.start();
            log.debug("começou a executar o script!");

            int exitCode = process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            log.debug("processou o arquivo");

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            log.debug("buscou o resultado");
            reader.close();

            if (sb.isEmpty()) {
                return null;
            }
            return sb.toString();
        } catch (IOException | InterruptedException e) {
            log.error("erroooo: {}", e.getMessage());
            return null;
        }

    }

    public List<ScraperModel> pythonArticleScraper() {
        String strOfObjScraperModel = interpretPython();

        try {
            JavaType javaTypeModel = objectMapper.getTypeFactory().constructCollectionType(List.class, ScraperModel.class);
            return objectMapper.readValue(strOfObjScraperModel, javaTypeModel);
        } catch (JsonProcessingException e) {
            log.error("Erro ao transformar");
            return null;
        }
    }
}
