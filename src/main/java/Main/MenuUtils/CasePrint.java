package Main.MenuUtils;

import DAO.DAO;
import Main.Main;
import com.mysql.cj.util.StringUtils;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Scanner;

public class CasePrint {


    public static Main.MenuOptions print(Logger LOGGER, Scanner sc, GetDAO.AvailableOptions choice) {
        Main.MenuOptions currentOption = Main.MenuOptions.PRINT;
        DAO dao = GetDAO.getDAO(sc);
        choice = GetDAO.getChoice();
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
                    k = Integer.parseInt(sc.nextLine());
                    validInt = true;
                } catch (NumberFormatException e) {
                    validInt = false;
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
                default -> currentOption = Main.MenuOptions.PRINT;
            }
        }
        return currentOption;
    }
}
