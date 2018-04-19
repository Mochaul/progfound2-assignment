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
            }
            bufferedReader.close();
        }catch(FileNotFoundException ex) {
            return null;               
        }catch(IOException ex) {
            return null;               
        }
        return in.split("_");
    }
}