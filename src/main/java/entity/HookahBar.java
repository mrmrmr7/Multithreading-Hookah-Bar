package entity;

import util.AppConstant;

import java.util.List;
import java.util.concurrent.Semaphore;

public class HookahBar {
    private Semaphore barSemaphore;
    private Semaphore hookahSemaphore;
    private List<Hookah> hookahs;
    private int clientsInBarMaxCount;
    private int clientsInBarNow;
    private final static HookahBar INSTANCE = new HookahBar();

    private HookahBar() {
    }

    public void setBarSemaphore(Semaphore semaphore) {
        this.barSemaphore = semaphore;
    }

    public void setHookahSemaphore(Semaphore semaphore) {
        this.hookahSemaphore = semaphore;
    }

    public static HookahBar getInstance() {
        return INSTANCE;
    }

    public List<Hookah> getHookahs() {
        return hookahs;
    }

    public void setHookahs(List<Hookah> hookahs) {
        this.hookahs = hookahs;
    }

    public int getClientsInBarMaxCount() {
        return clientsInBarMaxCount;
    }

    public void setClientsInBarMaxCount(int clientsInBarMaxCount) {
        this.clientsInBarMaxCount = clientsInBarMaxCount;
    }

    public int getClientsInBarNow() {
        return clientsInBarNow;
    }

    public void setClientsInBarNow(int clientsInBarNow) {
        this.clientsInBarNow = clientsInBarNow;
    }

    public boolean isFull() {
        return (clientsInBarNow >= clientsInBarMaxCount);
    }

    public void addBarClient() throws InterruptedException {
        barSemaphore.acquire();
    }

    public void removeBarClient() {
        barSemaphore.release();
    }

    public void addHookahClient() throws InterruptedException {
        hookahSemaphore.acquire();
    }

    public void removeHookahClient() {
        hookahSemaphore.release();
    }
}
