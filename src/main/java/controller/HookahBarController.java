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
        for (int i = 0; i < clientList.size(); i++) {
            executorService.submit(clientList.get(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addClient(Runnable client) {
        executorService.submit(client);
    }
}
