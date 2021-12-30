package com.example.robots.tool;

import com.example.robots.annotation.RobotTool;
import com.example.robots.robot.RandomUpdater;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@Setter
@RobotTool
public abstract class Tool {
    private ToolState state = ToolState.READY;


    public abstract void function();

    @Autowired
    protected RandomUpdater randomUpdater;

    protected void updateStatus() {
        if (randomUpdater.isFail(20)) {
            state = ToolState.MALFUNCTION;
        }
    }

}
