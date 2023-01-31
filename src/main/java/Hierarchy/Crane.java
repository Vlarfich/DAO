package Hierarchy;

import Main.ScannerGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@JsonRootName(value = "Customer")
public class Crane {
    private int id;
    private String model;
    private int height;
    private int Suppler_id;
    private int Projects_id;

    public Crane(int id, String model, int height, int suppler_id, int projects_id) {
        this.id = id;
        this.model = model;
        this.height = height;
        Suppler_id = suppler_id;
        Projects_id = projects_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSuppler_id() {
        return Suppler_id;
    }

    public void setSuppler_id(int suppler_id) {
        Suppler_id = suppler_id;
    }

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    @Override
    public String toString() {
        return "Crane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", height=" + height +
                ", Suppler_id=" + Suppler_id +
                ", Projects_id=" + Projects_id +
                '}' + "\n";
    }

    public String simpleString(){
        return id + ",\"" + model + "\", " + height + "\", " + Suppler_id + ", " + Projects_id;
    }

    public static Crane Factory(Scanner sc, Logger logger) {
        logger.info("Enter model:");
        String model = sc.nextLine();
        logger.info("Enter height:");
        int height = ScannerGetter.getInt(sc);
        logger.info("Enter Supplier_id:");
        int Supplier_id = ScannerGetter.getInt(sc);
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new Crane(MAX_ID.getMAX_ID("Cranes"), model, height, Supplier_id, Project_id);
    }
}
