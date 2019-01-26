package service.builder;

import entity.Hookah;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JSONHookahBuilderTest {

    @Test
    void buildTest() {
        JSONHookahBuilder hookahBuilder = new JSONHookahBuilder();
        List<Hookah> actualHookahs = null;
        try {
            actualHookahs = hookahBuilder.build("src/main/resources/client");
        } catch (InvalidHookahException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Hookah> expectedHookahs = new ArrayList<>();
        expectedHookahs.add(new Hookah());
        expectedHookahs.add(new Hookah());
        assertEquals(actualHookahs.get(1).toString(), expectedHookahs.get(1).toString());
    }
}