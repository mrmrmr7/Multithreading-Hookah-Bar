package service.builder;

import entity.Hookah;
import entity.HookahBar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HookahBarBuilderTest {

    @Test
    void buildTest() {
        int maxClientsInBar = 7;
        int withoutClients = 0;

        List<Hookah> hookahList = new ArrayList<>();
        hookahList.add(new Hookah());
        hookahList.add(new Hookah());

        HookahBarBuilder hookahBarBuilder = new HookahBarBuilder();
        HookahBar hookahBar = hookahBarBuilder.build(hookahList, maxClientsInBar);

        boolean isBuildedRight &= hookahBar.getClientsInBarMaxCount().equals(maxClientsInBar);
        isBuildedRight &= hookahBar.getClientsInBarNow().equals(withoutClients);
        isBuildedRight &= hookahBar.getHookahList().size().equals(hookahList.size());
        assertTrue(isBuildedRight);
    }
}