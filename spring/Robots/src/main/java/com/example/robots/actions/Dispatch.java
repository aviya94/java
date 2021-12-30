package com.example.robots.actions;

import com.example.robots.robot.Robot;

import java.util.concurrent.TimeUnit;

public class Dispatch extends Action implements Runnable {
    private Robot robot;

    public Dispatch(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void run() {
        System.out.println(toString());
        var time = randomNumber(30, 180);
        var timeToEnd = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(time);

        while (System.currentTimeMillis() < timeToEnd) {
            try {
                TimeUnit.MINUTES.sleep(timeToEnd - System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Robot" + robot.getName() + " is in active duty Dispatch";
    }
}
