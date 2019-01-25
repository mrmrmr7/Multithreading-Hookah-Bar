package entity;

import com.google.gson.annotations.SerializedName;

public class Client implements Runnable{
    @SerializedName("name")
    String name;

    public Client(String name) {
    }

    @Override
    public void run() {

    }
}
