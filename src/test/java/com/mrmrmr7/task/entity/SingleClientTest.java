package com.mrmrmr7.task.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleClientTest {

    @Test
    void toStringTest() {
        SingleClient singleClient = new SingleClient("Artur", true, "Mint");
        String actual = singleClient.toString();
        String expected = "SingleClient{name='Artur'}";
        assertEquals(actual,expected);
    }

    @Test
    void equalsTest() {
        SingleClient singleClient1 = new SingleClient("Artur", true, "Mint");
        SingleClient singleClient2 = new SingleClient("Artur", true, "Mint");
        assertTrue(singleClient1.equals(singleClient2));
    }

    @Test
    void hashCodeTest() {
        SingleClient singleClient1 = new SingleClient("Artur", true, "Mint");
        SingleClient singleClient2 = new SingleClient("Artur", true, "Mint");
        assertEquals(singleClient1.hashCode(),singleClient2.hashCode());
    }
}