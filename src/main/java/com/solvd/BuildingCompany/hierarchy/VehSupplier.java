package com.solvd.BuildingCompany.hierarchy;

import com.solvd.BuildingCompany.main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.lang.foreign.VaList;
import java.util.Scanner;

public class VehSupplier {
    private int id;
    private String name;
    private int Buildings_id;
    private VehSupplier(){};
    public VehSupplier(int id, String name, int projects_id) {
        this.id = id;
        this.name = name;
        Buildings_id = projects_id;
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


    public int getBuildings_id() {
        return Buildings_id;
    }

    public void setBuildings_id(int buildings_id) {
        Buildings_id = buildings_id;
    }

    public static VehSupplier.Builder builder() {
        return new VehSupplier().new Builder();
    }

    public class Builder {
        private Builder() {

        }
        public VehSupplier.Builder setId(int id) {
            VehSupplier.this.id = id;
            return this;
        }
        public VehSupplier.Builder setName(String address) {
            VehSupplier.this.name = address;
            return this;
        }
        public VehSupplier.Builder setBuildingsId(int id) {
            VehSupplier.this.Buildings_id = id;
            return this;
        }
        public VehSupplier build() {
            return VehSupplier.this;
        }
    }

    @Override
    public String toString() {
        return "\nVehSuppliers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Buildings_id=" + Buildings_id +
                '}';
    }

    public String simpleString(){
        return id + ",\"" + name + ", " + Buildings_id;
    }

    public static VehSupplier Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        logger.info("Enter Buildings_id:");
        int Buildings_id = ScannerGetter.getInt(sc);
        return new VehSupplier(MAX_ID.getMAX_ID("VehSuppliers"), name, Buildings_id);
    }
}
