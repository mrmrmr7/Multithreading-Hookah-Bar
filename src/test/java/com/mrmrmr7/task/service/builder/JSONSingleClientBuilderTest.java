package com.mrmrmr7.task.service.builder;

import com.mrmrmr7.task.entity.SingleClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONSingleClientBuilderTest {

    @Test
    void buildTest() {
        JSONClientBuilder clientBuilder = new JSONClientBuilder();
        List<SingleClient> actualSingleClients = null;
        try {
            actualSingleClients = clientBuilder.build("src/main/resources/client");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidClientException e) {
            e.printStackTrace();
        }
        List<SingleClient> expectedSingleClients = new ArrayList<>();
        expectedSingleClients.add(new SingleClient("Maxim", true));
        expectedSingleClients.add(new SingleClient("Nikita", true));
        expectedSingleClients.add(new SingleClient("Alexandr", true));
        assertEquals(expectedSingleClients.get(1).toString(), actualSingleClients.get(1).toString());
    }
}