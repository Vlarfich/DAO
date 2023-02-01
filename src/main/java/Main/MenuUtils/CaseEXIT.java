package Main.MenuUtils;

import Main.Main;
import com.mysql.cj.util.StringUtils;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CaseEXIT {

    public static Main.MenuOptions exit(Logger LOGGER, Scanner sc, GetDAO.AvailableOptions choice, AtomicBoolean exit) {
        Main.MenuOptions currentOption = Main.MenuOptions.ALL;
        LOGGER.info("\n     * ARE YOU SURE (y/n):");
        char ch;
        do {
            ch = Character.toLowerCase(sc.nextLine().trim().charAt(0));
        } while (ch != 'y' && ch != 'n');
        switch (ch) {
            case 'y' -> {
                LOGGER.info("     * BYE...");
                exit.set(true);
            }
            case 'n' -> {
                currentOption = Main.MenuOptions.ALL;
            }
        }
        return currentOption;
    }
}
