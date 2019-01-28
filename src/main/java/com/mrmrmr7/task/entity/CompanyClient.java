package com.mrmrmr7.task.entity;

import com.google.gson.annotations.SerializedName;
import com.mrmrmr7.task.service.FreeHookahNotFoundException;
import com.mrmrmr7.task.service.HookahBarService;
import com.mrmrmr7.task.util.AppConstant;
import com.mrmrmr7.task.util.StringPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;
import java.util.List;

public class CompanyClient implements Client, Runnable {
    private final static Logger logger = LogManager.getLogger(CompanyClient.class);

    @SerializedName("liderName")
    private String liderName;

    private List<String> friends;

    @SerializedName("wantHookah")
    private Boolean wantHookah;

    @SerializedName("hookahName")
    private String hookahName;

    public CompanyClient(String liderName, List<String> friends, Boolean wantHookah, String hookahName) {
        this.liderName = liderName;
        this.wantHookah = wantHookah;
        this.hookahName = hookahName;
        this.friends = friends;
    }

    public CompanyClient(String liderName, List<String> friends, Boolean wantHookah) {
        this(liderName, friends, wantHookah, "any");
    }

    @Override
    public void run() {
        logger.info(MessageFormat.format(StringPool.FIND_BAR, liderName)
                + " and " + String.join(", ", friends));

        HookahBarService hookahBar = new HookahBarService();

        try {
            hookahBar.tryAddBarClient();
            logger.info(MessageFormat.format(StringPool.COME_TO_BAR, liderName));

            if (wantHookah) {
                int freeHookahNum = hookahBar.getFreeHookah(this.hookahName);

                logger.info(MessageFormat.format(StringPool.GET_HOOKAH, liderName, hookahBar.getHookahNameByNum(freeHookahNum)));

                Thread.sleep(AppConstant.TIME_OF_SMOKE);

                logger.info(MessageFormat.format(StringPool.RETURN_HOOKAH, liderName, hookahBar.getHookahNameByNum(freeHookahNum)));

                hookahBar.removeHookah(freeHookahNum);
            }

            hookahBar.removeBarClient();
            logger.info(MessageFormat.format(StringPool.LEAVE_BAR, liderName)
                    + " and " + String.join(", ", friends) + "\n"
                    + MessageFormat.format(StringPool.IN_BAR_NOW, hookahBar.getClientsInBarNow()));
        } catch (InterruptedException e) {
            hookahBar.removeBarClient();
            logger.error("Interrupted exception found");
        } catch (FreeHookahNotFoundException e) {
            hookahBar.removeBarClient();

            logger.info(MessageFormat.format(StringPool.LEAVE_BAR, liderName)
                    + " and " + String.join(", ", friends)
                    + " because they wait too much time");
            logger.info(MessageFormat.format(StringPool.IN_BAR_NOW, hookahBar.getClientsInBarNow()));
        } finally {
            Thread.currentThread().interrupt();
        }

    }
}
