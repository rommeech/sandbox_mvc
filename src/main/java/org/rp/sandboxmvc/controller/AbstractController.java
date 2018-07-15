package org.rp.sandboxmvc.controller;

import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

public abstract class AbstractController {

    public String getErrors(BindingResult result) {
        return result.getAllErrors().stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.joining("\n"));
    }

}
