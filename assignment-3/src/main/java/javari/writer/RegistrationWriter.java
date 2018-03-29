package javari.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;

import javari.animal.Animal;
import javari.park.Attraction;
import javari.park.Registration;

import org.json.JSONWriter;

public class RegistrationWriter {

    private static final String DEFAULT_FILENAME_FMT =
            "registration_%s.json";

    public static void writeJson(Map<String, Registration> bookings,
                                 String fileName, Path directory) throws IOException {

        String jsonFileName = String.format(DEFAULT_FILENAME_FMT,
                fileName.replace(" ","_"));
        Path jsonFile = directory.resolve(jsonFileName);
        BufferedWriter fileWriter = Files.newBufferedWriter(jsonFile,
                StandardCharsets.UTF_8);
        final JSONWriter writer = new JSONWriter(fileWriter);

        writer.array();
        bookings.values()
                .forEach(registration -> writeRegistration(writer,
                        registration));
        writer.endArray();

        System.out.println("... End of program, write to "
                + jsonFile.getFileName().toString());

        fileWriter.flush();
        fileWriter.close();
    }

    public static void writeJson(Registration registration,
                                 Path directory) throws IOException {
        String fileName = String.format(DEFAULT_FILENAME_FMT,
                registration.getVisitorName());
        String jsonFileName = fileName.replace(" ","_");
        Path jsonFile = directory.resolve(jsonFileName);
        BufferedWriter fileWriter = Files.newBufferedWriter(jsonFile,
                StandardCharsets.UTF_8);
        final JSONWriter writer = new JSONWriter(fileWriter);

        writer.array();
        writeRegistration(writer, registration);
        writer.endArray();

        System.out.println("... End of program, write to "
                + jsonFile.getFileName().toString());

        fileWriter.flush();
        fileWriter.close();
    }

    private static JSONWriter writeRegistration(JSONWriter writer,
                                                Registration registration) {
        writer.object()
                .key("registration_id").value(registration.getId())
                .key("name").value(registration.getVisitorName())
                .key("attractions").array();

        registration.getSelectedAttractions().forEach(attraction ->
                writeAttraction(writer, attraction)
        );

        return writer.endArray().endObject();
    }

    private static JSONWriter writeAttraction(JSONWriter writer,
                                              Attraction attraction) {
        String type = attraction.getPerformerTypes().get(0);
        writer.object()
                .key("name").value(attraction.getName())
                .key("type").value(type);

        writePerformerAnimals(writer,
                attraction.getShowablePerformersByType(type));

        return writer.endObject();
    }

    private static JSONWriter writePerformerAnimals(JSONWriter writer,
                                                    Collection<Animal> animals) {
        writer.key("animals").array();
        animals.forEach(animal -> writePerformerAnimal(writer, animal));
        return writer.endArray();
    }

    private static JSONWriter writePerformerAnimal(JSONWriter writer,
                                                   Animal animal) {
        return writer.object()
                .key("name").value(animal.getName())
                .endObject();
    }
}
