package entity;

import com.google.gson.annotations.SerializedName;

public class Hookah {
    @SerializedName("name")
    private String name;

    @SerializedName("cost")
    private long cost;

    @SerializedName("isFree")
    private boolean isFree = true;

    public Hookah() {
    }

    public Hookah(String name, long cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
