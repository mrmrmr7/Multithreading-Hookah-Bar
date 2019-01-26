package com.mrmrmr7.task.entity;

import com.google.gson.annotations.SerializedName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mrmrmr7.task.service.FreeHookahNotFoundException;
import com.mrmrmr7.task.service.HookahBarService;
import com.mrmrmr7.task.util.AppConstant;
import com.mrmrmr7.task.util.StringPool;

import java.text.MessageFormat;
import java.util.Objects;

public class Client implements Runnable {
    private Logger logger = LogManager.getLogger(Client.class);

    @SerializedName("name")
    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        logger.info(MessageFormat.format(StringPool.FIND_BAR, name));
        HookahBarService hookahBar = new HookahBarService();

        try {
            hookahBar.addBarClient();
            logger.info(MessageFormat.format(StringPool.COME_TO_BAR, name));
        } catch (InterruptedException e) {
            logger.error("Interrupted exception fouid");
        }

        int freeHookahNum = 0;

        try {
            freeHookahNum = hookahBar.getFreeHookah();
            logger.info(MessageFormat.format(StringPool.GET_HOOKAH, name, hookahBar.getHookahNameByNum(freeHookahNum)));
        } catch (InterruptedException e) {
            logger.error("Interrupted exception found");
        } catch (FreeHookahNotFoundException e) {
            logger.error("Free hookah not found");
        }

        try {
            Thread.sleep(AppConstant.TIME_OF_SMOKE);
        } catch (InterruptedException e) {
            logger.error("Interrupted exception found");
        }

        logger.info(MessageFormat.format(StringPool.RETURN_HOOKAH, name, hookahBar.getHookahNameByNum(freeHookahNum)));
        hookahBar.removeHookah(freeHookahNum);
        hookahBar.removeBarClient();
        logger.info(MessageFormat.format(StringPool.LEAVE_BAR, name));
        logger.info(MessageFormat.format(StringPool.IN_BAR_NOW, hookahBar.getClientsInBarNow()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(logger, client.logger) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logger, name);
    }
}
