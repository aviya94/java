package com.example.robots.robot;

import com.example.robots.actions.Action;
import com.example.robots.actions.Dispatch;
import com.example.robots.actions.Reboot;
import com.example.robots.actions.SelfDiagnostics;
import com.example.robots.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class RobotCollection {
    private ArrayList<Robot> robots = new ArrayList<>();
    Lock lock=new ReentrantLock();

    public void add(Robot robot) {
        robots.add(robot);
    }

    public void Dispatch(Robot robot) {
        if (robots.contains(robot)) {
            robot.updateState(RobotState.WORKING);
            run(robot, new Dispatch(robot));
            robot.updateState(RobotState.ACTIVE);
        }
    }


    public void Reboot(Robot robot) {
        if (robots.contains(robot)) {
            robot.updateState(RobotState.REBOOTING);
            run(robot, new Reboot(robot));
            robot.updateState(RobotState.ACTIVE);
        }
    }

    public void SelfDiagnostics(Robot robot) {
        RandomUpdater randomUpdater=new RandomUpdater();
        if (robots.contains(robot)) {
            if (robot.getState() == RobotState.FAILING) {
                run(robot, new SelfDiagnostics(robot));
            }
            if(!randomUpdater.isFail(10)){
                robot.setState(RobotState.ACTIVE);
            }
        }

    }

    private void run(Robot robot, Action action) {
        lock.lock();
            Thread thread = new Thread((Runnable) action);
            thread.run();
    //    try {
           // thread.join();
      //  } catch (InterruptedException e) {
      //      e.printStackTrace();
      //  }
        lock.unlock();
    }


    public Boolean Delete(Robot robot) {
        return robots.remove(robot);
    }

}
