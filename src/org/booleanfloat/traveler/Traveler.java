package org.booleanfloat.traveler;

import org.booleanfloat.traveler.regions.*;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;

public class Traveler {
    public static void init(ClientContext ctx) {
        AlKharid.initLocations();
        BarbarianVillage.initLocations();
        Draynor.initLocations();
        Falador.initLocations();
        Lumbridge.initLocations();
        LumbridgeCastle.initLocations();
        MusaPoint.initLocations();
        PortSarim.initLocations();
        Varrock.initLocations();
        VarrockCastle.initLocations();

        AlKharid.initLinks(ctx);
        BarbarianVillage.initLinks(ctx);
        Draynor.initLinks(ctx);
        Falador.initLinks(ctx);
        Lumbridge.initLinks(ctx);
        LumbridgeCastle.initLinks(ctx);
        MusaPoint.initLinks(ctx);
        PortSarim.initLinks(ctx);
        Varrock.initLinks(ctx);
        VarrockCastle.initLinks(ctx);
    }

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.addAll(AlKharid.getLocations());
        locations.addAll(BarbarianVillage.getLocations());
        locations.addAll(Draynor.getLocations());
        locations.addAll(Falador.getLocations());
        locations.addAll(Lumbridge.getLocations());
        locations.addAll(LumbridgeCastle.getLocations());
        locations.addAll(MusaPoint.getLocations());
        locations.addAll(PortSarim.getLocations());
        locations.addAll(Varrock.getLocations());
        locations.addAll(VarrockCastle.getLocations());

        return locations;
    }
}
