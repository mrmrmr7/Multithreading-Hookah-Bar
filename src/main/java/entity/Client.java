package entity;

import com.google.gson.annotations.SerializedName;

public class Client implements Runnable {
    @SerializedName("name")
    String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " find bar");
        HookahBar hookahBar = HookahBar.getInstance();

        try {
            hookahBar.addBarClient();
            System.out.println(name + " come in bar");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int num = 0;

        try {
            num = hookahBar.getHookah();
            System.out.println(name + " get hookah " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " release hookah");
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
