package controller;

import entity.Client;
import entity.Hookah;
import entity.HookahBar;
import org.junit.jupiter.api.Test;
import service.builder.HookahBarBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HookahBarControllerTest {

    @Test
    void hookahBarControllerTest() {
        List<Hookah> hookahList = new ArrayList<>();
        hookahList.add(new Hookah("Some", 152));
        hookahList.add(new Hookah("Next after some", 164));

        HookahBarBuilder barBuilder = new HookahBarBuilder();
        barBuilder.configure(hookahList, 10);

        HookahBarController barController = new HookahBarController();

        List<Runnable> clientList = new ArrayList<>();
        clientList.add(new Client("Maks"));
        clientList.add(new Client("Nikita"));
        clientList.add(new Client("Alexandr"));

        barController.addAllClient(clientList);

        int actual = HookahBar.getInstance().getClientsInBarMaxCount();
        int expected = 10;

        barController.executorService.shutdown();

        assertEquals(actual, expected);
    }
}