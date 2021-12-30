package com.example.robots.model;

import com.example.robots.annotation.RobotModel;
import com.example.robots.model.Model;
import com.example.robots.tool.Tool;
import org.springframework.beans.factory.BeanFactory;

import java.util.ArrayList;

@RobotModel
public class Tachikomas extends Model {

    public Tachikomas(BeanFactory beanFactory) {
        super(getTool(beanFactory));
    }

    private static ArrayList<Tool> getTool(BeanFactory beanFactory) {
        ArrayList<Tool> tools = new ArrayList<>();
        tools.add((Tool) beanFactory.getBean("LaserCutter"));
        tools.add((Tool) beanFactory.getBean("Disruptor"));
        return tools;
    }
}
