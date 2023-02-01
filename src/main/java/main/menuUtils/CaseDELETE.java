package main.menuUtils;

import DAO.DAO;
import main.Main;
import org.apache.logging.log4j.Logger;
import main.ScannerGetter;

import java.util.Scanner;

public class CaseDELETE {

    public static Main.MenuOptions delete(Logger LOGGER, Scanner sc, GetDAO.AvailableOptions choice){
        Main.MenuOptions currentOption = Main.MenuOptions.ALL;
        DAO dao = GetDAO.getDAO(sc);
        choice = GetDAO.getChoice();
        if (dao != null) {
            LOGGER.info("Enter id:");
            int id = ScannerGetter.getInt(sc);
            dao.delete(id);
        }

        return currentOption;
    }
}
