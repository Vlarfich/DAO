package com.solvd.BuildingCompany.hierarchy;

import com.solvd.BuildingCompany.main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ProjectManager {
    private int id;
    private String name;
    private int age;
    private int Projects_id;
    private ProjectManager(){};

    public ProjectManager(int id, String name, int age, int projects_id) {
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

    public static ProjectManager.Builder builder() {
        return new ProjectManager().new Builder();
    }

    public class Builder {
        private Builder() {

        }
        public ProjectManager.Builder setId(int id) {
            ProjectManager.this.id = id;
            return this;
        }
        public ProjectManager.Builder setName(String address) {
            ProjectManager.this.name = address;
            return this;
        }
        public ProjectManager.Builder setAge(int id) {
            ProjectManager.this.age = id;
            return this;
        }
        public ProjectManager.Builder setProjectsId(int id) {
            ProjectManager.this.Projects_id = id;
            return this;
        }
        public ProjectManager build() {
            return ProjectManager.this;
        }
    }

    @Override
    public String toString() {
        return "\nProjectManager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", Projects_id=" + Projects_id +
                '}';
    }

    public String simpleString(){
        return id + ",\"" + name + "\", " +age + "\", " + Projects_id;
    }

    public static ProjectManager Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        logger.info("Enter age:");
        int age = ScannerGetter.getInt(sc);
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new ProjectManager(MAX_ID.getMAX_ID("ProjectManager"), name, age, Project_id);
    }
}
