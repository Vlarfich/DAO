package com.solvd.BuildingCompany.hierarchy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Building {
    private int id;
    @JsonProperty("name")
    private String address;
    @JsonCreator
    public Building(int id, @JsonProperty("name") String address) {
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nBuilding{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    public String simpleString(){
        return id + ", \"" + address + "\"";
    }

    public static Building Factory(Scanner sc, Logger logger){
        logger.info("Enter name:");
        String address = sc.nextLine();
        return new Building(MAX_ID.getMAX_ID("Buildings") + 1, address);
    }
}
