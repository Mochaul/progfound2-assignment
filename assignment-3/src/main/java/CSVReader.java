import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader{

    public static String[] read(String fileName){
        String in = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                in += line;
                in += "_";
                // cat.addCategory(line.split(",")[0], line.split(",")[1], line.split(",")[2]);
            }
            bufferedReader.close();
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'"); 
            return null;               
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");   
            return null;               
        }
        return in.split("_");
    }
}