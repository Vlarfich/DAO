package main;

import java.util.Scanner;

public class ScannerGetter {

    public static int getInt(Scanner sc){
        boolean validInt = false;
        int res = 0;
        do{
            try{
                res = Math.abs(Integer.parseInt(sc.nextLine()));
                validInt = true;
            } catch (NumberFormatException ignored) {
            }
        }while(!validInt);
        return res;
    }

    public static double getDouble(Scanner sc){
        boolean validDouble = false;
        double res = 0;
        do{
            try{
                res = Math.abs(Double.parseDouble(sc.nextLine()));
                validDouble = true;
            } catch (NumberFormatException ignored) {
            }
        }while(!validDouble);
        return res;
    }

    public static int getInt(Scanner sc, int min, int max){
        boolean validInt = false;
        int res = 0;
        do{
            try{
                res = Math.abs(Integer.parseInt(sc.nextLine()));
                validInt = true;
            } catch (NumberFormatException ignored) {
                validInt = false;
            }
        }while(!validInt || res < min || res > max);
        return res;
    }

}
