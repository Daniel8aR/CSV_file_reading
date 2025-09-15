package org.example;

import com.opencsv.CSVReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;
import java.util.List;

public class readFiles {
    public static List<String[]> readCSV(List<String[]> data, CSVReader csvReader) throws IOException, CsvValidationException {
        String[] lines;

        while ((lines = csvReader.readNext()) != null) {
            String line = String.join("", lines);
            if(line.isEmpty())
                continue;
            data.add(lines);
        }
        return data;
    }
}
