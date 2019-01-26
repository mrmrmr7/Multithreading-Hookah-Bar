package com.mrmrmr7.task.service.validator;

import com.mrmrmr7.task.entity.Hookah;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HookahListValidatorTest {

    @Test
    void validateTest() {
        List<Hookah> hookahs = new ArrayList<>();
        hookahs.add(new Hookah("name", 4));
        hookahs.add(new Hookah("name2", 8));
        HookahValidator hookahListValidator = new HookahValidator();
        boolean areValid = hookahListValidator.validate(hookahs);
        assertTrue(areValid);
    }
}