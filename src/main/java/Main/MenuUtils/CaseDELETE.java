package Main.MenuUtils;

import DAO.DAO;
import Main.Main;
import org.apache.logging.log4j.Logger;
import Main.ScannerGetter;

import java.sql.SQLException;
import java.util.Scanner;

public class CaseDELETE {

    public static Main.MenuOptions delete(Logger LOGGER, Scanner sc, GetDAO.AvailableOptions choice){
        Main.MenuOptions currentOption = Main.MenuOptions.ALL;
        DAO dao = GetDAO.getDAO(sc);
        choice = GetDAO.getChoice();
        if (dao != null) {
            LOGGER.info("Enter id:");
            int id = ScannerGetter.getInt(sc);
            try {
                dao.delete(id);
            } catch (SQLException ignored) {
            }
        }

        return currentOption;
    }
}
