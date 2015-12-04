package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class WizardsTower implements Region {
    public static Location Causeway;
    public static Location DigSpot;
    public static Location Entrance;
    public static Location Library;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Causeway);
        locations.add(Entrance);
        locations.add(DigSpot);
        locations.add(Library);

        return locations;
    }

    public static void initLocations() {
        Causeway = new Location("WizardsTower, Causeway", new Area(
                new Tile(3115, 3206, 0),
                new Tile(3112, 3203, 0)
        ));

        DigSpot = new Location("WizardsTower, DigSpot", new Area(
                new Tile(3111, 3153, 0),
                new Tile(3109, 3151, 0)
        ));

        Entrance = new Location("WizardsTower, Entrance", new Area(
                new Tile(3115, 3171, 0),
                new Tile(3110, 3167, 0)
        ));

        Library = new Location("WizardsTower, Library", new Area(
                new Tile(3111, 3161, 0),
                new Tile(3114, 3164, 0),
                new Tile(3116, 3162, 0),
                new Tile(3116, 3157, 0),
                new Tile(3112, 3153, 0),
                new Tile(3108, 3153, 0),
                new Tile(3103, 3157, 0),
                new Tile(3106, 3157, 0),
                new Tile(3110, 3161, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Causeway, Entrance);

        new TwoWayLink(DigSpot, Entrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3150, 0)),
                new Step(new Tile(3118, 3154, 0)),
                new Step(new Tile(3118, 3162, 0)),
                new Step(new Tile(3112, 3169, 0))
        )));

        new TwoWayLink(Entrance, Library, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3111, 3169, 0)),
                new Step(new Tile(3109, 3167, 0)),
                new Obstacle(23972, "Open", new Tile(3109, 3167, 0)),
                new Step(new Tile(3109, 3165, 0)),
                new Step(new Tile(3111, 3162, 0)),
                new Obstacle(23972, "Open", new Tile(3111, 3162, 0), new int[]{148, 116, -220, 0, -14, 132}),
                new Step(new Tile(3111, 3160, 0))
        )));
    }
}
