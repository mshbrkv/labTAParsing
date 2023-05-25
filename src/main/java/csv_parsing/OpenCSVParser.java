package csv_parsing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;


public class OpenCSVParser {

    public static void readCSVFile(String file) {
        try {
            FileReader fileReader = new FileReader(file);

            CSVReader csvReader = new CSVReader(fileReader);

            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
