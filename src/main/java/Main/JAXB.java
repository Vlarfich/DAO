package Main;

import Hierarchy.MAX_ID;
import Hierarchy.Project;
import Hierarchy.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JAXB {
    private static final Logger LOGGER = LogManager.getLogger(JAXB.class);

    public static void main(String[] args) throws JAXBException, IOException {
        Scanner sc = new Scanner(System.in);
        Worker worker = Worker.Factory(sc, LOGGER);
        marshalWorker(worker);
        Project project = Project.Factory(sc, LOGGER);
        project.addWorker(worker);
        project.addWorker(worker);
        marshalProject(project);
    }

    public static void marshalProject(Project project) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(project.getClass());
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(project, new File("./Project.xml"));
    }

    public static Project unmarshallProject() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Project.class);
        return (Project) context.createUnmarshaller()
                .unmarshal(new FileReader("./Project.xml"));
    }

    public static void marshalWorker(Worker project) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Worker.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(project, new File("./Worker.xml"));
    }

    public static Worker unmarshallWorker() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Project.class);
        return (Worker) context.createUnmarshaller()
                .unmarshal(new FileReader("./Worker.xml"));
    }
}
