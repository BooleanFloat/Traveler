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

public class Yanille implements Region {
    public static Location Bank;
    public static Location EastGate;
    public static Location POHPortal;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(EastGate);
        locations.add(POHPortal);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("Yanille, Bank", new Area(
                new Tile(2615, 3096, 0),
                new Tile(2609, 3087, 0)
        ));

        EastGate = new Location("Yanille, EastGate", new Area(
                new Tile(2614, 3106, 0),
                new Tile(2617, 3102, 0),
                new Tile(2615, 3100, 0),
                new Tile(2612, 3104, 0)
        ));

        POHPortal = new Location("Yanille, POHPortal", new Area(
                new Tile(2547, 3095, 0),
                new Tile(2542, 3092, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Bank, EastGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2611, 3092, 0)),
                new Step(new Tile(2606, 3092, 0)),
                new Step(new Tile(2606, 3097, 0)),
                new Step(new Tile(2615, 3103, 0))
        )));

        new TwoWayLink(Bank, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2611, 3092, 0)),
                new Step(new Tile(2607, 3091, 0)),
                new Step(new Tile(2600, 3097, 0)),
                new Step(new Tile(2582, 3097, 0)),
                new Step(new Tile(2573, 3090, 0)),
                new Step(new Tile(2559, 3089, 0)),
                new Step(new Tile(2544, 3093, 0))
        )));

        new TwoWayLink(EastGate, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3103, 0)),
                new Step(new Tile(2604, 3096, 0)),
                new Step(new Tile(2584, 3096, 0)),
                new Step(new Tile(2575, 3090, 0)),
                new Step(new Tile(2557, 3088, 0)),
                new Step(new Tile(2544, 3092, 0))
        )));
    }
}
