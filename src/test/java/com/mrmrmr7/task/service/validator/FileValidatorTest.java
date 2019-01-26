package com.mrmrmr7.task.service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileValidatorTest {

    @Test
    void validateTest() {
        FileValidator fileValidator = new FileValidator();
        boolean areValid = true;
        areValid &= fileValidator.validate("src/main/resources/client");
        areValid &= fileValidator.validate("src/main/resources/hookah");
        assertTrue(areValid);
    }
}