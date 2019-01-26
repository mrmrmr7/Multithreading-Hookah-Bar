package entity;

import com.google.gson.annotations.SerializedName;
import com.sun.xml.internal.ws.api.message.Message;
import util.StringPool;

import javax.annotation.processing.Messager;
import java.text.MessageFormat;

public class Client implements Runnable {
    @SerializedName("name")
    String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(MessageFormat.format(StringPool.FIND_BAR, name));
        HookahBar hookahBar = HookahBar.getInstance();

        try {
            hookahBar.addBarClient();
            System.out.println(MessageFormat.format(StringPool.COME_TO_BAR, name));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int num = 0;

        try {
            num = hookahBar.getHookah();
            System.out.println(MessageFormat.format(StringPool.GET_HOOKAH, name, num));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(MessageFormat.format(StringPool.LEAVE_BAR, name));
        hookahBar.removeHookah(num);
        hookahBar.removeBarClient();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
