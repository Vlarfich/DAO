package com.solvd.BuildingCompany.hierarchy;

import com.solvd.BuildingCompany.main.ScannerGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
@JsonRootName(value = "Customer")
public class Customer {
    private int id;
    private String name;
    private String phone;
    private String email;
    private int Projects_id;

    private Customer() {
    }

    @JsonCreator
    public Customer(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("phone") String phone,
                    @JsonProperty("email") String email, @JsonProperty("projects_id")int projects_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    public int getProjects_id() {
        return Projects_id;
    }

    public void setProjects_id(int projects_id) {
        Projects_id = projects_id;
    }

    public static Customer.Builder builder() {
        return new Customer().new Builder();
    }

    public class Builder {
        private Builder() {

        }
        public Customer.Builder setId(int id) {
            Customer.this.id = id;
            return this;
        }
        public Customer.Builder setName(String model) {
            Customer.this.name = model;
            return this;
        }
        public Customer.Builder setPhone(String id) {
            Customer.this.phone = id;
            return this;
        }
        public Customer.Builder setEmail(String id) {
            Customer.this.email = id;
            return this;
        }
        public Customer.Builder setProjectsId(int id) {
            Customer.this.Projects_id = id;
            return this;
        }

        public Customer build() {
            return Customer.this;
        }
    }
    @Override
    public String toString() {
        return "\nCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", Projects_id=" + Projects_id +
                "}";
    }

    public String simpleString() {
        return id + ",\"" + name + "\", \"" + phone + "\", \"" + email + "\", " + Projects_id;
    }

    public static Customer Factory(Scanner sc, Logger logger) {
        logger.info("Enter name:");
        String name = sc.nextLine();
        logger.info("Enter phone:");
        String phone = sc.nextLine();
        logger.info("Enter email:");
        String email = sc.nextLine();
        logger.info("Enter Projects_id:");
        int Project_id = ScannerGetter.getInt(sc);
        return new Customer(MAX_ID.getMAX_ID("Customers"), name, phone, email, Project_id);
    }

}
