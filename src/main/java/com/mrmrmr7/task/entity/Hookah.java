package com.mrmrmr7.task.entity;

import com.google.gson.annotations.SerializedName;

import java.util.concurrent.atomic.AtomicInteger;

public class Hookah {
    @SerializedName("name")
    private String name;

    @SerializedName("cost")
    private long cost;

    @SerializedName("isFree")
    private AtomicInteger countFree;

    @SerializedName("count")
    private int countAll = 1;

    public Hookah() {
    }

    public Hookah(String name, long cost, int count) {
        this.name = name;
        this.cost = cost;
        this.countAll = count;
        this.countFree = new AtomicInteger(count);
    }

    public Hookah(String name, long cost) {
        this(name, cost, 1);
    }

    public int getCountFree() {
        return countFree.get();
    }

    public int getCountAll() {
        return countAll;
    }

    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public void incCountFree() {
        countFree.incrementAndGet();
    }

    public void decCountFree() {
        countFree.decrementAndGet();
    }

    @Override
    public String toString() {
        return "Hookah{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + countAll +
                '}';
    }
}
