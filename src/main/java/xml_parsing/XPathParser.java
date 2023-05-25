package xml_parsing;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class XPathParser {

    public static void XPathXMLParser() {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document document = factory.newDocumentBuilder().parse("C:/Users/masha/Desktop/labTAParsing/company.xml");

            // Create an XPath instance
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Extract employee data using XPath expressions
            XPathExpression expression = xpath.compile("//employee");

            NodeList employeeNodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);

            for (int i = 0; i < employeeNodes.getLength(); i++) {
                // Extract individual employee data
                String empId = xpath.evaluate("@empId", employeeNodes.item(i));
                String lastName = xpath.evaluate("lastName", employeeNodes.item(i));
                String firstName = xpath.evaluate("firstName", employeeNodes.item(i));
                String birthDate = xpath.evaluate("birthDate", employeeNodes.item(i));
                String position = xpath.evaluate("position", employeeNodes.item(i));
                String managerId = xpath.evaluate("managerId", employeeNodes.item(i));

                System.out.println("Employee ID: " + empId);
                System.out.println("Last Name: " + lastName);
                System.out.println("First Name: " + firstName);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("Position: " + position);
                System.out.println("Manager ID: " + managerId);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
