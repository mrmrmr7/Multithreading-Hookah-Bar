package com.mrmrmr7.task.service.builder;

import com.google.gson.Gson;
import com.mrmrmr7.task.entity.Hookah;
import com.mrmrmr7.task.service.validator.HookahValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JSONHookahBuilder {
    public List<Hookah> build(String JSONPath) throws InvalidHookahException, IOException {
        Gson gson = new Gson();
        String content = "";

        content = new String(Files.readAllBytes(Paths.get(JSONPath)));

        List<Hookah> hookahList = Arrays.asList(gson.fromJson(content, Hookah[].class));

        HookahValidator validator = new HookahValidator();

        if (!validator.validate(hookahList)) {
            throw new InvalidHookahException("Hookah list contain error");
        }

        return hookahList;
    }
}
