import java.util.Scanner;

import animal.*;

public class Main{
    public static void main(String[] args) {
        String fileName = "animals_categories.csv";

        System.out.println("TESTING Categories");
        Categories cat = new Categories();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                cat.addCategory(line.split(",")[0], line.split(",")[1], line.split(",")[2]);
            }
            bufferedReader.close();
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            
        }
        System.out.println("\nlist of categories");
        System.out.println(cat.printCategories());

        System.out.println("----------------------------------");

        fileName = "animals_attractions.csv";

        System.out.println("TESTING ATTRACTIONS");
        Attractions javari = new Attractions();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                javari.addAttraction(line.split(",")[0], line.split(",")[1], cat);
            }
            bufferedReader.close();
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        System.out.println("\nlist of attractions");
        System.out.println(javari.printAttractions());
        System.out.println("invalid attractions: " + javari.invalid);

    }
}