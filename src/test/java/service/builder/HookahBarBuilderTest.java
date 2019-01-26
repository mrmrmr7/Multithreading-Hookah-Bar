package service.builder;

import entity.Hookah;
import entity.HookahBar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HookahBarBuilderTest {

    @Test
    void configureTest() {
        int maxClientsInBar = 7;
        int withoutClients = 0;

        List<Hookah> hookahList = new ArrayList<>();
        hookahList.add(new Hookah());
        hookahList.add(new Hookah());

        HookahBarBuilder hookahBarBuilder = new HookahBarBuilder();
        hookahBarBuilder.configure(hookahList, maxClientsInBar);

        boolean isBuildedRight = true;
        isBuildedRight &= (HookahBar.getInstance().getClientsInBarMaxCount() == maxClientsInBar);
        isBuildedRight &= (HookahBar.getInstance().getClientsInBarNow() == withoutClients);
        isBuildedRight &= (HookahBar.getInstance().getHookahs().size() == hookahList.size());
        assertTrue(isBuildedRight);
    }
}