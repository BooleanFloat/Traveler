package org.booleanfloat.traveler.regions.asgarnia;

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

public class Rimmington implements Region {
    public static Location GeneralStore;
    public static Location Mine;
    public static Location NorthCrossRoads;
    public static Location POHPortal;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(GeneralStore);
        locations.add(Mine);
        locations.add(NorthCrossRoads);
        locations.add(POHPortal);

        return locations;
    }

    public static void initLocations() {
        GeneralStore = new Location("Rimmington, GeneralStore", new Area(
                new Tile(2950, 3216, 0),
                new Tile(2947, 3212, 0)
        ));

        Mine = new Location("Rimmington, Mine", new Area(
                new Tile(2981, 3249, 0),
                new Tile(2989, 3243, 0),
                new Tile(2989, 3237, 0),
                new Tile(2988, 3230, 0),
                new Tile(2979, 3227, 0),
                new Tile(2969, 3231, 0),
                new Tile(2965, 3239, 0),
                new Tile(2969, 3245, 0),
                new Tile(2974, 3249, 0)
        ));

        POHPortal = new Location("Rimmington, POHPortal", new Area(
                new Tile(2957, 3226, 0),
                new Tile(2954, 3221, 0)
        ));

        NorthCrossRoads = new Location("Rimmington, NorthCrossRoads", new Area(
                new Tile(2984, 3277, 0),
                new Tile(2979, 3273, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(GeneralStore, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2950, 3214, 0)),
                new Obstacle(7129, "Open", new Tile(2950, 3214, 0), new int[]{0, 32, -196, 0, 0, 128}),
                new Step(new Tile(2955, 3214, 0)),
                new Step(new Tile(2955, 3222, 0))
        )));

        new TwoWayLink(Mine, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2976, 3236, 0)),
                new Step(new Tile(2970, 3227, 0)),
                new Step(new Tile(2962, 3222, 0)),
                new Step(new Tile(2956, 3222, 0))
        )));

        new TwoWayLink(Mine, NorthCrossRoads);

        new TwoWayLink(NorthCrossRoads, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2982, 3275, 0)),
                new Step(new Tile(2976, 3262, 0)),
                new Step(new Tile(2963, 3251, 0)),
                new Step(new Tile(2957, 3242, 0)),
                new Step(new Tile(2955, 3222, 0))
        )));
    }
}
