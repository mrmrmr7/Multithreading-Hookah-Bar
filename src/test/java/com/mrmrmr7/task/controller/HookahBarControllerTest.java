package com.mrmrmr7.task.controller;

import com.mrmrmr7.task.entity.CompanyClient;
import com.mrmrmr7.task.entity.SingleClient;
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
        hookahList.add(new Hookah("Some", 152, 2));
        hookahList.add(new Hookah("Next", 164, 1));

        HookahBarBuilder barBuilder = new HookahBarBuilder();
        barBuilder.configure(hookahList, 10);
        HookahBar hookahBar = HookahBar.getInstance();

        HookahBarController barController = new HookahBarController();

        List<Runnable> clientList = new ArrayList<>();
        clientList.add(new SingleClient("Maks", true, "Next"));
        clientList.add(new SingleClient("Nikita", true, "Next"));
        clientList.add(new SingleClient("Alexandr", true, "Next"));
        clientList.add(new SingleClient("Valerka", true, "Next"));
        clientList.add(new SingleClient("Egor", true, "Next"));
        clientList.add(new SingleClient("Bogdan", true, "Next"));
        clientList.add(new SingleClient("Valerka", true, "Next"));
        clientList.add(new SingleClient("Egor", true, "Next"));
        clientList.add(new SingleClient("Bogdan", true, "Next"));
        clientList.add(new SingleClient("Valerka", true, "Next"));
        clientList.add(new SingleClient("Egor", true));
        clientList.add(new SingleClient("Bogdan", true));

        List<String> company = new ArrayList<>();
        company.add("Kesha");
        company.add("Marisha");

        clientList.add(new CompanyClient("IIIIIIIIIIIIIRIIIIIIIIIIIISKA", company, false));

        barController.addAllClient(clientList);

        barController.addClient(new SingleClient("Kesha", true));

        int actual = HookahBar.getInstance().getClientsInBarMaxCount();
        int expected = 10;

        barController.closeEmptyBar();

        assertEquals(actual, expected);
    }
}