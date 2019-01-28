package com.mrmrmr7.task.service.validator;

import java.nio.file.Files;
import java.nio.file.Paths;

class FileValidator {
    boolean validate(String path) {
        return Files.exists(Paths.get(path)) && Files.isRegularFile(Paths.get(path));
    }
}
