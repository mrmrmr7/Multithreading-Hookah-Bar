package controller;

import entity.Client;
import entity.HookahBar;

import java.util.List;
import java.util.concurrent.Semaphore;

public class HookahBarController{
    private Semaphore hookahSemaphore;
    private Semaphore barClientSemaphore;
    private HookahBar hookahBar;

    public HookahBarController(HookahBar hookahBar) {
    }

    public void start(List<Client> clientList) {
    }
}
