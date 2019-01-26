package com.mrmrmr7.task.entity;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class HookahBar {
    private Semaphore barSemaphore;
    private Semaphore hookahSemaphore;
    private List<Hookah> hookahs;
    private int clientsInBarMaxCount;
    private final AtomicInteger clientsInBarNow = new AtomicInteger(0);
    private final static HookahBar INSTANCE = new HookahBar();

    private HookahBar() {
    }

    public static HookahBar getInstance() {
        return INSTANCE;
    }

    public Semaphore getBarSemaphore() {
        return this.barSemaphore;
    }

    public void setBarSemaphore(Semaphore semaphore) {
        this.barSemaphore = semaphore;
    }

    public Semaphore getHookahSemaphore() {
        return this.hookahSemaphore;
    }

    public void setHookahSemaphore(Semaphore semaphore) {
        this.hookahSemaphore = semaphore;
    }

    public List<Hookah> getHookahs() {
        return hookahs;
    }

    public void setHookahs(List<Hookah> hookahs) {
        this.hookahs = hookahs;
    }

    public Hookah getHookahById(int id) {
        return hookahs.get(id);
    }

    public int getClientsInBarMaxCount() {
        return clientsInBarMaxCount;
    }

    public void setClientsInBarMaxCount(int clientsInBarMaxCount) {
        this.clientsInBarMaxCount = clientsInBarMaxCount;
    }

    public AtomicInteger getClientsInBarNow() {
        return clientsInBarNow;
    }
}
