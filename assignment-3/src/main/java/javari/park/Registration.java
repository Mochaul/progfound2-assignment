package javari.park;

import java.util.List;

public interface Registration {

    int getRegistrationId();

    String getVisitorName();

    String setVisitorName(String name);

    List<SelectedAttraction> getSelectedAttractions();

    boolean addSelectedAttraction(SelectedAttraction selected);
}
