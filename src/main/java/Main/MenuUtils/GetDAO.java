package Main.MenuUtils;

import DAO.DAO;
import DAO.JavaSQL.*;
import Main.Main;
import org.apache.logging.log4j.Logger;

import java.lang.ref.Reference;
import java.util.Scanner;

public class GetDAO {
    public     enum AvailableOptions {
        PROJECT,
        CUSTOMER,
        WORKER,
        PROJECT_MANAGER,
        MATERIAL_SUPPLY_COMPANY,
        CRANE,
        CONCRETE_MIXER,
        BULLDOZER,
        VEH_SUPPLIER,
        BUILDING,
        BACK
    }
    private static Logger LOGGER;
    private static boolean myBatis = false;
    private static GetDAO.AvailableOptions choice = GetDAO.AvailableOptions.BACK;

    public static GetDAO.AvailableOptions getChoice(){
        return choice;
    }

    private static void setMyBatis(boolean f){
        myBatis = f;
    }


    public static DAO getDAO(Scanner sc) {
        LOGGER.info("""
                                
                (1)  * PROJECT
                (2)  * CUSTOMER
                (3)  * WORKER
                (4)  * PROJECT_MANAGER
                (5)  * MATERIAL_SUPPLIERS
                (6)  * CRANES
                (7)  * CONCRETE_MIXERS
                (8)  * BULLDOZERS
                (9)  * VEH_SUPPLIERS
                (10) * BUILDINGS
                (0)  * BACK
                """);
        DAO dao = null;
        int k = -1;
        boolean validInt = false;
        do {
            try {
                validInt = false;
                k = Integer.parseInt(sc.nextLine());
                validInt = true;
            } catch (NumberFormatException e) {
            }
        } while (!validInt || k < 0 || k > 10);
        switch (k) {
            case 1 -> {
                dao = new ProjectDAO();
                choice = AvailableOptions.PROJECT;
            }
            case 2 -> {
                dao = new CustomerDAO();
                choice = AvailableOptions.CUSTOMER;
            }
            case 3 -> {
                dao = new WorkerDAO();
                choice = AvailableOptions.WORKER;
            }
            case 4 -> {
                dao = new ProjectManagerDAO();
                choice = AvailableOptions.PROJECT_MANAGER;
            }
            case 5 -> {
                dao = new MaterialSupplyCompanyDAO();
                choice = AvailableOptions.MATERIAL_SUPPLY_COMPANY;
            }
            case 6 -> {
                dao = new CraneDAO();
                choice = AvailableOptions.CRANE;
            }
            case 7 -> {
                dao = new ConcreteMixerDAO();
                choice = AvailableOptions.CONCRETE_MIXER;
            }
            case 8 -> {
                dao = new BulldozerDAO();
                choice = AvailableOptions.BULLDOZER;
            }
            case 9 -> {
                dao = new VehSupplierDAO();
                choice = AvailableOptions.VEH_SUPPLIER;
            }
            case 10 -> {
                dao = new BuildingDAO();
                choice = AvailableOptions.BUILDING;
            }
            default -> {
                choice = AvailableOptions.BACK;
                //currentOption = Main.Main.MenuOptions.ALL;
            }
        }
        return dao;
    }

    public static GetDAO setLOGGER(Logger LOGGER) {
        GetDAO.LOGGER = LOGGER;
        return new GetDAO();
    }
}
