package com.example.labtaparsing;

import csv_parsing.CommonCSVParser;
import csv_parsing.OpenCSVParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xml_parsing.MyHandler;
import xml_parsing.XMLDomParser;
import xml_parsing.XPathParser;
import xml_to_json_parsing.ConvertXMLToJson;

import java.io.IOException;

@SpringBootApplication
public class LabTaParsingApplication {

    private static final String file = "students.csv";
    private static final String xmlFile = "company.xml";
    private static final String xmlString="<company>\n" +
            "    <department name=\"Development\" depId=\"1\">\n" +
            "        <employee empId=\"001\">\n" +
            "            <lastName>LastName</lastName>\n" +
            "            <firstName>FirstName</firstName>\n" +
            "            <birthDate>01.01.2000</birthDate>\n" +
            "            <position>Department Manager</position>\n" +
            "            <skills>\n" +
            "                <skill>Communication</skill>\n" +
            "                <skill>Java</skill>\n" +
            "            </skills>\n" +
            "            <managerId>0</managerId>\n" +
            "        </employee>\n" +
            "        <employee empId=\"002\">\n" +
            "            <lastName>LastName2</lastName>\n" +
            "            <firstName>FirstName2</firstName>\n" +
            "            <birthDate>01.01.2001</birthDate>\n" +
            "            <position>Developer</position>\n" +
            "            <skills>\n" +
            "                <skill>Sleeps only 2 hours per day</skill>\n" +
            "                <skill>Overtimes without concerns</skill>\n" +
            "                <skill>Works for food</skill>\n" +
            "            </skills>\n" +
            "            <managerId>001</managerId>\n" +
            "        </employee>\n" +
            "    </department>\n" +
            "    <department name=\"Accounting\" depId=\"2\">\n" +
            "        <employee empId=\"003\">\n" +
            "            <lastName>LastName3</lastName>\n" +
            "            <firstName>FirstName3</firstName>\n" +
            "            <birthDate>01.01.2002</birthDate>\n" +
            "            <position>Accountant</position>\n" +
            "            <skills>\n" +
            "                <skill>Accounting Software</skill>\n" +
            "                <skill>Mathematics</skill>\n" +
            "            </skills>\n" +
            "            <managerId>0</managerId>\n" +
            "        </employee>\n" +
            "        <employee empId=\"004\">\n" +
            "            <lastName>LastName4</lastName>\n" +
            "            <firstName>FirstName4</firstName>\n" +
            "            <birthDate>01.01.2003</birthDate>\n" +
            "            <position>Bookkeeper</position>\n" +
            "            <skills>\n" +
            "                <skill>Accounting Principles</skill>\n" +
            "                <skill>MS Excel</skill>\n" +
            "            </skills>\n" +
            "            <managerId>003</managerId>\n" +
            "        </employee>\n" +
            "    </department>\n" +
            "</company>";

    public static void main(String[] args) throws IOException {

        SpringApplication.run(LabTaParsingApplication.class, args);
        System.out.println("OpenCSV parsing");
        OpenCSVParser.readCSVFile(file);
        System.out.println("CommonsCSV parsing");
        CommonCSVParser.readCSVFile(file);
        System.out.println("XML DOM Parsing parsing");
        XMLDomParser.readDomXML(xmlFile);
        System.out.println("XML SAX Parsing parsing");
        MyHandler.XMLSaxParser();
        System.out.println("XML XPath Parsing parsing");
        XPathParser.XPathXMLParser();
        System.out.println("Convert XML to JSON");
        ConvertXMLToJson.convert(xmlString);
    }


}
