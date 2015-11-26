package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Lumbridge implements Region {
    public static Location Center;
    public static Location Church;
    public static Location HamEntrance;
    public static Location EastCrossRoads;
    public static Location NorthBridge;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Center);
        locations.add(Church);
        locations.add(HamEntrance);
        locations.add(EastCrossRoads);
        locations.add(NorthBridge);

        return locations;
    }

    public static void initLocations() {
        Center = new Location("Lumbridge, Center", new Area(
                new Tile(3237, 3220, 0),
                new Tile(3234, 3217, 0)
        ));

        Church = new Location("Lumbridge, Church", new Area(
                new Tile(3245, 3210, 0),
                new Tile(3242, 3206, 0)
        ));

        HamEntrance = new Location("Lumbridge, HamEntrance", new Area(
                new Tile(3166, 3251, 0),
                new Tile(3164, 3249, 0)
        ));

        EastCrossRoads = new Location("Lumbridge, EastCrossRoads", new Area(
                new Tile(3262, 3229, 0),
                new Tile(3256, 3225, 0)
        ));

        NorthBridge = new Location("Lumbridge, NorthBridge", new Area(
                new Tile(3243, 3264, 0),
                new Tile(3228, 3260, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Center, Church, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3210, 0)),
                new Obstacle(7129, "Open", new Tile(3238, 3210, 0)),
                new Step(new Tile(3242, 3210, 0))
        )));

        new TwoWayLink(Center, EastCrossRoads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3236, 3219, 0)),
                new Step(new Tile(3236, 3225, 0)),
                new Step(new Tile(3257, 3225, 0))
        )));

        new TwoWayLink(Center, HamEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3219, 0)),
                new Step(new Tile(3222, 3236, 0)),
                new Step(new Tile(3168, 3245, 0)),
                new Step(new Tile(3166, 3249, 0))
        )));

        new TwoWayLink(Center, NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3219, 0)),
                new Step(new Tile(3219, 3243, 0)),
                new Step(new Tile(3219, 3260, 0)),
                new Step(new Tile(3235, 3261, 0))
        )));

        new TwoWayLink(HamEntrance, NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3166, 3247, 0)),
                new Step(new Tile(3168, 3244, 0)),
                new Step(new Tile(3190, 3243, 0)),
                new Step(new Tile(3213, 3255, 0)),
                new Step(new Tile(3230, 3261, 0))
        )));

        new TwoWayLink(EastCrossRoads, NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3258, 3227, 0)),
                new Step(new Tile(3260, 3240, 0)),
                new Step(new Tile(3244, 3263, 0))
        )));

        new TwoWayLink(NorthBridge, Varrock.SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3243, 3263, 0)),
                new Step(new Tile(3239, 3282, 0)),
                new Step(new Tile(3239, 3304, 0)),
                new Step(new Tile(3224, 3311, 0)),
                new Step(new Tile(3211, 3335, 0)),
                new Step(new Tile(3204, 3344, 0)),
                new Step(new Tile(3211, 3382, 0))
        )));
    }
}
