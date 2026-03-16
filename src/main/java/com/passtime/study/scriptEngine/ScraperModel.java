package com.passtime.study.scriptEngine;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ScraperModel {
    private String URL;
    private String title;
    private String rank;
}
