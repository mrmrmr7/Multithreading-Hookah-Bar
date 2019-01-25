package service.validator;

import entity.Hookah;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HookahListValidatorTest {

    @Test
    void validateTest() {
        List<Hookah> hookahs = new ArrayList<>();
        hookahs.add(new Hookah());
        hookahs.add(new Hookah());
        HookahListValidator hookahListValidator = new HookahListValidator();
        boolean areValid = hookahListValidator.validate(hookahs);
        assertTrue(areValid);
    }
}