package csv_parsing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CommonCSVParser {
    public static void readCSVFile(String file) throws IOException {
        FileReader fileReader = new FileReader(file);
        CSVParser csvParserWithHeader = CSVFormat.DEFAULT.withHeader(Headers.class).parse(fileReader);
        for (CSVRecord record : csvParserWithHeader) {
            System.out.print(record.get(Headers.ID)+" "+record.get(Headers.Name)+" "+record.get(Headers.Surname)+" "+record.get(Headers.Faculty)+" "+record.get(Headers.Course)+" "+"\n");
        }
        System.out.println("\n\n");
    }

}
