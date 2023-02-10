package com.solvd.BuildingCompany.hierarchy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.solvd.BuildingCompany.main.json.CustomDateDeserializer;
import com.solvd.BuildingCompany.main.json.CustomDateSerializer;
import com.solvd.BuildingCompany.main.xml.DateAdapter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

@XmlRootElement(name = "project")
@XmlAccessorType (XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "name", "startingDate", "workers"})
@JsonRootName(value = "Project", namespace = "Projects")
public class Project {
    private Integer id;
    private String name;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
//    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date startingDate = new Date();

    private LinkedList<Worker> workers = new LinkedList<>();

    private Project() {
    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlAttribute
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

    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getStartingDate() {
        return startingDate;
    }


    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    @XmlElementWrapper(name = "workers")
    @XmlElement(name = "worker", type = Worker.class)
    public LinkedList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(LinkedList<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "\nProject{" + "id=" + id + ", name='" + name + '\'' + ", startingDate=" + sdf.format(startingDate) + '}';
    }

    public String simpleString() {
        return id + ", \"" + name + "\"";
    }

    public static Project Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        return new Project(MAX_ID.getMAX_ID("Projects") + 1, name);
    }




    public static Project.Builder builder() {
        return new Project().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Project.Builder setId(int id) {
            Project.this.id = id;
            return this;
        }

        public Project.Builder setName(String address) {
            Project.this.name = address;
            return this;
        }

        public Project build() {
            return Project.this;
        }
    }
}
