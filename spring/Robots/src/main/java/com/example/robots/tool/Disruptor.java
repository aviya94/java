package com.example.robots.tool;

import com.example.robots.annotation.RobotTool;

@RobotTool
public class Disruptor extends Tool {
    @Override
    public void function() {
        updateStatus();
    }
}
