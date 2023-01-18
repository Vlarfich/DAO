package Hierarchy;

import Main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Worker {
    private int id;
    private String name;
    private int age;
    private int Projects_id;

    public Worker(int id, String name, int age, int projects_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        Projects_id = projects_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    @Override
    public String toString() {
        return "\nWorker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Projects_id=" + Projects_id +
                '}';
    }

    public String simpleString(){
        return "\"" + name + "\", " +age + ", " + Projects_id;
    }

    public static Worker Factory(Scanner sc, Logger logger){
        logger.info("Enter name:");
        String name = sc.nextLine();
        logger.info("Enter age:");
        int age = ScannerGetter.getInt(sc);
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new Worker(0, name, age, Project_id);
    }
}
