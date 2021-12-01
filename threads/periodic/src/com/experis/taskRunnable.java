package com.experis;

public class taskRunnable implements Runnable{
    private String str;

    public taskRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println(str);
    }
}
