package service;

import entity.Hookah;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class JSONHookahReaderTest {

    @Test
    void parseTest() throws IOException {
        JSONHookahReader jsonHookahReader = new JSONHookahReader();
        List<Hookah> hookahs = jsonHookahReader.parse("src/main/resources/hookah");
    }
}