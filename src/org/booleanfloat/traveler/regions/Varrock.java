package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.OneWayLink;
import org.booleanfloat.traveler.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Varrock {

    public static Location castleCourtyard;
    public static Location castleEntrance;
    public static Location castleTrainingRoom;
    public static Location clothesStore;
    public static Location eastBank;
    public static Location eastGate;
    public static Location fountain;
    public static Location grandExchange;
    public static Location southGate;
    public static Location westBank;

    public static void init() {
        castleCourtyard = new Location("Varrock castle courtyard", new Area(
                new Tile(3214, 3449, 0),
                new Tile(3211, 3448, 0)
        ));

        castleEntrance = new Location("Varrock castle entrance", new Area(
                new Tile(3213, 3471, 0),
                new Tile(3212, 3469, 0)
        ));

        castleTrainingRoom = new Location("Varrock castle traning room", new Area(
                new Tile(3205, 3473, 1),
                new Tile(3202, 3470, 1)
        ));

        clothesStore = new Location("Varrock clothing store", new Area(
                new Tile(3207, 3418, 0),
                new Tile(3204, 3414, 0)
        ));

        eastBank = new Location("Varrock east bank", new Area(
                new Tile(3254, 3422, 0),
                new Tile(3250, 3420, 0)
        ));

        eastGate = new Location("Varrock east gate", new Area(
                new Tile(3275, 3431, 0),
                new Tile(3271, 3426, 0)
        ));

        fountain = new Location("Varrock fountain", new Area(
                new Tile(3216, 3432, 0),
                new Tile(3209, 3425, 0)
        ));

        grandExchange = new Location("Varrock grand exchange", new Area(
                new Tile(3168, 3493, 0),
                new Tile(3161, 3486, 0)
        ));

        southGate = new Location("Varrock south gate", new Area(
                new Tile(3213, 3382, 0),
                new Tile(3210, 3380, 0)
        ));

        westBank = new Location("Varrock west bank", new Area(
                new Tile(3185, 3439, 0),
                new Tile(3181, 3434, 0)
        ));

        new TwoWayLink(castleCourtyard, castleEntrance);

        new OneWayLink(castleEntrance, castleTrainingRoom, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3212, 3472, 0)),
                new Obstacle(11807, "Climb-up", new Tile(3213, 3474, 0)),
                new Step(new Tile(3212, 3476, 1)),
                new Step(new Tile(3207, 3473, 1)),
                new Obstacle(11773, "Open", new Tile(3207, 3473, 1))
        )));

        new OneWayLink(castleTrainingRoom, castleEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3207, 3473, 1)),
                new Obstacle(11773, "Open", new Tile(3207, 3473, 1)),
                new Step(new Tile(3212, 3476, 1)),
                new Obstacle(11799, "Climb-down", new Tile(3213, 3475, 1)),
                new Step(new Tile(3212, 3472, 0))
        )));

        new TwoWayLink(castleCourtyard, fountain);

        new TwoWayLink(clothesStore, fountain, new ArrayList<>(Arrays.asList(
                new Obstacle(11775, "Open", new Tile(3209, 3415, 0)),
                new Step(new Tile(3210, 3415, 0))
        )));

        new TwoWayLink(clothesStore, southGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3210, 3415, 0))
        )));

        new TwoWayLink(castleCourtyard, grandExchange, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3202, 3454, 0)),
                new Step(new Tile(3197, 3462, 0)),
                new Step(new Tile(3195, 3489, 0))
        )));

        new TwoWayLink(eastBank, eastGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3255, 3427, 0))
        )));

        new TwoWayLink(fountain, eastGate);

        new TwoWayLink(fountain, eastBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3253, 3428, 0))
        )));

        new TwoWayLink(fountain, southGate);

        new TwoWayLink(fountain, westBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3183, 3429, 0))
        )));

        new TwoWayLink(grandExchange, westBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3166, 3461, 0)),
                new Step(new Tile(3183, 3448, 0))
        )));
    }
}
