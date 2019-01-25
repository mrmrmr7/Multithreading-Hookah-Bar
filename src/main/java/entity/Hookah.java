package entity;

import com.google.gson.annotations.SerializedName;

public class Hookah {
    @SerializedName("name")
    String name;

    @SerializedName("cost")
    long cost;

    @SerializedName("isFree")
    boolean isFree;

    public Hookah() {
    }
}
