package Main;

import Hierarchy.Customer;
import Hierarchy.MAX_ID;
import Hierarchy.Project;
import Hierarchy.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Jackson {
    public static void main(String[] args) throws IOException {
        String json = (new BufferedReader(new FileReader("Customer.json"))).readLine();
        System.out.println(json);

        Customer customer = new Customer(MAX_ID.getMAX_ID("Customers"), "Vlad", "+375 22 222 22",
                "vladzhu607@gmail.com", 2);

        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(customer);
        System.out.println(result);

        Customer c2 = new ObjectMapper().readerFor(Customer.class).readValue(json);
        System.out.println(c2);

        Worker worker = new Worker(MAX_ID.getMAX_ID("Workers"), "Henry", 22, 2);
        String workerResult = mapper.writeValueAsString(worker);
        System.out.println(workerResult);

        Project project = new Project(MAX_ID.getMAX_ID("Projects"), "Collyseum");
        project.addWorker(worker);
        project.addWorker(worker);

        String projectResult = mapper.writeValueAsString(project);
        System.out.println(projectResult);

        String projectJSON = (new BufferedReader(new FileReader("Project.json"))).readLine();
        Project project1 = new ObjectMapper().readerFor(Project.class).readValue(projectJSON);
        System.out.println(project1);
        for (Worker w : project1.getWorkers()) {
            System.out.println(w);
        }
    }
}
