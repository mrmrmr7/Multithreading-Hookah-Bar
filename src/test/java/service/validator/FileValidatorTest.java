package service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileValidatorTest {

    @Test
    void validateTest() {
        FileValidator fileValidator = new FileValidator();
        boolean areValid &= fileValidator.validate("src/mail/resources/hookah");
        areValid &= fileValidator.validate("src/main/resources/client");
        assertTrue(areValid);
    }
}