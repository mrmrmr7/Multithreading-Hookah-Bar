package com.mrmrmr7.task.controller;

import com.mrmrmr7.task.entity.HookahBar;
import com.mrmrmr7.task.util.AppConstant;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HookahBarController{
    ExecutorService executorService = Executors.newFixedThreadPool(AppConstant.MAX_THREAD_COUNT);
    HookahBar hookahBar = HookahBar.getInstance();

    public HookahBarController() {
    }

    public void addAllClient(List<Runnable> clientList) {
        for (int i = 0; i < clientList.size(); i++) {
            executorService.submit(clientList.get(i));
            try {
                Thread.sleep(AppConstant.CLIENT_ENTER_PING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeEmptyBar() {
        while (hookahBar.getClientsInBarNow().get() > 0) {
            try {
                Thread.sleep(AppConstant.CHECK_FOR_EMPTY_BAR_PING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    public void addClient(Runnable client) {
        executorService.submit(client);
    }
}
