package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class BarbarianVillage implements Region {
    public static Location Mine;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Mine);

        return locations;
    }

    public static void initLocations() {
        Mine = new Location("BarbarianVillage, Mine", new Area(
                new Tile(3085, 3422, 0),
                new Tile(3077, 3415, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Mine, Falador.NorthSquare, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3077, 3418, 0)),
                new Step(new Tile(3071, 3418, 0)),
                new Step(new Tile(3034, 3425, 0)),
                new Step(new Tile(3016, 3429, 0)),
                new Step(new Tile(3000, 3431, 0)),
                new Step(new Tile(2988, 3427, 0)),
                new Step(new Tile(2987, 3419, 0)),
                new Step(new Tile(2967, 3411, 0))
        )));

        new TwoWayLink(Mine, Varrock.WestGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3081, 3419, 0)),
                new Step(new Tile(3116, 3420, 0)),
                new Step(new Tile(3127, 3414, 0)),
                new Step(new Tile(3155, 3416, 0)),
                new Step(new Tile(3170, 3429, 0)),
                new Step(new Tile(3176, 3428, 0))
        )));
    }
}
