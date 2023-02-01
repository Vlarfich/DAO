package main;

import DAO.myBatis.service.WorkerService;
import main.menuUtils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;


public class Main {
    public enum MenuOptions {
        ALL,
        PRINT,
        ADD,
        UPDATE,
        DELETE,
        EXIT
    }


    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static MenuOptions currentOption = MenuOptions.ALL;
    private static final GetDAO.AvailableOptions choice = null;


    public static void main(String[] args) {
        WorkerService workerService = new WorkerService();
        System.out.println(workerService.read(5));
        Menu();
    }

    /**
     * menu
     */
    private static void Menu() {
        Scanner sc = new Scanner(System.in);
        int c = ChooseDriver.getChoice(LOGGER, sc);
        GetDAO.setLOGGER(LOGGER);
        AtomicBoolean exit = new AtomicBoolean(false);
        while (!exit.get()) {
            switch (currentOption) {
                case ALL -> {
                    currentOption = CaseALL.all(LOGGER, sc);
                }
                case PRINT -> {
                    currentOption = CasePrint.print(LOGGER, sc, choice);
                }
                case ADD -> {
                    currentOption = CaseADD.add(LOGGER, sc, choice);
                }
                case UPDATE -> {
                    currentOption = CaseUPDATE.update(LOGGER, sc, choice);
                }
                case DELETE -> {
                    currentOption = CaseDELETE.delete(LOGGER, sc, choice);
                }
                case EXIT -> {
                    currentOption = CaseEXIT.exit(LOGGER, sc, choice, exit);
                }
                default -> {
                    throw new RuntimeException("INVALID ENUM CASE");
                }
            }
        }
        sc.close();
    }

//    private static DAO getDAO(Scanner sc) {
//        LOGGER.info("""
//
//                (1)  * PROJECT
//                (2)  * CUSTOMER
//                (3)  * WORKER
//                (4)  * PROJECT_MANAGER
//                (5)  * MATERIAL_SUPPLIERS
//                (6)  * CRANES
//                (7)  * CONCRETE_MIXERS
//                (8)  * BULLDOZERS
//                (9)  * VEH_SUPPLIERS
//                (10) * BUILDINGS
//                (0)  * BACK
//                """);
//        DAO dao = null;
//        int k = -1;
//        boolean validInt = false;
//        do {
//            try {
//                validInt = false;
//                k = Integer.parseInt(sc.nextLine());
//                validInt = true;
//            } catch (NumberFormatException e) {
//            }
//        } while (!validInt || k < 0 || k > 10);
//        switch (k) {
//            case 1 -> {
//                dao = new ProjectDAO();
//                choice = AvailableOptions.PROJECT;
//            }
//            case 2 -> {
//                dao = new CustomerDAO();
//                choice = AvailableOptions.CUSTOMER;
//            }
//            case 3 -> {
//                dao = new WorkerDAO();
//                choice = AvailableOptions.WORKER;
//            }
//            case 4 -> {
//                dao = new ProjectManagerDAO();
//                choice = AvailableOptions.PROJECT_MANAGER;
//            }
//            case 5 -> {
//                dao = new MaterialSupplyCompanyDAO();
//                choice = AvailableOptions.MATERIAL_SUPPLY_COMPANY;
//            }
//            case 6 -> {
//                dao = new CraneDAO();
//                choice = AvailableOptions.CRANE;
//            }
//            case 7 -> {
//                dao = new ConcreteMixerDAO();
//                choice = AvailableOptions.CONCRETE_MIXER;
//            }
//            case 8 -> {
//                dao = new BulldozerDAO();
//                choice = AvailableOptions.BULLDOZER;
//            }
//            case 9 -> {
//                dao = new VehSupplierDAO();
//                choice = AvailableOptions.VEH_SUPPLIER;
//            }
//            case 10 -> {
//                dao = new BuildingDAO();
//                choice = AvailableOptions.BUILDING;
//            }
//            default -> {
//                currentOption = MenuOptions.ALL;
//            }
//        }
//        return dao;
//    }

}