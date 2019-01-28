package com.mrmrmr7.task.controller;

import com.mrmrmr7.task.entity.HookahBar;
import com.mrmrmr7.task.util.AppConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class HookahBarController{
    private ExecutorService executorService = Executors.newFixedThreadPool(AppConstant.MAX_THREAD_COUNT);
    private HookahBar hookahBar = HookahBar.getInstance();
    private Logger logger = LogManager.getLogger(HookahBarController.class);

    void addAllClient(List<Runnable> clientList) {
        for (Runnable client : clientList) {
            executorService.submit(client);
            try {
                Thread.sleep(AppConstant.CLIENT_ENTER_PING);
            } catch (InterruptedException e) {
                logger.error("Thread has InterruptedException exception", e);
            }
        }
    }

    void closeEmptyBar() {
        try {
            while (hookahBar.getClientsInBarNow().get() > 0) {
                    Thread.sleep(AppConstant.CHECK_FOR_EMPTY_BAR_PING);
            }
        } catch (InterruptedException e) {
            logger.error("Thread has InterruptedException exception", e);
        }
        executorService.shutdown();
    }

    void addClient(Runnable client) {
        executorService.submit(client);
    }
}
