package com.solvd.BuildingCompany.main;

import com.solvd.BuildingCompany.main.designPatterns.MyObserver;
import com.solvd.BuildingCompany.main.menuUtils.*;
import jdk.jfr.Unsigned;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        MyObserver m1 = new MyObserver();
        MyObserver m2 = new MyObserver();
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
}