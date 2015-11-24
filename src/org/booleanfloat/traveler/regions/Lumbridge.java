package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Lumbridge implements Region {
    public static Location Center;
    public static Location Church;
    public static Location HamEntrance;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Center);
        locations.add(Church);
        locations.add(HamEntrance);

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
    }

    public static void initLinks() {
        new TwoWayLink(Center, Church, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3210, 0)),
                new Obstacle(7129, "Open", new Tile(3238, 3210, 0)),
                new Step(new Tile(3242, 3210, 0))
        )));

        new TwoWayLink(Center, Varrock.SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3234, 3218, 0)),
                new Step(new Tile(3234, 3225, 0)),
                new Step(new Tile(3258, 3225, 0)),
                new Step(new Tile(3252, 3254, 0)),
                new Step(new Tile(3239, 3283, 0)),
                new Step(new Tile(3238, 3306, 0)),
                new Step(new Tile(3226, 3309, 0)),
                new Step(new Tile(3205, 3343, 0)),
                new Step(new Tile(3211, 3380, 0))
        )));
    }
}
