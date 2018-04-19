import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import animal.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String DEFAULT_PATH = "./../../../data/";
        String specified_path;
        String[] lines_cat;
        String[] lines_att;
        String[] lines_rec;

        System.out.print("Welcome to Javari Park Festival - Registration Service!\n\n... Opening default section database from data. ");

        // reads .csv files in 'data/', else asks user for path if file not found in default path 
        lines_cat = CSVReader.read(DEFAULT_PATH + "animals_categories.csv");
        lines_att = CSVReader.read(DEFAULT_PATH + "animals_attractions.csv");
        lines_rec = CSVReader.read(DEFAULT_PATH + "animals_record.csv");
        while (lines_cat == null || lines_att == null || lines_rec == null){
            System.out.print("... File not found or incorrect file!\n\nPlease provide the source data path: ");
            specified_path = in.nextLine();
            lines_cat = CSVReader.read(specified_path + "animals_categories.csv");
            lines_att = CSVReader.read(specified_path + "animals_attractions.csv");
            lines_rec = CSVReader.read(specified_path + "animals_record.csv");
        }
        System.out.print("\n\n... Loading... ");
        
        // populates categories, attractions and records to system
        Categories categories = new Categories();
        for (int i=0; i<lines_cat.length; i++){
            categories.addCategory(lines_cat[i].split(",")[0], lines_cat[i].split(",")[1], lines_cat[i].split(",")[2]);
        }
        Attractions attractions = new Attractions();
        for (int i=0; i<lines_att.length; i++){
            attractions.addAttraction(lines_att[i].split(",")[0], lines_att[i].split(",")[1], categories);
        }
        AnimalFactory records = new AnimalFactory();
        for (int i=0; i<lines_rec.length; i++){
            records.addAnimal(lines_rec[i].split(","));
        }

        // prints number of valid items loaded into system
        System.out.print("Success... System is populating data\n\n");
        System.out.printf("Found %d valid sections and %d invalid sections\n", categories.getSections().size(), categories.getInvalid());
        System.out.printf("Found %d valid attractions and %d invalid attractions\n", attractions.getAttractions().size(), attractions.getInvalid());
        System.out.printf("Found %d valid categories and %d invalid categories\n", categories.getSections().size(), categories.getInvalid());
        System.out.printf("Found %d valid animal records and %d invalid animal records\n", records.getAnimals().size(), records.getInvalid());
        
        System.out.print("Welcome to Javari Park Festival - Registration Service!\n\n");
    }
}