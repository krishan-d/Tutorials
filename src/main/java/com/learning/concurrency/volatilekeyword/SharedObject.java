package com.learning.concurrency.volatilekeyword;

public class SharedObject {
    private volatile int count = 0;

    void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
