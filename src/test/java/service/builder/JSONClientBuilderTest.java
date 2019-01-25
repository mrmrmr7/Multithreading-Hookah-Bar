package service.builder;

import entity.Client;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONClientBuilderTest {

    @Test
    void buildTest() {
        JSONClientBuilder clientBuilder = new JSONClientBuilder();
        List<Client> actualClients = clientBuilder.build("src/main/resources/client");
        List<Client> expectedClients = new ArrayList<>();
        expectedClients.add(new Client("Maxim"));
        expectedClients.add(new Client("Nikita"));
        expectedClients.add(new Client("Alexandr"));
        assertEquals(actualClients.get(1).toString(), expectedClients.get(1).toString());
    }
}