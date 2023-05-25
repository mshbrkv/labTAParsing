package xml_parsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {

    private List<Employee> employees;
    private Employee currentEmployee;
    private StringBuilder data;

    public static void XMLSaxParser() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            saxParser.parse("C:/Users/masha/Desktop/labTAParsing/company.xml", handler);

            List<Employee> employees = handler.getEmployees();
            for (Employee employee : employees) {
                System.out.println("Employee ID: " + employee.getEmpId());
                System.out.println("Last Name: " + employee.getLastName());
                System.out.println("First Name: " + employee.getFirstName());
                System.out.println("Birth Date: " + employee.getBirthDate());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Skills: " + employee.getSkills());
                System.out.println("Manager ID: " + employee.getManagerId());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void startDocument() throws SAXException {
        employees = new ArrayList<>();
        data = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            currentEmployee = new Employee();
            currentEmployee.setEmpId(attributes.getValue("empId"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length).trim());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("lastName")) {
            currentEmployee.setLastName(data.toString());
        } else if (qName.equalsIgnoreCase("firstName")) {
            currentEmployee.setFirstName(data.toString());
        } else if (qName.equalsIgnoreCase("birthDate")) {
            currentEmployee.setBirthDate(data.toString());
        } else if (qName.equalsIgnoreCase("position")) {
            currentEmployee.setPosition(data.toString());
//        } else if (qName.equalsIgnoreCase("skill")) {
//            currentEmployee.addSkill(data.toString());
        } else if (qName.equalsIgnoreCase("managerId")) {
            currentEmployee.setManagerId(data.toString());
        } else if (qName.equalsIgnoreCase("employee")) {
            employees.add(currentEmployee);
        }
        data.setLength(0);
    }
}

