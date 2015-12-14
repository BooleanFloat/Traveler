package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class VarrockCastle implements Region {
    public static Location Cart;
    public static Location Courtyard;
    public static Location Crossroads;
    public static Location Entrance;
    public static Location Kitchen;
    public static Location Library;
    public static Location TrainingRoom;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Cart);
        locations.add(Courtyard);
        locations.add(Crossroads);
        locations.add(Entrance);
        locations.add(Kitchen);
        locations.add(Library);
        locations.add(TrainingRoom);

        return locations;
    }

    public static void initLocations() {
        Cart = new Location("VarrockCastle, Cart", new Area(
                new Tile(3229, 3453, 0),
                new Tile(3224, 3448, 0)
        ));

        Courtyard = new Location("VarrockCastle, Courtyard", new Area(
                new Tile(3218, 3466, 0),
                new Tile(3209, 3459, 0)
        ));

        Crossroads = new Location("VarrockCastle, Crossroads", new Area(
                new Tile(3214, 3452, 0),
                new Tile(3212, 3444, 0)
        ));

        Entrance = new Location("VarrockCastle, Entrance", new Area(
                new Tile(3213, 3471, 0),
                new Tile(3212, 3469, 0)
        ));

        Kitchen = new Location("VarrockCastle, Kitchen", new Area(
                new Tile(3224, 3496, 0),
                new Tile(3218, 3491, 0)
        ));

        Library = new Location("VarrockCastle, Library", new Area(
                new Tile(3217, 3497, 0),
                new Tile(3217, 3494, 0),
                new Tile(3214, 3494, 0),
                new Tile(3214, 3490, 0),
                new Tile(3207, 3490, 0),
                new Tile(3207, 3497, 0)
        ));

        TrainingRoom = new Location("VarrockCastle, TraningRoom", new Area(
                new Tile(3205, 3473, 1),
                new Tile(3202, 3470, 1)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Cart, Crossroads);
        new TwoWayLink(Courtyard, Crossroads);
        new TwoWayLink(Courtyard, Entrance);
        new TwoWayLink(Crossroads, Varrock.Fountain);

        new TwoWayLink(Crossroads, Varrock.GrandExchange, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3202, 3454, 0)),
                new Step(new Tile(3197, 3462, 0)),
                new Step(new Tile(3195, 3489, 0))
        )));

        new TwoWayLink(Entrance, Kitchen, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3212, 3470, 0)),
                new Step(new Tile(3207, 3476, 0)),
                new Step(new Tile(3207, 3487, 0)),
                new Step(new Tile(3216, 3487, 0)),
                new Step(new Tile(3216, 3491, 0)),
                new Obstacle(11773, "Open", new Tile(3217, 3492, 0), new int[]{96, 128, -224, 0, 16, 96}),
                new Step(new Tile(3219, 3491, 0))
        )));

        new TwoWayLink(Entrance, Library, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3212, 3470, 0)),
                new Step(new Tile(3207, 3476, 0)),
                new Step(new Tile(3207, 3487, 0)),
                new Step(new Tile(3210, 3488, 0)),
                new Obstacle(11773, "Open", new Tile(3210, 3490, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(3210, 3490, 0))
        )));

        new OneWayLink(Entrance, TrainingRoom, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3212, 3472, 0)),
                new Obstacle(11807, "Climb-up", new Tile(3213, 3474, 0)),
                new Step(new Tile(3212, 3476, 1)),
                new Step(new Tile(3207, 3473, 1)),
                new Obstacle(11773, "Open", new Tile(3207, 3473, 1))
        )));

        new OneWayLink(TrainingRoom, Entrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3207, 3473, 1)),
                new Obstacle(11773, "Open", new Tile(3207, 3473, 1)),
                new Step(new Tile(3212, 3476, 1)),
                new Obstacle(11799, "Climb-down", new Tile(3213, 3475, 1)),
                new Step(new Tile(3212, 3472, 0))
        )));
    }
}
