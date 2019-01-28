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
        clientList.add(new SingleClient("1", true, "Next"));
        clientList.add(new SingleClient("2", true, "Next"));
        clientList.add(new SingleClient("3", true, "Next"));
        clientList.add(new SingleClient("4", true, "Next"));
        clientList.add(new SingleClient("5", true, "Next"));
        clientList.add(new SingleClient("6", true, "Next"));
        clientList.add(new SingleClient("7", true, "Next"));
        clientList.add(new SingleClient("8", true, "Next"));
        clientList.add(new SingleClient("9", true, "Next"));
        clientList.add(new SingleClient("10", true, "Next"));
        clientList.add(new SingleClient("11", true));
        clientList.add(new SingleClient("12", true));

        List<String> company = new ArrayList<>();
        company.add("13");
        company.add("14");

        clientList.add(new CompanyClient("IIIIIIIIIIIIIRIIIIIIIIIIIISKA", company, false));

        barController.addAllClient(clientList);

        barController.addClient(new SingleClient("Kesha", true));
        barController.closeEmptyBar();

        int actual = HookahBar.getInstance().getClientsInBarMaxCount();
        int expected = 10;

        assertEquals(actual, expected);
    }

    @Test
    void hookahBarControllerInterruptExceptionTest() {

    }
}