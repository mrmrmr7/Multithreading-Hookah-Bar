package com.mrmrmr7.task.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hookah hookah = (Hookah) o;
        return cost == hookah.cost &&
                isFree == hookah.isFree &&
                Objects.equals(name, hookah.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, isFree);
    }

    @Override
    public String toString() {
        return "Hookah{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", isFree=" + isFree +
                '}';
    }
}
