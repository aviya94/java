package com.example.robots.actions;

import com.example.robots.robot.Robot;

import com.example.robots.tool.ToolState;

public class SelfDiagnostics extends Action implements Runnable {
    private Robot robot;

    public SelfDiagnostics(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void run() {
        System.out.println(toString());
        var tools= robot.getModel().getTools();

        for (int i = 0; i < tools.size(); i++) {
            var tool= tools.get(i);
            gi
            if(tool.getState().equals(ToolState.MALFUNCTION)){
                tool.setState(ToolState.READY);
            }
        }
    }

    public String toString() {
        return "Robot" + robot.getName() + " is in active duty SelfDiagnostics";
    }
}
