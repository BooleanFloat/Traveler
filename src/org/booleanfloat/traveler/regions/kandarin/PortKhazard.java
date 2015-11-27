package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class PortKhazard implements Region {
    public static Location Entrance;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Entrance);

        return locations;
    }

    public static void initLocations() {
        Entrance = new Location("location", new Area(
                new Tile(2626, 3174, 0),
                new Tile(2621, 3169, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Entrance, Yanille.EastGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2623, 3171, 0)),
                new Step(new Tile(2625, 3118, 0)),
                new Step(new Tile(2615, 3104, 0))
        )));
    }
}
