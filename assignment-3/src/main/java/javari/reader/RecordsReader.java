package javari.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javari.animal.Gender;
import javari.animal.Condition;

/**
 * This class performs reading data from animal_records.csv
 * 
 * @author Nicolaus
 */
public class RecordsReader extends CsvReader{

    /**
     * constructor for RecordsReader
     * @param file path object reffering to csv file
     * @throws IOException if given file not found
     */
    public RecordsReader(Path file) throws IOException{
        super(file);
    }

    /**
     * counts number of invalid records
     * 
     * @return
     */
     public long countInvalidRecords(){
        long invalidCount = 0;
        String[] row;
        for (int i = 0; i<this.lines.size(); i++){
            row = this.lines.get(i).split(COMMA);
            if (row.length != 8){
                invalidCount++;
                continue;
            } 
            try {
                Integer.parseInt(row[0]);
                Gender.parseGender(row[3]);
                Double.parseDouble(row[4]);
                Double.parseDouble(row[5]);
                Condition.parseCondition(row[7]);
            } catch(NumberFormatException|UnsupportedOperationException e){
                invalidCount++;
                continue;
            } 
        }
        return invalidCount;
     }

     /**
     * counts number of valid records
     * 
     * @return
     */
    public long countValidRecords(){
        return this.lines.size() - this.countInvalidRecords();
    }
     
}