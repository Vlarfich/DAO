package Main;

import Hierarchy.Customer;
import Hierarchy.MAX_ID;
import Hierarchy.Project;
import Hierarchy.Worker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Jackson {
    public static void main(String[] args) throws IOException {
        Customer customer = new Customer(MAX_ID.getMAX_ID("Customers"), "Vlad", "+375 22 222 22",
                "vladzhu607@gmail.com", 2);

        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(customer);
        System.out.println(result);

        Customer c2 = new ObjectMapper().readerFor(Customer.class).readValue(new File("Customer.json"));
        System.out.println(c2);

        Worker worker = new Worker(MAX_ID.getMAX_ID("Workers"), "Henry", 22, 2);
        String workerResult = mapper.writeValueAsString(worker);
        System.out.println(workerResult);

        Project project = new Project(MAX_ID.getMAX_ID("Projects"), "Coliseum");
        project.addWorker(worker);
        project.addWorker(worker);

        String projectResult = mapper.enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(project);
        System.out.println(projectResult);

        LinkedList<Project> projects = new LinkedList<>();
        projects.add(project);
        projects.add(project);
        System.out.println(mapper.disable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(projects));


        Project project1 = new ObjectMapper().readerFor(Project.class).readValue(new File("Project.json"));
        System.out.println(project1);
        for (Worker w : project1.getWorkers()) {
            System.out.println(w);
        }

    }
}
