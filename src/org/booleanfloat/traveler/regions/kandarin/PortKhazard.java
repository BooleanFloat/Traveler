package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class PortKhazard implements Region {
    public static Location Cart;
    public static Location Entrance;
    public static Location FishingTrawler;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(Cart);
        locations.add(Entrance);
        locations.add(FishingTrawler);

        return locations;
    }

    public static void initLocations() {
        Cart = new Location("PortKhazard, Cart", new Area(
                new Tile(2664, 3152, 0),
                new Tile(2660, 3146, 0)
        ));

        Entrance = new Location("PortKhazard, Entrance", new Area(
                new Tile(2626, 3174, 0),
                new Tile(2621, 3169, 0)
        ));

        FishingTrawler = new Location("PortKhazard, FishingTrawler", new Area(
                new Tile(2679, 3167, 0),
                new Tile(2673, 3163, 0)
        ));
    }

    public static void initLinks(final ClientContext ctx) {
        new TwoWayLink(Cart, Entrance, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2662, 3149, 0)),
                new Step(new Tile(2662, 3156, 0)),
                new Step(new Tile(2646, 3157, 0)),
                new Step(new Tile(2638, 3165, 0)),
                new Step(new Tile(2628, 3167, 0)),
                new Step(new Tile(2627, 3172, 0)),
                new Step(new Tile(2623, 3172, 0))
        )));

        new TwoWayLink(Cart, FishingTrawler, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2662, 3149, 0)),
                new Step(new Tile(2662, 3160, 0)),
                new Step(new Tile(2675, 3161, 0))
        )));

        new TwoWayLink(Entrance, Yanille.EastGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2623, 3171, 0)),
                new Step(new Tile(2625, 3118, 0)),
                new Step(new Tile(2615, 3104, 0))
        )));

        new TwoWayLink(Entrance, FishingTrawler, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2624, 3172, 0)),
                new Step(new Tile(2627, 3172, 0)),
                new Step(new Tile(2627, 3168, 0)),
                new Step(new Tile(2639, 3165, 0)),
                new Step(new Tile(2645, 3158, 0)),
                new Step(new Tile(2657, 3157, 0)),
                new Step(new Tile(2666, 3160, 0)),
                new Step(new Tile(2675, 3161, 0))
        )));
    }
}
