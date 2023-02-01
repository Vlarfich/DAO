package Main.MenuUtils;

import DAO.DAO;
import Hierarchy.*;
import Main.Main;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CaseADD {

    public static Main.MenuOptions add(Logger LOGGER, Scanner sc, GetDAO.AvailableOptions choice){
        Main.MenuOptions currentOption = Main.MenuOptions.ADD;
        DAO dao = GetDAO.getDAO(sc);
        choice = GetDAO.getChoice();
        if (dao != null) {
            switch (choice) {
                case BUILDING -> {
                    Building building = Building.Factory(sc, LOGGER);
                    dao.create(building);
                }
                case BULLDOZER -> {
                    Bulldozer bulldozer = Bulldozer.Factory(sc, LOGGER);
                    dao.create(bulldozer);
                }
                case CUSTOMER -> {
                    Customer customer = Customer.Factory(sc, LOGGER);
                    dao.create(customer);
                }
                case CRANE -> {
                    Crane crane = Crane.Factory(sc, LOGGER);
                    dao.create(crane);
                }
                case CONCRETE_MIXER -> {
                    ConcreteMixer concreteMixer = ConcreteMixer.Factory(sc, LOGGER);
                    dao.create(concreteMixer);
                }
                case PROJECT -> {
                    Project project = Project.Factory(sc, LOGGER);
                    dao.create(project);
                }
                case PROJECT_MANAGER -> {
                    ProjectManager projectManager = ProjectManager.Factory(sc, LOGGER);
                    dao.create(projectManager);
                }
                case VEH_SUPPLIER -> {
                    VehSupplier vehSupplier = VehSupplier.Factory(sc, LOGGER);
                    dao.create(vehSupplier);
                }
                case MATERIAL_SUPPLY_COMPANY -> {
                    MaterialSupplyCompany materialSupplyCompany = MaterialSupplyCompany.Factory(sc, LOGGER);
                    dao.create(materialSupplyCompany);
                }
                case WORKER -> {
                    Worker worker = Worker.Factory(sc, LOGGER);
                    dao.create(worker);
                }
                default -> currentOption = Main.MenuOptions.ALL;
            }
        }
        return currentOption;
    }
}
