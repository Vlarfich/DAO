package Hierarchy;

import Main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Building {
    private int id;
    private String address;

    public Building(int id, String address) {
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
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}' + "\n";
    }

    public String simpleString(){
        return "\"" + address + "\"";
    }

    public static Building Factory(Scanner sc, Logger logger){
        logger.info("Enter name:");
        String address = sc.nextLine();
        return new Building(0, address);
    }
}
