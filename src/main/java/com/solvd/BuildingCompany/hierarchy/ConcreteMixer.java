package com.solvd.BuildingCompany.hierarchy;

import com.solvd.BuildingCompany.main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ConcreteMixer {
    private int id;
    private String model;
    private int volume;
    private int Supplier_id;
    private int Projects_id;

    public ConcreteMixer(int id, String model, int volume, int supplier_id, int projects_id) {
        this.id = id;
        this.model = model;
        this.volume = volume;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    @Override
    public String toString() {
        return "\nConcreteMixer{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", volume=" + volume +
                ", Suppler_id=" + Supplier_id +
                ", Projects_id=" + Projects_id +
                '}';
    }

    public String simpleString(){
        return id + ",\"" + model + "\", " + volume + "\", " + Supplier_id + ", " + Projects_id;
    }

    public static ConcreteMixer Factory(Scanner sc, Logger logger) {
        logger.info("Enter model:");
        String model = sc.nextLine();
        logger.info("Enter volume:");
        int volume = ScannerGetter.getInt(sc);
        logger.info("Enter Supplier_id:");
        int Supplier_id = ScannerGetter.getInt(sc);
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new ConcreteMixer(MAX_ID.getMAX_ID("ConcreteMixers"), model, volume, Supplier_id, Project_id);
    }
}
