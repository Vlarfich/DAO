package main;

import hierarchy.Project;
import hierarchy.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JAXB {
    private static final Logger LOGGER = LogManager.getLogger(JAXB.class);

    public static void main(String[] args) throws JAXBException, IOException {
        Project project = unmarshallProject();
        LOGGER.info(project);
        for(Worker w : project.getWorkers()){
            LOGGER.info(w);
        }
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
