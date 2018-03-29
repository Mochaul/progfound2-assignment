package javari.park;

import java.util.HashSet;
import java.util.Set;

public class Registration {

    private static int COUNT = 0;

    private int id;
    private String visitorName;
    private Set<Attraction> selectedAttractions;

    public Registration(String visitorName) {
        this(visitorName, new HashSet<>());
    }

    public Registration(String visitorName, Set<Attraction> selectedAttractions) {
        this.id = ++COUNT;
        this.visitorName = visitorName;
        this.selectedAttractions = selectedAttractions;
    }

    public int getId() {
        return id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Set<Attraction> getSelectedAttractions() {
        return selectedAttractions;
    }

    public boolean addAttraction(Attraction attraction) {
        return selectedAttractions.add(attraction);
    }
}
