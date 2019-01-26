package service.builder;

import entity.Client;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONClientBuilderTest {

    @Test
    void buildTest() {
        JSONClientBuilder clientBuilder = new JSONClientBuilder();
        List<Client> actualClients = null;
        try {
            actualClients = clientBuilder.build("src/main/resources/client");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidClientException e) {
            e.printStackTrace();
        }
        List<Client> expectedClients = new ArrayList<>();
        expectedClients.add(new Client("Maxim"));
        expectedClients.add(new Client("Nikita"));
        expectedClients.add(new Client("Alexandr"));
        assertEquals(actualClients.get(1).toString(), expectedClients.get(1).toString());
    }
}