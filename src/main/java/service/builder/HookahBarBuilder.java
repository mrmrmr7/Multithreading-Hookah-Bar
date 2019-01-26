package service.builder;

import entity.Hookah;
import entity.HookahBar;

import java.util.List;

public class HookahBarBuilder {
    public void configure(List<Hookah> hookahList, int maxCilentsInBar) {

        HookahBar hookahBar = HookahBar.getInstance();
        hookahBar.setHookahs(hookahList);
        hookahBar.setClientsInBarMaxCount(maxCilentsInBar);
        hookahBar.setClientsInBarNow(0);
    }
}
