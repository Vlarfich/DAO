package Hierarchy;

import Main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Project {
    private int id;
    private String name;

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String simpleString(){
        return id + ", \"" + name + "\"";
    }

    public static Project Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        return new Project(MAX_ID.getMAX_ID("Projects") + 1, name);
    }
}
