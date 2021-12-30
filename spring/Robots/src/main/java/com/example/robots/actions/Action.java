package com.example.robots.actions;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Action {

    protected int randomNumber(int from,int to){
        Random random=new Random();
       return random.nextInt(from,to);
    }
}
