package org.booleanfloat.traveler.regions.asgarnia;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Burthorpe implements Region {
    public static Location Castle;
    public static Location GamesRoom;
    public static Location GamesRoomEntrance;
    public static Location NorthEastHouse;
    public static Location Pub;
    public static Location Tent;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(Castle);
        locations.add(GamesRoom);
        locations.add(GamesRoomEntrance);
        locations.add(NorthEastHouse);
        locations.add(Pub);
        locations.add(Tent);

        return locations;
    }

    public static void initLocations() {
        Castle = new Location("Burthorpe, Castle", new Area(
                new Tile(2902, 3564, 0),
                new Tile(2897, 3558, 0)
        ));

        GamesRoom = new Location("Burthorpe, GamesRoom", new Area(
                new Tile(2210, 4962, 0),
                new Tile(2205, 4957, 0)
        ));

        GamesRoomEntrance = new Location("Burthorpe, GamesRoomEntrance", new Area(
                new Tile(2209, 4940, 0),
                new Tile(2206, 4938, 0)
        ));

        NorthEastHouse = new Location("Burthorpe, NorthEastHouse", new Area(
                new Tile(2934, 3569, 0),
                new Tile(2929, 3564, 0)
        ));

        Pub = new Location("Burthorpe, Pub", new Area(
                new Tile(2913, 3542, 0),
                new Tile(2906, 3535, 0)
        ));

        Tent = new Location("Burthorpe, Tent", new Area(
                new Tile(2887, 3541, 0),
                new Tile(2888, 3540, 0),
                new Tile(2886, 3537, 0),
                new Tile(2884, 3539, 0)
        ));
    }

    public static void initLinks(final ClientContext ctx) {
        new TwoWayLink(Castle, Pub, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2898, 3560, 0)),
                new Obstacle(7108, "Open", new Tile(2898, 3558, 0), new int[]{0, 128, -192, 0, 96, 144}),
                new Obstacle(7111, "Open", new Tile(2899, 3558, 0), new int[]{0, 128, -192, 0, 96, 144}),
                new Step(new Tile(2899, 3546, 0)),
                new Step(new Tile(2907, 3545, 0)),
                new Obstacle(7129, "Open", new Tile(2907, 3544, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(2909, 3539, 0))
        )));

        new TwoWayLink(GamesRoom, GamesRoomEntrance, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2207, 4956, 0)),
                new Step(new Tile(2208, 4946, 0)),
                new Obstacle(4629, "Open", new Tile(2208, 4946, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Obstacle(4633, "Open", new Tile(2207, 4946, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(2207, 4945, 0)),
                new Obstacle(4633, "Open", new Tile(2208, 4943, 0), new int[]{0, 128, -214, 0, 96, 144}),
                new Obstacle(4629, "Open", new Tile(2207, 4943, 0), new int[]{0, 128, -214, 0, 96, 144}),
                new Step(new Tile(2207, 4943, 0))
        )));

        new OneWayLink(Castle, GamesRoomEntrance, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2900, 3565, 0)),
                new Obstacle(4624, "Climb-down", new Tile(2900, 3567, 0), new int[]{-96, 96, -64, 0, -128, 196}),
                new Step(new Tile(2207, 4934, 1)),
                new Obstacle(4620, "Climb-down", new Tile(2208, 4936, 1), new int[]{-96, 96, -64, 0, -64, 0})
        )));

        new OneWayLink(GamesRoomEntrance, Castle, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2207, 4938, 0)),
                new Obstacle(4622, "Climb-up", new Tile(2208, 4936, 0), new int[]{-96, 64, -64, 0, -128, 196}),
                new Step(new Tile(2206, 4934, 1)),
                new Obstacle(4627, "Climb-up", new Tile(2206, 4936, 1), new int[]{-96, 96, -64, 0, -128, 196})
        )));

        new TwoWayLink(Pub, Tent, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2909, 3540, 0)),
                new Obstacle(7129, "Open", new Tile(2907, 3544, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(2907, 3545, 0)),
                new Step(new Tile(2888, 3537, 0)),
                new Step(new Tile(2887, 3540, 0))
        )));

        new TwoWayLink(Pub, NorthEastHouse, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2907, 3542, 0)),
                new Obstacle(7129, "Open", new Tile(2907, 3544, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(2907, 3545, 0)),
                new Step(new Tile(2916, 3545, 0)),
                new Step(new Tile(2933, 3563, 0)),
                new Obstacle(7122, "Open", new Tile(2932, 3564, 0), new int[]{0, 128, -192, 0, 96, 144}),
                new Step(new Tile(2932, 3566, 0))
        )));

        new TwoWayLink(Pub, Taverly.DruidsCircle, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2908, 3541, 0)),
                new Obstacle(7129, "Open", new Tile(2907, 3544, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(2908, 3545, 0)),
                new Step(new Tile(2904, 3545, 0)),
                new Step(new Tile(2904, 3527, 0)),
                new Step(new Tile(2916, 3513, 0)),
                new Step(new Tile(2923, 3486, 0))
        )));

        new TwoWayLink(Pub, Taverly.POHPortal, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2909, 3539, 0)),
                new Obstacle(7129, "Open", new Tile(2907, 3544, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(2907, 3545, 0)),
                new Step(new Tile(2903, 3545, 0)),
                new Step(new Tile(2904, 3525, 0)),
                new Step(new Tile(2907, 3521, 0)),
                new Step(new Tile(2905, 3512, 0)),
                new Step(new Tile(2908, 3493, 0)),
                new Step(new Tile(2902, 3479, 0)),
                new Step(new Tile(2899, 3476, 0)),
                new Step(new Tile(2896, 3465, 0))
        )));
    }
}
