package com.example.robots.model;

import com.example.robots.annotation.RobotModel;
import com.example.robots.tool.Tool;
import com.example.robots.tool.ToolState;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;
@Getter
@RobotModel
public abstract class Model {
    private ArrayList<Tool> tools;

    public Model(ArrayList<Tool> tools) {
        this.tools=tools;
    }

    public Boolean isFail() {
        for (Tool t : tools) {
            if (t.getState() == ToolState.MALFUNCTION) {
                return true;
            }

        }
        return false;
    }
}
