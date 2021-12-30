package com.example.robots.robot;

import com.example.robots.config.RobotConfigProperties;
import com.example.robots.model.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Setter
@Getter
@Component
@Scope("prototype")
public class Robot {
    private final String name;
    private final String callSign;
    private final Model model;
    private RobotState state;
    @Autowired
    private RandomUpdater randomUpdater;

    private Model getModel(BeanFactory beanFactory, String model) {
        return (Model) beanFactory.getBean(model);
    }

    public Robot(RobotConfigProperties robotConfigProperties, BeanFactory beanFactory) {
        this.name = robotConfigProperties.getName();
        this.callSign = robotConfigProperties.getCallSign();
        this.model = getModel(beanFactory, robotConfigProperties.getModel());

    }

    @PostConstruct
    private void updateState() {
        if (randomUpdater.isFail(20)) {
            state = RobotState.FAILING;
        }
        state = RobotState.ACTIVE;
    }

    public void isFail() {
        if (model.isFail() == true) {
            state = RobotState.FAILING;
        }
    }

    public void updateState(RobotState robotState) {
        this.state = robotState;
    }
}
