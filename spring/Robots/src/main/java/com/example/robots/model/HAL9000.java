package com.example.robots.model;

import com.example.robots.annotation.RobotModel;
import com.example.robots.tool.Tool;
import org.springframework.beans.factory.BeanFactory;

import java.util.ArrayList;

@RobotModel
public class HAL9000 extends Model {

    public HAL9000(BeanFactory beanFactory) {
        super(getTool(beanFactory));
    }

    private static ArrayList<Tool> getTool(BeanFactory beanFactory) {
        ArrayList<Tool> tools = new ArrayList<>();
        tools.add((Tool) beanFactory.getBean("laserCutter"));
        tools.add((Tool) beanFactory.getBean("replicator"));
        tools.add((Tool) beanFactory.getBean("disruptor"));
        return tools;
    }
}
