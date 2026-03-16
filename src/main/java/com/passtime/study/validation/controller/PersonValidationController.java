package com.passtime.study.validation.controller;

import com.passtime.study.validation.domain.PersonBo;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/person-validation")
public class PersonValidationController {

    @PostMapping
    public PersonBo personCreationEndpoint(@RequestBody @Valid PersonBo personRequestBo) {
        return personRequestBo;
    }
}
