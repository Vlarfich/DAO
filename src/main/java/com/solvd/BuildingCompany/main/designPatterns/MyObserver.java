package com.solvd.BuildingCompany.main.designPatterns;

import com.solvd.BuildingCompany.hierarchy.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyObserver extends SomeObserver {
    private final static Logger LOG = LogManager.getLogger(MyObserver.class);
    public MyObserver() {
        Project.attach(this);
    }
    @Override
    public void reactionOnAction() {
        System.err.println(" ------------------------------");
        LOG.info(" *  !!!  PROJECT CREATED  !!!  *");
    }
}
