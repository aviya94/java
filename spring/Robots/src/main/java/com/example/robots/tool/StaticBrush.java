package com.example.robots.tool;

import com.example.robots.annotation.RobotTool;

@RobotTool
public class StaticBrush extends Tool {
    @Override
    public void function() {
        updateStatus();
    }
}