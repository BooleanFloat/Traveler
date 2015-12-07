package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.steps.ImportantStep;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.obstacles.AlKharidTollGate;
import org.booleanfloat.traveler.steps.obstacles.HamJailDoor;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Lumbridge implements Region {
    public static Location Center;
    public static Location Church;
    public static Location GoblinHouse;
    public static Location HamBarracks;
    public static Location HamBuilding;
    public static Location HamEntrance;
    public static Location HamForceExit1;
    public static Location HamForceExit2;
    public static Location HamForceExit3;
    public static Location HamForceExit4;
    public static Location HamForceExit5;
    public static Location HamJail;
    public static Location EastCrossRoads;
    public static Location NorthBridge;
    public static Location SwampShack;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Center);
        locations.add(Church);
        locations.add(GoblinHouse);
        locations.add(HamBarracks);
        locations.add(HamBuilding);
        locations.add(HamEntrance);
        locations.add(HamForceExit1);
        locations.add(HamForceExit2);
        locations.add(HamForceExit3);
        locations.add(HamForceExit4);
        locations.add(HamForceExit5);
        locations.add(HamJail);
        locations.add(EastCrossRoads);
        locations.add(NorthBridge);
        locations.add(SwampShack);

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

        GoblinHouse = new Location("Lumbridge, GoblinHouse", new Area(
                new Tile(3248, 3247, 0),
                new Tile(3243, 3243, 0)
        ));

        HamBarracks = new Location("Lumbridge, HamBarracks", new Area(
                new Tile(3180, 9657, 0),
                new Tile(3170, 9641, 0)
        ));

        HamBuilding = new Location("Lumbridge, HamBuilding", new Area(
                new Tile(3166, 3251, 0),
                new Tile(3164, 3249, 0)
        ));

        HamEntrance = new Location("Lumbridge, HamEntrace", new Area(
                new Tile(3152, 9653, 0),
                new Tile(3147, 9650, 0)
        ));

        HamForceExit1 = new Location("Lumbridge, HamForceExit1", new Area(
                new Tile(3165, 3239, 0),
                new Tile(3163, 3237, 0)
        ));

        HamForceExit2 = new Location("Lumbridge, HamForceExit2", new Area(
                new Tile(3186, 3214, 0),
                new Tile(3183, 3210, 0)
        ));

        HamForceExit3 = new Location("Lumbridge, HamForceExit3", new Area(
                new Tile(3142, 3229, 0),
                new Tile(3138, 3225, 0)
        ));

        HamForceExit4 = new Location("Lumbridge, HamForceExit4", new Area(
                new Tile(3140, 3260, 0),
                new Tile(3137, 3256, 0)
        ));

        HamForceExit5 = new Location("Lumbridge, HamForceExit5", new Area(
                new Tile(3149, 3217, 0),
                new Tile(3146, 3215, 0)
        ));

        HamJail = new Location("Lumbridge, HamJail", new Area(
                new Tile(3187, 9613, 0),
                new Tile(3183, 9607, 0)
        ));

        EastCrossRoads = new Location("Lumbridge, EastCrossRoads", new Area(
                new Tile(3262, 3229, 0),
                new Tile(3256, 3225, 0)
        ));

        NorthBridge = new Location("Lumbridge, NorthBridge", new Area(
                new Tile(3243, 3264, 0),
                new Tile(3228, 3260, 0)
        ));

        SwampShack = new Location("Lumbridge, SwampShack", new Area(
                new Tile(3206, 3170, 0),
                new Tile(3202, 3167, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Center, Church, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3210, 0)),
                new Obstacle(7129, "Open", new Tile(3238, 3210, 0)),
                new Step(new Tile(3242, 3210, 0))
        )));

        new TwoWayLink(Center, EastCrossRoads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3236, 3219, 0)),
                new Step(new Tile(3236, 3225, 0)),
                new Step(new Tile(3257, 3225, 0))
        )));

        new TwoWayLink(Center, HamBuilding, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3218, 0)),
                new Step(new Tile(3236, 3226, 0)),
                new Step(new Tile(3223, 3237, 0)),
                new Step(new Tile(3168, 3244, 0)),
                new Step(new Tile(3166, 3250, 0))
        )));

        new TwoWayLink(Center, NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3219, 0)),
                new Step(new Tile(3219, 3243, 0)),
                new Step(new Tile(3219, 3260, 0)),
                new Step(new Tile(3235, 3261, 0))
        )));

        new TwoWayLink(Center, SwampShack, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3235, 3218, 0)),
                new Step(new Tile(3235, 3201, 0)),
                new Step(new Tile(3244, 3199, 0)),
                new Step(new Tile(3244, 3188, 0)),
                new Step(new Tile(3230, 3188, 0)),
                new Step(new Tile(3219, 3178, 0)),
                new Step(new Tile(3211, 3167, 0)),
                new Step(new Tile(3205, 3163, 0)),
                new Step(new Tile(3200, 3165, 0)),
                new Step(new Tile(3200, 3168, 0)),
                new Obstacle(2406, "Open", new Tile(3202, 3169, 0), new int[]{-32, 32, -192, 0, 0, 128}),
                new Step(new Tile(3203, 3168, 0))
        )));

        new TwoWayLink(EastCrossRoads, GoblinHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3260, 3228, 0)),
                new Step(new Tile(3260, 3232, 0)),
                new Step(new Tile(3246, 3241, 0)),
                new Obstacle(7122, "Open", new Tile(3246, 3244, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(3247, 3244, 0))
        )));

        new OneWayLink(EastCrossRoads, AlKharid.CrossRoads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3258, 3227, 0)),
                new Step(new Tile(3267, 3227, 0)),
                new AlKharidTollGate(2882, AlKharidTollGate.Direction.IN),
                new AlKharidTollGate(2883, AlKharidTollGate.Direction.IN),
                new Step(new Tile(3269, 3227, 0)),
                new Step(new Tile(3277, 3226, 0))
        )), new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // requires 10 coins
                return ctx.inventory.select().id(Config.COINS_ID).poll().stackSize() >= 10;
            }
        });

        new TwoWayLink(GoblinHouse, NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3247, 3246, 0)),
                new Obstacle(7122, "Open", new Tile(3246, 3244, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(3246, 3241, 0)),
                new Step(new Tile(3255, 3241, 0)),
                new Step(new Tile(3255, 3251, 0)),
                new Step(new Tile(3252, 3253, 0)),
                new Step(new Tile(3250, 3261, 0)),
                new Step(new Tile(3239, 3261, 0))
        )));

        new TwoWayLink(HamBarracks, HamEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3174, 9641, 0)),
                new Obstacle(7122, "Open", new Tile(3174, 9641, 0)),
                new Step(new Tile(3173, 9638, 0)),
                new Step(new Tile(3168, 9636, 0)),
                new Step(new Tile(3159, 9638, 0)),
                new Obstacle(7122, "Open", new Tile(3158, 9640, 0)),
                new Step(new Tile(3157, 9641, 0))
        )));

        new TwoWayLink(HamBuilding, NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3166, 3247, 0)),
                new Step(new Tile(3168, 3244, 0)),
                new Step(new Tile(3190, 3243, 0)),
                new Step(new Tile(3213, 3255, 0)),
                new Step(new Tile(3230, 3261, 0))
        )));

        new OneWayLink(HamBuilding, HamEntrance, new ArrayList<>(Arrays.asList(
                new Obstacle(5490, "Pick-Lock", 3000, new Tile(3166, 3252, 0), new int[]{0, 128, 10, 0, 0, 128}),
                new Obstacle(5491, "Climb-down", new Tile(3166, 3252, 0), new int[]{0, 128, -64, 0, 0, 128})
        )));

        new TwoWayLink(HamBuilding, WizardsTower.Causeway, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3165, 3250, 0)),
                new Step(new Tile(3165, 3247, 0)),
                new Step(new Tile(3146, 3231, 0)),
                new Step(new Tile(3123, 3218, 0)),
                new Step(new Tile(3114, 3206, 0))
        )));

        new OneWayLink(HamEntrance, HamBuilding, new ArrayList<>(Arrays.asList(
                new Obstacle(5493, "Climb-up", new Tile(3149, 9653, 0))
        )));

        new OneWayLink(HamForceExit1, HamBuilding);
        new OneWayLink(HamForceExit2, HamBuilding);
        new OneWayLink(HamForceExit3, HamBuilding);
        new OneWayLink(HamForceExit4, HamBuilding);
        new OneWayLink(HamForceExit5, HamBuilding);

        new OneWayLink(HamJail, HamBarracks, new ArrayList<>(Arrays.asList(
                new HamJailDoor(),
                new Step(new Tile(3182, 9611, 0)),
                new Step(new Tile(3178, 9615, 0)),
                new Step(new Tile(3173, 9619, 0)),
                new Obstacle(7122, "Open", new Tile(3171, 9621, 0), new int[]{148, 116, -220, 0, -14, 132}),
                new Step(new Tile(3171, 9623, 0)),
                new Step(new Tile(3171, 9627, 0)),
                new Step(new Tile(3172, 9631, 0)),
                new Step(new Tile(3173, 9638, 0)),
                new Obstacle(7122, "Open", new Tile(3174, 9641, 0))
        )));

        new OneWayLink(HamJail, HamEntrance, new ArrayList<>(Arrays.asList(
                new ImportantStep(new Tile(3183, 9611, 0)),
                new HamJailDoor(),
                new Step(new Tile(3182, 9611, 0)),
                new Step(new Tile(3171, 9621, 0)),
                new Obstacle(7122, "Open", new Tile(3171, 9621, 0), new int[]{148, 116, -220, 0, -14, 132}),
                new Step(new Tile(3170, 9623, 0)),
                new Step(new Tile(3160, 9627, 0)),
                new Step(new Tile(3159, 9638, 0)),
                new Obstacle(7122, "Open", new Tile(3158, 9640, 0)),
                new Step(new Tile(3157, 9641, 0))
        )));

        new TwoWayLink(EastCrossRoads, NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3258, 3227, 0)),
                new Step(new Tile(3260, 3240, 0)),
                new Step(new Tile(3244, 3263, 0))
        )));

        new TwoWayLink(NorthBridge, Varrock.SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3243, 3263, 0)),
                new Step(new Tile(3239, 3282, 0)),
                new Step(new Tile(3239, 3304, 0)),
                new Step(new Tile(3224, 3311, 0)),
                new Step(new Tile(3211, 3335, 0)),
                new Step(new Tile(3204, 3344, 0)),
                new Step(new Tile(3211, 3382, 0))
        )));

        new TwoWayLink(SwampShack, WizardsTower.Causeway, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3203, 3169, 0)),
                new Obstacle(2406, "Open", new Tile(3202, 3169, 0), new int[]{-32, 32, -192, 0, 0, 128}),
                new Step(new Tile(3200, 3168, 0)),
                new Step(new Tile(3192, 3179, 0)),
                new Step(new Tile(3185, 3181, 0)),
                new Step(new Tile(3175, 3198, 0)),
                new Step(new Tile(3157, 3198, 0)),
                new Step(new Tile(3137, 3208, 0)),
                new Step(new Tile(3114, 3208, 0)),
                new Step(new Tile(3114, 3205, 0))
        )));
    }
}
