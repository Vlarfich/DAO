import DAO.CustomerDAO;
import DAO.UniversalDAO;
import Hierarchy.Customer;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UniversalDAO userDAO = new UniversalDAO();
        List<List<Object>> l = Collections.singletonList(userDAO.findAll());
        for(List<Object> o : l){
            for(Object a : o){
                System.out.println(a + " ");
            }
            System.out.println();
        }

        CustomerDAO customerDAO = new CustomerDAO();
        System.out.println(customerDAO.findAll());
//        customerDAO.delete(6);
//        System.out.println(customerDAO.findAll());
        Customer customer = new Customer(4,"Max", "+375 888 77 66", "max@gmail.com", 3);
        customerDAO.update(customer);
        System.out.println(customerDAO.findAll());


    }
}