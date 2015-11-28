package org.booleanfloat.traveler.regions.kharidiandesert;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.misthalin.Lumbridge;
import org.booleanfloat.traveler.regions.misthalin.Varrock;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class AlKharid implements Region {

    public static Location CrossRoads;
    public static Location NorthFenceOpening;
    public static Location NorthHouse;
    public static Location Tanner;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(CrossRoads);
        locations.add(NorthFenceOpening);
        locations.add(NorthHouse);
        locations.add(Tanner);

        return locations;
    }

    public static void initLocations() {
        CrossRoads = new Location("AlKharid, CrossRoads", new Area(
                new Tile(3280, 3229, 0),
                new Tile(3274, 3223, 0)
        ));

        NorthFenceOpening = new Location("AlKharid, NorthFenceOpening", new Area(
                new Tile(3286, 3332, 0),
                new Tile(3279, 3326, 0)
        ));

        NorthHouse = new Location("AlKharid, NorthHouse", new Area(
                new Tile(3297, 3205, 0),
                new Tile(3289, 3201, 0)
        ));

        Tanner = new Location("AlKharid, Tanner", new Area(
                new Tile(3277, 3193, 0),
                new Tile(3271, 3189, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(CrossRoads, Lumbridge.EastCrossRoads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3276, 3226, 0)),
                new Step(new Tile(3270, 3226, 0)),
                new Obstacle(2882, "Pay-toll(10gp)", new Tile(3268, 3227, 0)),
                new Obstacle(2883, "Pay-toll(10gp)", new Tile(3268, 3228, 0)),
                new Step(new Tile(3266, 3227, 0))
        )), new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // requires 10 coins
                return ctx.inventory.select().id(Config.COINS_ID).poll().stackSize() >= 10;
            }
        });

        new TwoWayLink(CrossRoads, NorthFenceOpening);

        new TwoWayLink(CrossRoads, NorthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3278, 3224, 0)),
                new Step(new Tile(3292, 3206, 0)),
                new Obstacle(7120, "Open", new Tile(3292, 3206, 0), new int[]{0, 100, -224, 0, 112, 128})
        )));

        new TwoWayLink(CrossRoads, Tanner, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3277, 3226, 0)),
                new Step(new Tile(3280, 3190, 0)),
                new Step(new Tile(3276, 3190, 0)),
                new Obstacle(7122, "Open", new Tile(3277, 3191, 0), new int[]{112, 128, -224, 0, 10, 130})
        )));

        new TwoWayLink(NorthFenceOpening, Lumbridge.NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3282, 3330, 0)),
                new Step(new Tile(3270, 3330, 0)),
                new Step(new Tile(3257, 3324, 0)),
                new Step(new Tile(3238, 3303, 0)),
                new Step(new Tile(3242, 3263, 0))
        )));

        new TwoWayLink(NorthFenceOpening, Varrock.EastGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3283, 3332, 0)),
                new Step(new Tile(3298, 3358, 0)),
                new Step(new Tile(3291, 3407, 0)),
                new Step(new Tile(3275, 3429, 0))
        )));

        new TwoWayLink(NorthFenceOpening, Varrock.SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3282, 3332, 0)),
                new Step(new Tile(3248, 3337, 0)),
                new Step(new Tile(3229, 3337, 0)),
                new Step(new Tile(3224, 3354, 0)),
                new Step(new Tile(3210, 3381, 0))
        )));

        new TwoWayLink(NorthFenceOpening, Varrock.SouthMine, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3283, 3329, 0)),
                new Step(new Tile(3276, 3358, 0)),
                new Step(new Tile(3277, 3371, 0)),
                new Step(new Tile(3287, 3371, 0))
        )));
    }
}
