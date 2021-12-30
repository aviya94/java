package com.example.robots.robot;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomUpdater {
    public Boolean isFail(double failPresent) {
        Random random = new Random();
        var value = random.nextDouble(100);
        if (value <= failPresent) {
            return true;
        }

        return false;
    }
}
