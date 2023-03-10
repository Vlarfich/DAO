package com.solvd.BuildingCompany.hierarchy;

import com.solvd.BuildingCompany.main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MaterialSupplyCompany {
    private int id;
    private String name;
    private String phone;
    private String email;
    private int Buildings_id;
    private int Projects_id;

    private MaterialSupplyCompany(){};

    public MaterialSupplyCompany(int id, String name, String phone, String email, int buildings_id, int projects_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        Buildings_id = buildings_id;
        Projects_id = projects_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBuildings_id() {
        return Buildings_id;
    }

    public void setBuildings_id(int buildings_id) {
        Buildings_id = buildings_id;
    }

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    public static MaterialSupplyCompany.Builder builder() {
        return new MaterialSupplyCompany().new Builder();
    }

    public class Builder {
        private Builder() {

        }
        public MaterialSupplyCompany.Builder setId(int id) {
            MaterialSupplyCompany.this.id = id;
            return this;
        }
        public MaterialSupplyCompany.Builder setName(String model) {
            MaterialSupplyCompany.this.name = model;
            return this;
        }
        public MaterialSupplyCompany.Builder setPhone(String id) {
            MaterialSupplyCompany.this.phone = id;
            return this;
        }
        public MaterialSupplyCompany.Builder setEmail(String id) {
            MaterialSupplyCompany.this.email = id;
            return this;
        }
        public MaterialSupplyCompany.Builder setBuildingsId(int id) {
            MaterialSupplyCompany.this.Buildings_id = id;
            return this;
        }
        public MaterialSupplyCompany.Builder setProjectsId(int id) {
            MaterialSupplyCompany.this.Projects_id = id;
            return this;
        }

        public MaterialSupplyCompany build() {
            return MaterialSupplyCompany.this;
        }
    }
    @Override
    public String toString() {
        return "\nMaterialSupplyCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Buildings_id=" + Buildings_id +
                ", Projects_id=" + Projects_id +
                "}";
    }

    public String simpleString(){
        return id + ",\"" + name + "\", \"" + phone + "\", \"" + email + "\", " + Buildings_id + ", " + Projects_id;
    }

    public static MaterialSupplyCompany Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        logger.info("Enter phone:");
        String phone = sc.nextLine();
        logger.info("Enter email:");
        String email = sc.nextLine();
        logger.info("Enter Buildings_id:");
        int Buildings_id = ScannerGetter.getInt(sc);
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new MaterialSupplyCompany(MAX_ID.getMAX_ID("MaterialSupplyCompany"), name, phone, email, Buildings_id, Project_id);
    }
}
