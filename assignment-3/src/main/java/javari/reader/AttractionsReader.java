package javari.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Arrays;

public class AttractionsReader extends CsvReader{
    private final String[] ANIMAL_TYPES = new String[] {"Cat", "Eagle", "Hamster", "Lion", "Parrot", "Snake", "Whale"};


    public AttractionsReader(Path file) throws IOException{
        super(file);
    }

    public long countInvalidRecords(){
        long invalidCount = 0;
        String[] row;
        for (int i=0; i<this.lines.size(); i++){
            row  = this.lines.get(i).split(COMMA);
            if (row.length != 2 || !Arrays.asList(ANIMAL_TYPES).contains(row[0])){
                invalidCount++;
                continue;
            }        
        }
        return invalidCount;
    }

    public long countValidRecords(){
        return this.lines.size() - this.countInvalidRecords();
    }
}