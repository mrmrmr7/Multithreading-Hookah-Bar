package entity;

import com.google.gson.annotations.SerializedName;
import util.AppConstant;

public class Client implements Runnable {
    @SerializedName("name")
    String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " find bar!");
        HookahBar hookahBar = HookahBar.getInstance();

        try {
            hookahBar.addBarClient();
            System.out.println(name + " come in bar");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            hookahBar.addHookahClient();
            System.out.println(name + " get hookah");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hookahBar.removeHookahClient();
        hookahBar.removeBarClient();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
