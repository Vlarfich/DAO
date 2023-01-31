package Main;

import java.io.File;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import Hierarchy.Project;
import Hierarchy.Worker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMParser {
    public static void main(String[] args) {
        String filePath = "./Project.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("project");

            List<Project> userList = new ArrayList<Project>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                userList.add(getUser(nodeList.item(i)));
            }

            for (Project emp : userList) {
                System.out.println(emp.toString());
                for (Worker w : emp.getWorkers())
                    System.out.println("   " + w.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static Project getUser(Node node) {
        // XMLReaderDOM domReader = new XMLReaderDOM();
        Project user = new Project();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            user.setId(Integer.parseInt(element.getAttribute("id")));
            user.setName(getTagValue("name", element));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setStartingDate(sdf.parse(getTagValue("startingDate", element)));
            } catch (ParseException e) {
                user.setStartingDate(new Date());
            }
            System.out.println(((Element) node).getTagName());
            System.out.println(node.hasChildNodes());
            NodeList nodeList = ((Element) node).getElementsByTagName("workers").item(0).getChildNodes();
            LinkedList<Worker> workers = new LinkedList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
                    workers.add(getWorker(nodeList.item(i)));
            }
            user.setWorkers(workers);
        }
        return user;
    }

    private static Worker getWorker(Node node) {
        Worker worker = new Worker();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            worker.setId(Integer.parseInt(element.getAttribute("id")));
            worker.setProjects_id(Integer.parseInt(element.getAttribute("projectsId")));
            worker.setName(getTagValue("name", element));
            worker.setAge(Integer.parseInt(getTagValue("age", element)));
        }
        return worker;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}