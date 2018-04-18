import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import animal.*;

public class Main{
    public static void main(String[] args) {
        String[] lines;
        String fileName;
        fileName = "animals_categories.csv";

        System.out.println("TESTING Categories");
        Categories cat = new Categories();

        lines = CSVReader.read(fileName);
        for (int i=0; i<lines.length; i++){
            cat.addCategory(lines[i].split(",")[0], lines[i].split(",")[1], lines[i].split(",")[2]);
        }
        System.out.println("\nlist of categories");
        System.out.println(cat.printCategories());
        System.out.println("invalid categories: " + cat.invalid);

        System.out.println("----------------------------------");

        fileName = "animals_attractions.csv";

        System.out.println("TESTING ATTRACTIONS");
        Attractions javari = new Attractions();
        lines = CSVReader.read(fileName);
        for (int i=0; i<lines.length; i++){
            javari.addAttraction(lines[i].split(",")[0], lines[i].split(",")[1], cat);
        }

        System.out.println("\nlist of attractions");
        System.out.println(javari.printAttractions());
        System.out.println("invalid attractions: " + javari.invalid);

    }
}