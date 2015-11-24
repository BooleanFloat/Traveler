package org.booleanfloat.traveler;

import org.booleanfloat.traveler.regions.*;

import java.util.ArrayList;

public class Init {
    public static void init() {
        BarbarianVillage.initLocations();
        Draynor.initLocations();
        Falador.initLocations();
        Lumbridge.initLocations();
        LumbridgeCastle.initLocations();
        Varrock.initLocations();
        VarrockCastle.initLocations();

        BarbarianVillage.initLinks();
        Draynor.initLinks();
        Falador.initLinks();
        Lumbridge.initLinks();
        LumbridgeCastle.initLinks();
        Varrock.initLinks();
        VarrockCastle.initLinks();
    }

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.addAll(BarbarianVillage.getLocations());
        locations.addAll(Draynor.getLocations());
        locations.addAll(Falador.getLocations());
        locations.addAll(Lumbridge.getLocations());
        locations.addAll(LumbridgeCastle.getLocations());
        locations.addAll(Varrock.getLocations());
        locations.addAll(VarrockCastle.getLocations());

        return locations;
    }
}
