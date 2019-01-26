package service.builder;

import entity.Hookah;
import entity.HookahBar;
import util.AppConstant;

import java.util.List;
import java.util.concurrent.Semaphore;

public class HookahBarBuilder {
    public void configure(List<Hookah> hookahList, int maxCilentsInBar) {
        HookahBar hookahBar = HookahBar.getInstance();
        hookahBar.setHookahs(hookahList);
        hookahBar.setClientsInBarMaxCount(maxCilentsInBar);
        hookahBar.setBarSemaphore(new Semaphore(AppConstant.MAX_THREAD_COUNT, true));
        hookahBar.setHookahSemaphore(new Semaphore(hookahBar.getHookahs().size(), true));
    }
}
