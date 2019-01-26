package com.mrmrmr7.task.service;

import com.mrmrmr7.task.entity.HookahBar;
import com.mrmrmr7.task.util.AppConstant;

public class HookahBarService {
    HookahBar bar = HookahBar.getInstance();
    public synchronized void addBarClient() throws InterruptedException {
        bar.getBarSemaphore().acquire();
        bar.getClientsInBarNow().incrementAndGet();
    }

    public void removeBarClient() {
        bar.getClientsInBarNow().decrementAndGet();
        bar.getBarSemaphore().release();
    }

    public synchronized int getFreeHookah() throws InterruptedException, FreeHookahNotFoundException {
        bar.getHookahSemaphore().acquire();
        int res = AppConstant.FREE_HOOKAH_NOT_FOUND;
        for (int i = 0; i < bar.getHookahs().size(); i++) {
            if (bar.getHookahs().get(i).isFree()) {
                bar.getHookahs().get(i).setFree(false);
                res = i;
                break;
            }
        }

        if (res == AppConstant.FREE_HOOKAH_NOT_FOUND) {
            throw new FreeHookahNotFoundException("It impossible, but exception must be");
        }
        return res;
    }

    public void removeHookah(int num) {
        bar.getHookahs().get(num).setFree(true);
        bar.getHookahSemaphore().release();
    }

    public int getClientsInBarNow() {
        return bar.getClientsInBarNow().get();
    }


    public String getHookahNameByNum(int num) {
        return bar.getHookahById(num).getName();
    }
}
