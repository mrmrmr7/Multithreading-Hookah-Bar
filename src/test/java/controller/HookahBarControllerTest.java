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
        hookahList.add(new Hookah());
        hookahList.add(new Hookah());
        HookahBarBuilder barBuilder = new HookahBarBuilder();
        HookahBar hookahBar = barBuilder.build(hookahList, 10);
        HookahBarController barController = new HookahBarController(hookahBar);

        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client("Maks"));
        clientList.add(new Client("Nikita"));
        clientList.add(new Client("Alexandr"));

        int actual = barController.getHookahBar().getClientsMaxCount();
        int expected = 10;

        assertEquals(actual, expected);
    }
}