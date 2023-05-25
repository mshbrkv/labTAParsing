package xml_parsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLDomParser {


    public static void readDomXML(String file) {
        try {
            // Load the XML document
            File inputFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList departmentList = doc.getElementsByTagName("department");
            for (int i = 0; i < departmentList.getLength(); i++) {
                // Extract individual department data
                Element departmentElement = (Element) departmentList.item(i);
                String departmentName = departmentElement.getAttribute("name");
                String departmentId = departmentElement.getAttribute("depId");
                System.out.println("Department Name:" + departmentName);
                System.out.println("Department ID:" + departmentId);
                System.out.println();
                System.out.println("EMPLOYEES IN DEPARTMENT: ");
                NodeList employeeList = doc.getElementsByTagName("employee");
                for (int j = 0; j < employeeList.getLength(); j++) {
                    // Extract individual employee data
                    Element employeeElement = (Element) employeeList.item(j);
                    String employeeId = employeeElement.getAttribute("empId");

                    String lastName = getTextContent(employeeElement, "lastName");
                    String firstName = getTextContent(employeeElement, "firstName");
                    String birthDate = getTextContent(employeeElement, "birthDate");
                    String position = getTextContent(employeeElement, "position");

                    System.out.println("Employee ID: " + employeeId);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Birth Date: " + birthDate);
                    System.out.println("Position: " + position);

                    NodeList skillList = employeeElement.getElementsByTagName("skill");
                    System.out.println("Skills:");
                    for (int k = 0; k < skillList.getLength(); k++) {
                        // Extract individual skill data
                        Element skillElement = (Element) skillList.item(k);
                        String skill = skillElement.getTextContent();
                        System.out.println("- " + skill);
                    }

                    String managerId = getTextContent(employeeElement, "managerId");
                    System.out.println("Manager ID: " + managerId);

                    System.out.println();
                }
            }


        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Element tagElement = (Element) nodeList.item(0);
            return tagElement.getTextContent();
        }
        return "";
    }
}
