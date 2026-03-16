package com.passtime.study.integration.findy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FindyBotEndpoint {
    private String baseUrl;
    private List<String> keyWords;
    private List<Object> result;
}
