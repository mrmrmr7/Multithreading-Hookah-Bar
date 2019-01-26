package com.mrmrmr7.task.controller;

import com.mrmrmr7.task.entity.Client;
import com.mrmrmr7.task.entity.Hookah;
import com.mrmrmr7.task.entity.HookahBar;
import org.junit.jupiter.api.Test;
import com.mrmrmr7.task.service.builder.HookahBarBuilder;

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
        HookahBar hookahBar = HookahBar.getInstance();

        HookahBarController barController = new HookahBarController();

        List<Runnable> clientList = new ArrayList<>();
        clientList.add(new Client("Maks"));
        clientList.add(new Client("Nikita"));
        clientList.add(new Client("Alexandr"));
        clientList.add(new Client("Valerka"));
        clientList.add(new Client("Egor"));
        clientList.add(new Client("Bogdan"));

        barController.addAllClient(clientList);

        barController.addClient(new Client("Kesha"));

        int actual = HookahBar.getInstance().getClientsInBarMaxCount();
        int expected = 10;

        barController.closeEmptyBar();

        assertEquals(actual, expected);
    }
}