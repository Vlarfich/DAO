package Hierarchy;

import Main.DateAdapter;
import Main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

@XmlRootElement(name = "project")
//@XmlAccessorType (XmlAccessType.FIELD)
//@XmlType(propOrder = {"id", "name", "startingDate", "workers"})
public class Project {
    private Integer id;
    private String name;
    private Date startingDate = new Date();


    private LinkedList<Worker> workers = new LinkedList<>();

    public Project() {
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Project{" + "id=" + id + ", name='" + name + '\'' + ", startingDate=" + sdf.format(startingDate) + '}';
    }

    public String simpleString() {
        return id + ", \"" + name + "\"";
    }

    public static Project Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        return new Project(MAX_ID.getMAX_ID("Projects") + 1, name);
    }
}
