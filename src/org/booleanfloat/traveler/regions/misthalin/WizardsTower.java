package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class WizardsTower implements Region {
    public static Location Entrance;
    public static Location DigSpot;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Entrance);
        locations.add(DigSpot);

        return locations;
    }

    public static void initLocations() {
        Entrance = new Location("WizardsTower, Entrance", new Area(
                new Tile(3115, 3171, 0),
                new Tile(3110, 3167, 0)
        ));

        DigSpot = new Location("WizardsTower, DigSpot", new Area(
                new Tile(3111, 3153, 0),
                new Tile(3109, 3151, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Entrance, DigSpot, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3112, 3169, 0)),
                new Step(new Tile(3118, 3162, 0)),
                new Step(new Tile(3118, 3154, 0)),
                new Step(new Tile(3110, 3150, 0))
        )));
    }
}
