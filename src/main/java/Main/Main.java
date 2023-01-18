package Main;

import DAO.*;
import Hierarchy.Building;
import Hierarchy.Customer;
import Hierarchy.Project;
import Hierarchy.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    enum MenuOptions {
        ALL,
        PRINT,
        ADD,
        UPDATE,
        DELETE,
        EXIT
    }

    enum AvailableOptions {
        PROJECT,
        CUSTOMER,
        WORKER,
        PROJECT_MANAGER,
        MATERIAL_SUPPLY_COMPANY,
        CRANE,
        CONCRETE_MIXER,
        BULLDOZER,
        VEH_SUPPLIER,
        BUILDING
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static MenuOptions currentOption = MenuOptions.ALL;
    private static AvailableOptions choice = null;


    public static void main(String[] args) {
        Menu();
    }


    private static void Menu() {
        int c;
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            switch (currentOption) {
                case ALL -> {
                    LOGGER.info("""
                                                    
                            (1)  * PRINT
                            (2)  * ADD
                            (3)  * UPDATE
                            (4)  * DELETE
                            (0)  * EXIT
                            """);
                    boolean validInt = false;
                    c = -1;
                    do {
                        try {
                            validInt = false;
                            c = Integer.parseInt(sc.nextLine());
                            validInt = true;
                        } catch (NumberFormatException e) {
                        }
                    } while (!validInt || c < 0 || c > 4);

                    switch (c) {
                        case 1 -> currentOption = MenuOptions.PRINT;
                        case 2 -> currentOption = MenuOptions.ADD;
                        case 3 -> currentOption = MenuOptions.UPDATE;
                        case 4 -> currentOption = MenuOptions.DELETE;
                        case 0 -> {
                            currentOption = MenuOptions.EXIT;
                        }
                        default -> currentOption = MenuOptions.ALL;
                    }


                }
                case PRINT -> {
                    DAO dao = getDAO(sc);
                    if (dao != null) {
                        LOGGER.info("""
                                            
                                (1)  * PRINT ALL
                                (2)  * PRINT BY ID
                                (0)  * BACK
                                """);
                        boolean validInt = false;
                        int k = -1;
                        do {
                            try {
                                validInt = false;
                                k = Integer.parseInt(sc.nextLine());
                                validInt = true;
                            } catch (NumberFormatException e) {
                            }
                        } while (!validInt || k < 0 || k > 2);
                        switch (k) {
                            case 1 -> {
                                LOGGER.info(dao.findAll());
                            }
                            case 2 -> {
                                LOGGER.info(" ENTER ID:");
                                k = sc.nextInt();
                                LOGGER.info(dao.findEntityById(k));
                            }
                            default -> currentOption = MenuOptions.PRINT;
                        }
                    }
                }
                case ADD -> {
                    DAO dao = getDAO(sc);
                    if (dao != null) {
                        switch (choice) {
                            case PROJECT -> {
                                Project project = new Project(0, "HAHAHAH");
                                dao.create(project);
                            }
                            case CUSTOMER -> {
                                Customer customer = new Customer(0, "NEW CUSTOMER", "+375 000 00 00", "newCustomer@gmail.com", 2);
                                dao.create(customer);
                            }
                            case WORKER -> {
                                Worker worker = Worker.Factory(sc, LOGGER);
                                dao.create(worker);
                            }


                            case BUILDING ->{
                                Building building = Building.Factory(sc, LOGGER);
                                dao.create(building);
                            }
                        }
                    }
                }
                case UPDATE -> {
                    DAO dao = getDAO(sc);
                }
                case DELETE -> {
                    DAO dao = getDAO(sc);
                    if (dao != null) {
                        LOGGER.info("Enter id:");
                        int id = ScannerGetter.getInt(sc);
                        try {
                            dao.delete(id);
                        } catch (SQLException ignored) {
                        }
                    }
                }
                case EXIT -> {
                    LOGGER.info("\n     * ARE YOU SURE (y/n):");
                    char ch = Character.toLowerCase(sc.nextLine().trim().charAt(0));
                    switch (ch) {
                        case 'y' -> {
                            LOGGER.info("     * BYE...");
                            exit = true;
                        }
                        case 'n' -> {
                            currentOption = MenuOptions.ALL;
                        }
                    }
                }
                default -> {
                    throw new RuntimeException("INVALID ENUM CASE");
                }
            }

        }
        sc.close();
    }

    private static DAO getDAO(Scanner sc) {
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
                (0) * BACK
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
                currentOption = MenuOptions.ALL;
            }
        }
        return dao;
    }


}