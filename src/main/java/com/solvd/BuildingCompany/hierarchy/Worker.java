package com.solvd.BuildingCompany.hierarchy;

import com.solvd.BuildingCompany.main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.util.Scanner;

@XmlRootElement(name = "worker")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "name", "age", "Projects_id"})
public class Worker {
    @XmlAttribute
    private Integer id;

    private String name;

    private Integer age;
    @XmlAttribute
    private Integer Projects_id;

    public Worker() {
    }

    public Worker(Integer id, String name, Integer age, Integer projects_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        Projects_id = projects_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(Integer projects_id) {
        Projects_id = projects_id;
    }

    public static Worker.Builder builder() {
        return new Worker().new Builder();
    }

    public class Builder {
        private Builder() {

        }
        public Worker.Builder setId(int id) {
            Worker.this.id = id;
            return this;
        }
        public Worker.Builder setName(String address) {
            Worker.this.name = address;
            return this;
        }
        public Worker.Builder setAge(int id) {
            Worker.this.age = id;
            return this;
        }
        public Worker.Builder setProjectsId(int id) {
            Worker.this.Projects_id = id;
            return this;
        }
        public Worker build() {
            return Worker.this;
        }
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

    public String simpleString() {
        return id + ", \"" + name + "\", " + age + ", " + Projects_id;
    }

    public static Worker Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        logger.info("Enter age:");
        int age = ScannerGetter.getInt(sc);
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new Worker(MAX_ID.getMAX_ID("Workers") + 1, name, age, Project_id);
    }
}
