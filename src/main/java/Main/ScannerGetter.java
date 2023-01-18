package Main;

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

}
