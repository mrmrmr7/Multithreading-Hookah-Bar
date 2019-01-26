package com.mrmrmr7.task.service.validator;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileValidator {
    public boolean validate(String path) {
        return Files.exists(Paths.get(path)) && Files.isRegularFile(Paths.get(path));
    }
}
