package com.solvd.BuildingCompany.main.menuUtils;

import com.solvd.BuildingCompany.main.ScannerGetter;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ChooseDriver {

    public static int getChoice(Logger LOGGER, Scanner sc) {
        int choice = 0;
        LOGGER.info("""
                                
                (1)  * APACHE
                (2)  * MYBATIS
                """);
        choice = ScannerGetter.getInt(sc, 1, 2);
        if (choice == 2) {
            GetDAO.setMyBatis(true);
        }
        return choice;
    }
}
