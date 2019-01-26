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

        if (!hookahBar.isFull()) {
            int freeHookah;
            hookahBar.addNowClientCount();
            System.out.println(name + " come in bar");
            freeHookah = hookahBar.getFreeHookah();
            if (freeHookah != AppConstant.NO_FREE_HOOKAH) {
                System.out.println(name + " smoke hookah");
                try {
                    Thread.sleep(100);
                    hookahBar.releaseHookah(freeHookah);
                } catch (InterruptedException e) {

                }
            } else {
                System.out.println(name + " sorry, but hooks are all used now");
            }
        } else {
            System.out.println(name + ", bar is full, please, wait");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
