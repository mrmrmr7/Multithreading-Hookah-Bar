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
        hookahBar.setClientsInBarNow(0);
        hookahBar.setBarSemaphore(new Semaphore(AppConstant.MAX_THREAD_COUNT));
        hookahBar.setHookahSemaphore(new Semaphore(hookahBar.getHookahs().size()));
    }
}
