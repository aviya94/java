package com.example.robots;

import com.example.robots.robot.Robot;
import com.example.robots.robot.RobotCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RobotsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RobotsApplication.class, args);
    }

    @Autowired
    RobotCollection m;
    @Autowired
    Robot robot;

    @Override
    public void run(String... args) throws Exception {
        m.add(robot);
        m.Dispatch(robot);
        m.Reboot(robot);
        System.out.println("a");

        try

        {
            TimeUnit.SECONDS.sleep(25000);
        } catch(
                InterruptedException e)

        {
            e.printStackTrace();
        }

    }

}

