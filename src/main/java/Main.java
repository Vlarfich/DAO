import DAO.CustomerDAO;

public class Main {
    public static void main(String[] args) {
        CustomerDAO userDAO = new CustomerDAO();
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.findEntityById(1));
    }
}