package org.smartkode;

import com.opencsv.CSVReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

public class ReadFiles {
    public List<String[]> readCSV(List<String[]> data, CSVReader csvReader) throws IOException, CsvValidationException {
        String[] lines;

        while ((lines = csvReader.readNext()) != null) {
            String line = String.join("", lines);
            if(line.isEmpty())
                continue;
            data.add(lines);
        }
        return data;
    }

    public String[] removeEmptyColumns(String[] row) {
        List<String> filtered = new java.util.ArrayList<>();
        for (String col : row) {
            if (!isEmptyString(col))
                filtered.add(col.trim()); // opcional: limpiar espacios
        }
        return filtered.toArray(new String[0]);
    }

//    public void printData(List<String[]> data){
//        int i=0;
//        for(String[] row: data){
//            int j=0;
//            System.out.print("i_" + i + ":  ");
//            for(String col: row) {
//                System.out.print("j_" + j + ":  " + col + " ");
//                j++;
//            }
//            i++;
//            System.out.println();
//        }
//    }

    public void printData(List<String[]> data){
        for(String[] row: data){
            for(String col: row)
                System.out.print(col + " ");
            System.out.println();
        }
    }

    public String normanalizeString (String[] row, int i){
        String str = row[i].replaceAll("\\p{Punct}", "")
                .replaceAll("\\s+", "")
                .toLowerCase();
        return str;
    }

    public boolean isEmptyString(String str) {
        return str.trim().isEmpty();
    }

    public String[] removeElements(String[] row, boolean fist, boolean middle, boolean last){
        if (middle) row = ArrayUtils.remove(row, 2);
        if (last) row = ArrayUtils.remove(row, 3);
        if (fist) row = ArrayUtils.remove(row, 0);
        return row;
    }

}
