package javari.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javari.animal.Animal;
import javari.park.Registration;
import javari.park.SelectedAttraction;

import org.json.JSONWriter;

public class RegistrationWriter {

    private static final String DEFAULT_FILENAME_FMT =
            "registration_%s.json";

    public static void writeJson(Registration registration,
                                 Path directory) throws IOException {
        String fileName = String.format(DEFAULT_FILENAME_FMT,
                registration.getVisitorName());
        String jsonFileName = fileName.replace(" ", "_");
        Path jsonFile = directory.resolve(jsonFileName);
        BufferedWriter fileWriter = Files.newBufferedWriter(jsonFile,
                StandardCharsets.UTF_8);
        final JSONWriter writer = new JSONWriter(fileWriter);

        writer.array();
        buildRegistration(writer, registration);
        writer.endArray();

        System.out.println("... End of program, write to "
                + jsonFile.getFileName().toString());

        fileWriter.flush();
        fileWriter.close();
    }

    private static void buildRegistration(JSONWriter writer,
                                          Registration registration) {
        writer.object()
                .key("registration_id").value(registration.getRegistrationId())
                .key("name").value(registration.getVisitorName())
                .key("attractions").array();

        registration.getSelectedAttractions().forEach(attraction ->
                buildAttraction(writer, attraction)
        );

        writer.endArray().endObject();
    }

    private static void buildAttraction(JSONWriter writer,
                                        SelectedAttraction attraction) {
        String type = attraction.getType();
        writer.object()
                .key("name").value(attraction.getName())
                .key("type").value(type);

        buildPerformers(writer,
                attraction.getPerformers());

        writer.endObject();
    }

    private static void buildPerformers(JSONWriter writer,
                                        List<Animal> animals) {
        writer.key("animals").array();
        animals.forEach(animal -> buildPerformer(writer, animal));
        writer.endArray();
    }

    private static void buildPerformer(JSONWriter writer,
                                       Animal animal) {
        writer.object()
                .key("name").value(animal.getName())
                .endObject();
    }
}
