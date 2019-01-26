package entity;

import util.AppConstant;
import util.StringPool;

import java.text.MessageFormat;
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
        return clientsInBarNow.get();
    }

    public synchronized void addBarClient() throws InterruptedException {
        while (true) {
            if (clientsInBarNow.get() < clientsInBarMaxCount) {
                clientsInBarNow.incrementAndGet();
                barSemaphore.acquire();
                break;
            }
            Thread.sleep(AppConstant.CHECK_BAR_PLACE_PING);
        }
    }

    public void removeBarClient() {
        clientsInBarNow.decrementAndGet();
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
            Thread.sleep(500);
        }
    }

    public void removeHookah(int num) {
        hookahs.get(num).setFree(true);
        hookahSemaphore.release();
    }
}
