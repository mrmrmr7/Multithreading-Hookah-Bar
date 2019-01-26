package entity;

import util.AppConstant;

import java.util.List;

public class HookahBar {

    private List<Hookah> hookahs;
    private int clientsInBarMaxCount;
    private int clientsInBarNow;
    private final static HookahBar INSTANCE = new HookahBar();

    private HookahBar() {
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

    public void addNowClientCount() {
        clientsInBarNow++;
    }

    public int getFreeHookah() {
        for (int i = 0; i < hookahs.size(); i++) {
            if (hookahs.get(i).isFree()) {
                hookahs.get(i).setFree(false);
                return i;
            }
        }

        return AppConstant.NO_FREE_HOOKAH;
    }

    public void releaseHookah(int hookahNum) {
        hookahs.get(hookahNum).setFree(true);
    }
}
