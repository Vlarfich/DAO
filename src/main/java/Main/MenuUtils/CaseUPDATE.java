package Main.MenuUtils;

import DAO.DAO;
import Hierarchy.*;
import Main.Main;
import org.apache.logging.log4j.Logger;
import Main.ScannerGetter;

import java.util.Scanner;

public class CaseUPDATE {


    public static Main.MenuOptions update(Logger LOGGER, Scanner sc, GetDAO.AvailableOptions choice){
        Main.MenuOptions currentOption = Main.MenuOptions.UPDATE;
        DAO dao = GetDAO.getDAO(sc);
        choice = GetDAO.getChoice();
        if (dao != null) {
            LOGGER.info("Enter id:");
            int id = ScannerGetter.getInt(sc);
            System.out.println(choice.name());
            switch (choice) {
                case BUILDING -> {
                    LOGGER.info("Enter new address:");
                    String address = sc.nextLine();
                    dao.update(new Building(id, address));
                }
                case BULLDOZER -> {
                    LOGGER.info("Enter new model:");
                    String model = sc.nextLine();
                    dao.update(new Bulldozer(id, model, 0, 0));
                }
                case CUSTOMER -> {
                    LOGGER.info("Enter new email:");
                    String email = sc.nextLine();
                    dao.update(new Customer(id, "", "", email, 0));
                }
                case CRANE -> {
                    LOGGER.info("Enter new model:");
                    String model = sc.nextLine();
                    dao.update(new Crane(id, model, 0, 0, 0));
                }
                case CONCRETE_MIXER -> {
                    LOGGER.info("Enter new model:");
                    String model = sc.nextLine();
                    dao.update(new ConcreteMixer(id, model, 0, 0, 0));
                }
                case PROJECT -> {
                    LOGGER.info("Enter new name:");
                    String name = sc.nextLine();
                    dao.update(new Project(id, name));
                }
                case PROJECT_MANAGER -> {
                    LOGGER.info("Enter new name:");
                    String name = sc.nextLine();
                    dao.update(new ProjectManager(id, name, 0, 0));
                }
                case VEH_SUPPLIER -> {
                    LOGGER.info("Enter new name:");
                    String name = sc.nextLine();
                    dao.update(new VehSupplier(id, name, 0));
                }
                case MATERIAL_SUPPLY_COMPANY -> {
                    LOGGER.info("Enter new name:");
                    String name = sc.nextLine();
                    dao.update(new MaterialSupplyCompany(id, name, "", "", 0, 0));
                }
                case WORKER -> {
                    LOGGER.info("Enter new name:");
                    String name = sc.nextLine();
                    dao.update(new Worker(id, name, 0, 0));
                }
                default -> currentOption = Main.MenuOptions.ALL;
            }
            //currentOption = Main.MenuOptions.ALL;
        }
        return currentOption;
    }
}
