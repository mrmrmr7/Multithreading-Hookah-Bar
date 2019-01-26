package controller;

import util.AppConstant;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HookahBarController{
    ExecutorService executorService = Executors.newFixedThreadPool(AppConstant.MAX_THREAD_COUNT);

    public HookahBarController() {
    }

    public void addAllClient(List<Runnable> clientList) {
        clientList
                .forEach(executorService::submit);
    }

    public void addClient(Runnable client) {
        executorService.submit(client);
    }
}
