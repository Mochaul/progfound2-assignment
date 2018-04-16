package javari.park;

import java.util.List;

import javari.animal.Animal;

public interface SelectedAttraction {

    String getName();

    String getType();

    List<Animal> getPerformers();

    boolean addPerformer(Animal performer);
}
