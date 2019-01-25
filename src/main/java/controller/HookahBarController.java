package controller;

import entity.Client;
import entity.HookahBar;

import java.util.List;
import java.util.concurrent.Semaphore;

public class HookahBarController{
    private Semaphore HOOKAH_SEMAPHORE;
    private Semaphore BAR_SEMAPHORE;
    private HookahBar hookahBar;

    public HookahBarController(HookahBar hookahBar) {
    }

    public void start(List<Client> clients) {
    }
}
