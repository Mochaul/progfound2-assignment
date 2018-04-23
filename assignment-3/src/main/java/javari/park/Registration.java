package javari.park;

import java.util.List;

/**
 * This interfaces describes expected behaviours for any type ((abstract)
 * class, interface) that represents the concept of attraction registration
 * done by a visitor in Javari Park.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author Nicolaus
 * changes :
 * - change return type of method setVisitorName to void from String
 */
public interface Registration {

    /**
     * Returns the unique ID that associated with visitor's registration
     * in watching an attraction.
     *
     * @return
     */
    int getRegistrationId();

    /**
     * Returns the name of visitor that associated with the registration.
     *
     * @return
     */
    String getVisitorName();

    /**
     * Changes visitor's name in the registration.
     *
     * @param name  name of visitor
     * @return
     */
    void setVisitorName(String name);

    /**
     * Returns the list of all attractions that will be watched by the
     * visitor.
     *
     * @return
     */
    List<SelectedAttraction> getSelectedAttractions();

    /**
     * Adds a new attraction that will be watched by the visitor.
     *
     * @param selected  the attraction
     * @return {@code true} if the attraction is successfully added into the
     *     list, {@code false} otherwise
     */
    boolean addSelectedAttraction(SelectedAttraction selected);
}
