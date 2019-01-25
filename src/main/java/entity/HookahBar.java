package entity;

import java.util.List;

public class HookahBar {
    private final static HookahBar INSTANCE = new HookahBar();
    private List<Client> clientsInBar;
    private List<Client> clientsOutOfBar;
    private List<Client> clientsWithHookas;
    private List<Hookah> hookahs;
    private int clientsInBarCount;
    private int clientsInBarNow;

    public HookahBar() {
    }
}
