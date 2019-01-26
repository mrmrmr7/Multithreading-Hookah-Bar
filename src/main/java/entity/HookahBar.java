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

    public synchronized void addBarClient() throws InterruptedException {
        while (true) {
            if (clientsInBarNow < clientsInBarMaxCount) {
                clientsInBarNow++;
                barSemaphore.acquire();
                break;
            }
            System.out.println("Not found place");
            Thread.sleep(100);
        }
    }

    public void removeBarClient() {
        clientsInBarNow--;
        barSemaphore.release();
    }

    public synchronized int getHookah() throws InterruptedException {
        while (true) {
            for (int i = 0; i < hookahs.size(); i++) {
                if (hookahs.get(i).isFree()) {
                    hookahs.get(i).setFree(false);
                    hookahSemaphore.acquire();
                    return i;
                }
            }
            Thread.sleep(100);
        }
    }

    public void removeHookah(int num) {
        hookahs.get(num).setFree(true);
        hookahSemaphore.release();
    }
}
