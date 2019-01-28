package com.mrmrmr7.task.service;

import com.mrmrmr7.task.entity.Hookah;
import com.mrmrmr7.task.entity.HookahBar;
import com.mrmrmr7.task.util.AppConstant;

import java.util.List;

public class HookahBarService {
    private HookahBar bar = HookahBar.getInstance();

    public synchronized boolean tryAddBarClient() throws InterruptedException {
        int timeOutCounter = 0;

        while (!bar.getBarSemaphore().tryAcquire()) {
            Thread.sleep(100);
            timeOutCounter++;
        }

        if (timeOutCounter < 10) {
            bar.getClientsInBarNow().incrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    public void removeBarClient() {
        bar.getClientsInBarNow().decrementAndGet();
        bar.getBarSemaphore().release();
    }

    public int getClientsInBarNow() {
        return bar.getClientsInBarNow().get();
    }

    public String getHookahNameByNum(int num) {
        return bar.getHookahById(num).getName();
    }

    public synchronized int getFreeHookah(String name) throws InterruptedException, FreeHookahNotFoundException {
        List<Hookah> hookahList = bar.getHookahs();

        if (name.equalsIgnoreCase("ANY")) {
            bar.getHookahSemaphore().acquire();

            for (int i = 0; i < hookahList.size(); i++) {
                if (hookahList.get(i).getCountFree() > 0) {
                    hookahList.get(i).decCountFree();
                    return i;
                }
            }

            throw new FreeHookahNotFoundException("Free hookah not found");
        } else {
            int timeOutCheck = 0;

            while (timeOutCheck < 10) {
                for (int i = 0; i < hookahList.size(); i++) {
                    if (hookahList.get(i).getName().equalsIgnoreCase(name)
                            && hookahList.get(i).getCountFree() > 0) {
                        bar.getHookahSemaphore().acquire();
                        hookahList.get(i).decCountFree();
                        return i;
                    }
                }
                Thread.sleep(100);
                timeOutCheck++;
            }

            return AppConstant.TIME_OUT;
        }
    }

    public void removeHookah(int num) {
        bar.getHookahs().get(num).incCountFree();
        bar.getHookahSemaphore().release();
    }
}
