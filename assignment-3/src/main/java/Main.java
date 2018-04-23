import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javari.animal.*;
import javari.factory.*;
import javari.reader.*;
import javari.writer.*;
import javari.park.*;
import javari.attraction.*;

public class Main {
    public static void main(String[] args) {
        final String DEFAULT_PATH = "./../../../data";
        final String[] FILE_NAME = new String[] {"animals_categories.csv", "animals_attractions.csv", "animals_records.csv"};
        
        String specifiedPath = DEFAULT_PATH;
        Path[] paths = new Path[3];
        CategoriesReader cat_reader;
        AttractionsReader att_reader;
        RecordsReader rec_reader;
        Scanner in =  new Scanner(System.in);

        System.out.printf("Welcome to Javari Park Festival - Registration Service!\n\n");
        System.out.printf("... Opening default section database from data. \n\n");

        // initializing paths to csv file
        while(true){
            try{
                for (int i=0; i< FILE_NAME.length; i++){
                    paths[i] = FileSystems.getDefault().getPath(specifiedPath, FILE_NAME[i]);
                }
                cat_reader = new CategoriesReader(paths[0]);
                att_reader = new AttractionsReader(paths[1]);
                rec_reader = new RecordsReader(paths[2]);
                break;
            }catch (IOException e){
                System.out.printf("... File not found or incorrect file!\n");
                System.out.printf("Please provide the source data path: ");
                specifiedPath = in.nextLine();
                continue;
            }
        }

        // populates system with categories, attractions and animals
        System.out.printf("... Loading...");
        CategoryFactory categories =  new CategoryFactory();
        categories.addCategories(cat_reader.getLines().toArray(new String[cat_reader.getLines().size()]));
        AttractionFactory attractions =  new AttractionFactory();
        attractions.addAttractions(att_reader.getLines().toArray(new String[att_reader.getLines().size()]));
        AnimalFactory animals =  new AnimalFactory();
        animals.addAnimals(rec_reader.getLines().toArray(new String[rec_reader.getLines().size()]));
        attractions.addPerformers(animals.getAnimals());

        // print information of whats loaded
        System.out.printf("Success... System is populating data...\n\n");
        System.out.printf("Found %d valid sections and %d invalid sections\n", categories.getCategory().size(), cat_reader.countInvalidRecords());
        System.out.printf("Found %d valid attractions and %d invalid attractions\n", attractions.getAttractionCount(), att_reader.countInvalidRecords());
        System.out.printf("Found %d valid animal records and %d invalid animal records\n", animals.getAnimals().size(), rec_reader.countInvalidRecords());
    
        System.out.printf("\nWelcome to Javari Park Festival - Registration Service!\n\n");
        System.out.printf("Please answer the questions by typing the number. Type # if you want to return to the previous menu\n"); 
        
        int menuPosition = 0; // indicate which menu user is currently on
        Visitor visitor = null;
        String selection = "0", selection2 = "0", selection3 = "0";
        ArrayList<Attraction> selected = new ArrayList<>();


        while (true){
            if (menuPosition < 0) menuPosition = 0;

            // section selection
            if (menuPosition == 0){
                System.out.printf("\nJavari Park has %d sections:\n", categories.getCategory().size());
                for(int i=0; i<categories.getCategory().size(); i++){
                    System.out.printf("%d. %s\n", i+1, categories.getCategory().get(i).getName());
                }
                selection = "0";
                while(!(1 <= Integer.parseInt(selection) && Integer.parseInt(selection) <= categories.getCategory().size())){
                    System.out.printf("Please choose your preferred section (type the number): ");
                    try { 
                        selection = in.nextLine();
                        if (selection.equals("#")) {
                            menuPosition--;
                            break;
                        }
                        menuPosition++;
                    }
                    catch (NumberFormatException e) { continue; }
                }
            }

            // animal selection
            if (menuPosition == 1){
                System.out.printf("\n--%s--\n", categories.getCategory().get(Integer.parseInt(selection) - 1).getName());
                for (int i=0; i<categories.getCategory().get(Integer.parseInt(selection) - 1).getTypes().size(); i++){
                    System.out.printf("%d. %s\n", i+1, categories.getCategory().get(Integer.parseInt(selection) - 1).getTypes().get(i));
                }
                selection2 = "0";
                while(!(1 <= Integer.parseInt(selection2) && Integer.parseInt(selection2) <= categories.getCategory().get(Integer.parseInt(selection) - 1).getTypes().size())){
                    System.out.printf("Please choose your preferred animals (type the number): ");
                    try { 
                        selection2 = in.nextLine(); 
                        if (selection2.equals("#")){
                            menuPosition--;
                            break;
                        }
                        menuPosition++;
                    }
                    catch (NumberFormatException e) { continue; }
                }
            }

            // attraction selection
            if (menuPosition == 2){
                System.out.printf("\n---%s---\n", categories.getCategory().get(Integer.parseInt(selection) - 1).getTypes().get(Integer.parseInt(selection2) - 1));
                selected = attractions.getAttractionsOfType(categories.getCategory().get(Integer.parseInt(selection) - 1).getTypes().get(Integer.parseInt(selection2) - 1));
                for (int i=0; i<selected.size(); i++){
                    System.out.printf("%d. %s\n", i+1, selected.get(i).getName());
                }
                selection3 = "0";
                while (!(1 <= Integer.parseInt(selection3) && Integer.parseInt(selection3) <= selected.size())) {
                    System.out.printf("Please choose your preferred attractions (type the number): ");
                    try { 
                        selection3 = in.nextLine(); 
                        if (selection3.equals("#")){
                            menuPosition--;
                            break;
                        }
                        menuPosition++;
                    }
                    catch (NumberFormatException e) { continue; }
                }
            }

            // printing ticket info
            if (menuPosition == 3){
                if (visitor == null){
                    System.out.printf("\nWow, one more step,\nplease let us know your name: ");
                    String name = in.nextLine();
                    visitor = new Visitor(name);
                }
                visitor.addSelectedAttraction(attractions.getAttractionOf(selected.get(Integer.parseInt(selection3) - 1).getName(), categories.getCategory().get(Integer.parseInt(selection) - 1).getTypes().get(Integer.parseInt(selection2) - 1)));
                System.out.printf("\nYeay, final check!\nHere is your data, and the attraction you chose:\n");
                String ticketInfo = String.format("Name: %s\n", visitor.getVisitorName());
                for (SelectedAttraction att : visitor.getSelectedAttractions()){
                    ticketInfo += String.format("Attractions: %s -> %s\n" +
                                                "With: %s\n", att.getName(), att.getType(), ((Attraction)visitor.getSelectedAttractions().get(0)).printPerformers());
                }
                System.out.printf(ticketInfo);

                // asking if data is corrrect
                String correct = "";
                while (!correct.equals("Y") && !correct.equals("N")){
                    System.out.printf("\nIs the data correct? (Y/N): ");
                    correct = in.nextLine();
                    menuPosition = 0;
                }
                if (correct.equals("N")){
                    visitor.removeLastAttraction();
                    System.out.printf("Attraction canceled\n\n");
                    continue;
                }

                // asking if want to attend another attration
                String another = "";
                while (!another.equals("Y") && !another.equals("N")){
                    System.out.printf("Thank you for your interest. Would you like to register to other attractions? (Y/N): ");
                    another = in.nextLine();
                }
                if (another.equals("Y")){
                    continue;
                }else if (another.equals("N")){
                    break;
                }
            }
        } // end while loop

        // TODO JSONWRITER
    }
}