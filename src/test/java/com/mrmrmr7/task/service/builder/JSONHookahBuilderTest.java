package com.mrmrmr7.task.service.builder;

import com.mrmrmr7.task.entity.Hookah;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSONHookahBuilderTest {

    @Test
    void buildTest() {
        JSONHookahBuilder hookahBuilder = new JSONHookahBuilder();
        List<Hookah> actualHookahs = new ArrayList<>();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //заглушка т.к. не успевают закрываться файлы на чтение в других тестах
        }

        try {
            actualHookahs.addAll(hookahBuilder.build("src/main/resources/hookah"));
        } catch (InvalidHookahException | IOException e) {
            e.printStackTrace();
        }

        List<Hookah> expectedHookahs = new ArrayList<>();
        expectedHookahs.add(new Hookah("MeatHookah1", 5));
        expectedHookahs.add(new Hookah());
        assertEquals(expectedHookahs.get(0).toString(), actualHookahs.get(0).toString());
    }
}