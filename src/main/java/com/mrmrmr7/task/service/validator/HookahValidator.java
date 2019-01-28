package com.mrmrmr7.task.service.validator;

import com.mrmrmr7.task.entity.Hookah;

import java.util.List;

public class HookahValidator {
    public boolean validate(List<Hookah> hookahs) {
        for (Hookah hookah : hookahs) {
            if (hookah.getCost() < 0) {
                return false;
            } else if (hookah.getName().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public boolean validate(Hookah hookah) {
        return !((hookah.getCost() < 0) || (hookah.getName().isEmpty()));
    }
}
