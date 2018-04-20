package javari.park;

import java.util.List;

import javari.animal.Animal;

/**
 * This interface describes expected behaviours for any type ((abstract)
 * class, interface) that represents the concept of attraction that
 * will be watched by a visitor in Javari Park.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author TODO If you make changes in this class, please write your name here
 *     and describe the changes in the comment block
 */
public interface SelectedAttraction {

    /**
     * Returns the name of attraction.
     *
     * @return
     */
    String getName();

    /**
     * Returns ths type of animal(s) that performing in this attraction.
     *
     * @return
     */
    String getType();

    /**
     * Returns all performers of this attraction.
     *
     * @return
     */
    List<Animal> getPerformers();

    /**
     * Adds a new animal into the list of performers.
     *
     * @param performer an instance of animal
     * @return {@code true} if the animal is successfully added into list of
     *     performers, {@code false} otherwise
     */
    boolean addPerformer(Animal performer);
}
