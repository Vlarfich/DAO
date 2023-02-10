package com.solvd.BuildingCompany.main.designPatterns;

public class Check {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new MyObserver(subject);

        subject.setState(1);
        subject.setState(2);
    }
}
