package com.example.robots.actions;

import com.example.robots.robot.Robot;

import java.util.concurrent.TimeUnit;

public class Reboot extends Action implements Runnable {
    private Robot robot;

    public Reboot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void run() {

        System.out.println(toString());
        var time = randomNumber(1, 5);
        var timeToEnd = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(time);
        while (System.currentTimeMillis() < timeToEnd) {
            try {
                TimeUnit.MINUTES.sleep(timeToEnd-System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return "Robot" + robot.getName() + " is in active duty Reboot";
    }
}
