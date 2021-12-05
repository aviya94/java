package com.experis.tests;

import java.util.Objects;

class TaskRunnable implements Runnable {
    private String str;

    public TaskRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println(str);
    }

}
