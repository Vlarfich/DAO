package hierarchy;

import main.ScannerGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@JsonRootName(value = "Bulldozer")
public class Bulldozer {
    private int id;
    private String model;
    private int Suppler_id;
    private int Projects_id;

    public Bulldozer(int id, String model, int suppler_id, int projects_id) {
        this.id = id;
        this.model = model;
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
        return "\nBulldozer{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", Suppler_id=" + Suppler_id +
                ", Projects_id=" + Projects_id +
                '}';
    }

    public String simpleString(){
        return id + ",\"" + model + "\", " + Suppler_id + ", " + Projects_id;
    }

    public static Bulldozer Factory(Scanner sc, Logger logger) {
        logger.info("Enter model:");
        String name = sc.nextLine();
        logger.info("Enter Buildings_id:");
        int Buildings_id = ScannerGetter.getInt(sc);
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new Bulldozer(MAX_ID.getMAX_ID("Bulldozers") + 1, name, Buildings_id, Project_id);
    }
}
