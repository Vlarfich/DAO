package Hierarchy;

import Main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Scanner;

@XmlRootElement(name = "project")
@XmlType(propOrder = { "id", "name" })
public class Project {
    private Integer id;
    private String name;

    public Project(){
    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
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
