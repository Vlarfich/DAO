package com.solvd.BuildingCompany.main;

import com.solvd.BuildingCompany.hierarchy.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MySAXHandler extends DefaultHandler {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MySAXHandler handler = new MySAXHandler();
            saxParser.parse(new File("./Customer.xml"), handler);

            List<Customer> empList = handler.getEmpList();

            for (Customer emp : empList)
                System.out.println(emp);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private List<Customer> empList = null;
    private Customer emp = null;
    private StringBuilder data = null;

    public List<Customer> getEmpList() {
        return empList;
    }

    boolean bPhone = false;
    boolean bName = false;
    boolean bEmail = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("customer")) {
            String id = attributes.getValue("id");
            String pid = attributes.getValue("projectsId");
            emp = new Customer();
            emp.setId(Integer.parseInt(id));
            emp.setProjects_id(Integer.parseInt(pid));

            if (empList == null)
                empList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("phone")) {
            bPhone = true;
        } else if (qName.equalsIgnoreCase("email")) {
            bEmail = true;
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            emp.setName(data.toString());
            bName = false;
        } else if (bPhone) {
            emp.setPhone(data.toString());
            bPhone = false;
        } else if (bEmail) {
            emp.setEmail(data.toString());
            bEmail = false;
        }

        if (qName.equalsIgnoreCase("customer")) {
            empList.add(emp);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
