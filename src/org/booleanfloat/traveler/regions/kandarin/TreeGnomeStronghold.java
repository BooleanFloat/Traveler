package org.booleanfloat.traveler.regions.kandarin;

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

public class TreeGnomeStronghold implements Region {
    public static Location GateInside;
    public static Location GateOutside;
    public static Location MushroomDigSpot;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(GateInside);
        locations.add(GateOutside);
        locations.add(MushroomDigSpot);

        return locations;
    }

    public static void initLocations() {
        GateInside = new Location("TreeGnomeStronghold, GateInside", new Area(
                new Tile(2465, 3388, 0),
                new Tile(2458, 3385, 0)
        ));

        GateOutside = new Location("TreeGnomeStronghold, GateOutside", new Area(
                new Tile(2463, 3382, 0),
                new Tile(2459, 3379, 0)
        ));

        MushroomDigSpot = new Location("TreeGnomeStronghold, MushroomDigSpot", new Area(
                new Tile(2461, 3506, 0),
                new Tile(2459, 3504, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(GateInside, GateOutside, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2461, 3383, 0)),
                new Obstacle(190, "Open", new Tile(2461, 3384, 0)),
                new Step(new Tile(2461, 3382, 0))
        )));

        new TwoWayLink(GateInside, MushroomDigSpot, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2461, 3384, 0)),
                new Step(new Tile(2459, 3413, 0)),
                new Step(new Tile(2462, 3438, 0)),
                new Step(new Tile(2466, 3467, 0)),
                new Step(new Tile(2460, 3493, 0)),
                new Step(new Tile(2462, 3503, 0))
        )));
    }
}
