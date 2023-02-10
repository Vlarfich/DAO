package com.solvd.BuildingCompany.main.designPatterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyObserver extends SomeObserver {
    private final static Logger LOG = LogManager.getLogger(MyObserver.class);

    public MyObserver(Subject subject) {
        super.subject = subject;
        subject.attach(this);
    }
    @Override
    public void reactionOnAction() {
        LOG.info("state was changed");
    }
}
