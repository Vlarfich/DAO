package com.solvd.BuildingCompany.hierarchy;

import com.solvd.BuildingCompany.main.ScannerGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@JsonRootName(value = "Bulldozer")
public class Bulldozer {
    private int id;
    private String model;
    private int Supplier_id;
    private int Projects_id;

    private Bulldozer(){};
    public Bulldozer(int id, String model, int supplier_id, int projects_id) {
        this.id = id;
        this.model = model;
        Supplier_id = supplier_id;
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

    public int getSupplier_id() {
        return Supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        Supplier_id = supplier_id;
    }

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    public static Builder builder() {
        return new Bulldozer().new Builder();
    }

    public class Builder {
        private Builder() {

        }
        public Bulldozer.Builder setId(int id) {
            Bulldozer.this.id = id;
            return this;
        }
        public Bulldozer.Builder setModel(String model) {
            Bulldozer.this.model = model;
            return this;
        }
        public Bulldozer.Builder setSupplierId(int id) {
            Bulldozer.this.Supplier_id = id;
            return this;
        }
        public Bulldozer.Builder setProjectsId(int id) {
            Bulldozer.this.Projects_id = id;
            return this;
        }

        public Bulldozer build() {
            return Bulldozer.this;
        }
    }

    @Override
    public String toString() {
        return "\nBulldozer{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", Suppler_id=" + Supplier_id +
                ", Projects_id=" + Projects_id +
                '}';
    }

    public String simpleString(){
        return id + ",\"" + model + "\", " + Supplier_id + ", " + Projects_id;
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
