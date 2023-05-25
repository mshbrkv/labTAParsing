package com.example.labtaparsing;

import csv_parsing.CommonCSVParser;
import csv_parsing.OpenCSVParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xml_parsing.MyHandler;
import xml_parsing.XMLDomParser;
import xml_parsing.XPathParser;

import java.io.IOException;

@SpringBootApplication
public class LabTaParsingApplication {

    private static final String file = "students.csv";
    private static final String xmlFile = "company.xml";

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
    }


}
