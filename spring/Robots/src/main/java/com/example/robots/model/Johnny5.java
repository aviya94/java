package com.example.robots.model;

import com.example.robots.annotation.RobotModel;
import com.example.robots.tool.Tool;
import org.springframework.beans.factory.BeanFactory;

import java.util.ArrayList;

@RobotModel
public class Johnny5 extends Model {

    public Johnny5(BeanFactory beanFactory) {
        super(getTool(beanFactory));
    }

    private static ArrayList<Tool> getTool(BeanFactory beanFactory) {
        ArrayList<Tool> tools = new ArrayList<>();
        tools.add((Tool) beanFactory.getBean("LaserCutter"));
        tools.add((Tool) beanFactory.getBean("StaticBrush"));
        return tools;
    }
}
