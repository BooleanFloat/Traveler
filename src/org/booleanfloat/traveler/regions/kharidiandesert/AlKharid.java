package org.booleanfloat.traveler.regions.kharidiandesert;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.asgarnia.PortSarim;
import org.booleanfloat.traveler.regions.misthalin.Lumbridge;
import org.booleanfloat.traveler.regions.misthalin.Varrock;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.npcs.Shantay;
import org.booleanfloat.traveler.steps.obstacles.AlKharidTollGate;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class AlKharid implements Region {

    public static Location Bank;
    public static Location CrossRoads;
    public static Location DuelArenaEntrance;
    public static Location DuelAreanTicketOffice;
    public static Location Mine;
    public static Location MineDigSpot;
    public static Location NorthFenceOpening;
    public static Location NorthHouse;
    public static Location PalaceChests;
    public static Location PalaceThroneRoom;
    public static Location ShantyPass;
    public static Location Tanner;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(CrossRoads);
        locations.add(DuelArenaEntrance);
        locations.add(DuelAreanTicketOffice);
        locations.add(Mine);
        locations.add(MineDigSpot);
        locations.add(NorthFenceOpening);
        locations.add(NorthHouse);
        locations.add(PalaceChests);
        locations.add(PalaceThroneRoom);
        locations.add(ShantyPass);
        locations.add(Tanner);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("AlKharid, Bank", new Area(
                new Tile(3272, 3172, 0),
                new Tile(3268, 3160, 0)
        ));

        CrossRoads = new Location("AlKharid, CrossRoads", new Area(
                new Tile(3280, 3229, 0),
                new Tile(3274, 3223, 0)
        ));

        DuelArenaEntrance = new Location("AlKharid, DuelArenaEntrance", new Area(
                new Tile(3310, 3236, 0),
                new Tile(3315, 3232, 0)
        ));

        DuelAreanTicketOffice = new Location("AlKharid, DuelAreanTicketOffice", new Area(
                new Tile(3316, 3243, 0),
                new Tile(3312, 3239, 0)
        ));

        Mine = new Location("Alkharid, Mine", new Area(
                new Tile(3301, 3319, 0),
                new Tile(3304, 3316, 0),
                new Tile(3303, 3312, 0),
                new Tile(3306, 3311, 0),
                new Tile(3304, 3308, 0),
                new Tile(3308, 3303, 0),
                new Tile(3304, 3296, 0),
                new Tile(3308, 3292, 0),
                new Tile(3303, 3286, 0),
                new Tile(3307, 3281, 0),
                new Tile(3306, 3275, 0),
                new Tile(3291, 3275, 0),
                new Tile(3293, 3279, 0),
                new Tile(3291, 3281, 0),
                new Tile(3294, 3291, 0),
                new Tile(3290, 3298, 0),
                new Tile(3295, 3305, 0),
                new Tile(3293, 3310, 0),
                new Tile(3296, 3314, 0),
                new Tile(3296, 3318, 0)
        ));

        MineDigSpot = new Location("AlKharid, MineDigSpot", new Area(
                new Tile(3301, 3292, 0),
                new Tile(3299, 3290, 0)
        ));

        NorthFenceOpening = new Location("AlKharid, NorthFenceOpening", new Area(
                new Tile(3286, 3332, 0),
                new Tile(3279, 3326, 0)
        ));

        NorthHouse = new Location("AlKharid, NorthHouse", new Area(
                new Tile(3297, 3205, 0),
                new Tile(3289, 3201, 0)
        ));

        PalaceChests = new Location("AlKharid, PalaceChests", new Area(
                new Tile(3302, 3169, 1),
                new Tile(3298, 3167, 1)
        ));

        PalaceThroneRoom = new Location("AlKharid, PalaceThroneRoom", new Area(
                new Tile(3304, 3166, 0),
                new Tile(3282, 3158, 0)
        ));

        ShantyPass = new Location("AlKharid, ShantyPass", new Area(
                new Tile(3306, 3132, 0),
                new Tile(3311, 3126, 0),
                new Tile(3311, 3117, 0),
                new Tile(3307, 3115, 0),
                new Tile(3301, 3115, 0),
                new Tile(3294, 3120, 0),
                new Tile(3294, 3126, 0),
                new Tile(3301, 3131, 0)
        ));

        Tanner = new Location("AlKharid, Tanner", new Area(
                new Tile(3277, 3193, 0),
                new Tile(3271, 3189, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Bank, CrossRoads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3270, 3166, 0)),
                new Step(new Tile(3276, 3166, 0)),
                new Step(new Tile(3283, 3187, 0)),
                new Step(new Tile(3276, 3226, 0))
        )));

        new TwoWayLink(Bank, PalaceThroneRoom, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3270, 3165, 0)),
                new Step(new Tile(3276, 3166, 0)),
                new Step(new Tile(3280, 3181, 0)),
                new Step(new Tile(3295, 3180, 0)),
                new Step(new Tile(3293, 3167, 0)),
                new Obstacle(6837, "Open", new Tile(3292, 3167, 0)),
                new Obstacle(6839, "Open", new Tile(3293, 3167, 0)),
                new Step(new Tile(3293, 3163, 0))
        )));

        new TwoWayLink(Bank, ShantyPass, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3270, 3165, 0)),
                new Step(new Tile(3276, 3165, 0)),
                new Step(new Tile(3279, 3154, 0)),
                new Step(new Tile(3303, 3138, 0)),
                new Step(new Tile(3303, 3127, 0))
        )));

        new TwoWayLink(CrossRoads, DuelArenaEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3278, 3226, 0)),
                new Step(new Tile(3294, 3237, 0)),
                new Step(new Tile(3313, 3234, 0))
        )));

        new TwoWayLink(CrossRoads, Mine, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3277, 3226, 0)),
                new Step(new Tile(3292, 3269, 0)),
                new Step(new Tile(3299, 3275, 0))
        )));

        new TwoWayLink(CrossRoads, NorthFenceOpening);

        new TwoWayLink(CrossRoads, NorthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3278, 3224, 0)),
                new Step(new Tile(3292, 3206, 0)),
                new Obstacle(7120, "Open", new Tile(3292, 3206, 0), new int[]{0, 100, -224, 0, 112, 128})
        )));

        new TwoWayLink(CrossRoads, PalaceThroneRoom, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3276, 3225, 0)),
                new Step(new Tile(3282, 3187, 0)),
                new Step(new Tile(3292, 3179, 0)),
                new Step(new Tile(3294, 3167, 0)),
                new Obstacle(6837, "Open", new Tile(3292, 3167, 0)),
                new Obstacle(6839, "Open", new Tile(3293, 3167, 0)),
                new Step(new Tile(3293, 3165, 0))
        )));

        new TwoWayLink(CrossRoads, Tanner, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3277, 3226, 0)),
                new Step(new Tile(3280, 3190, 0)),
                new Step(new Tile(3276, 3190, 0)),
                new Obstacle(7122, "Open", new Tile(3277, 3191, 0), new int[]{112, 128, -224, 0, 10, 130})
        )));

        new OneWayLink(CrossRoads, Lumbridge.EastCrossRoads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3277, 3226, 0)),
                new Step(new Tile(3269, 3227, 0)),
                new AlKharidTollGate(2882, AlKharidTollGate.Direction.OUT),
                new AlKharidTollGate(2883, AlKharidTollGate.Direction.OUT),
                new Step(new Tile(3267, 3227, 0)),
                new Step(new Tile(3258, 3227, 0))
        )), new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // requires 10 coins
                return ctx.inventory.select().id(Config.COINS_ID).poll().stackSize() >= 10;
            }
        });

        new TwoWayLink(DuelArenaEntrance, DuelAreanTicketOffice, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3313, 3233, 0)),
                new Step(new Tile(3319, 3235, 0)),
                new Step(new Tile(3318, 3240, 0)),
                // door
                new Step(new Tile(3314, 3241, 0))
        )));

        new TwoWayLink(Mine, MineDigSpot);

        new TwoWayLink(Mine, NorthFenceOpening, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3300, 3272, 0)),
                new Step(new Tile(3287, 3273, 0)),
                new Step(new Tile(3288, 3293, 0)),
                new Step(new Tile(3283, 3327, 0))
        )));

        new TwoWayLink(NorthFenceOpening, Lumbridge.NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3282, 3330, 0)),
                new Step(new Tile(3270, 3330, 0)),
                new Step(new Tile(3257, 3324, 0)),
                new Step(new Tile(3238, 3303, 0)),
                new Step(new Tile(3242, 3263, 0))
        )));

        new TwoWayLink(NorthFenceOpening, Varrock.DigSiteBush, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3283, 3331, 0)),
                new Step(new Tile(3297, 3334, 0)),
                new Step(new Tile(3310, 3331, 0)),
                new Obstacle(11766, "Open", new Tile(3311, 3331, 0), new int[]{0, 32, -128, 0, 0, 128}),
                new Obstacle(11767, "Open", new Tile(3311, 3332, 0), new int[]{0, 32, -128, 0, 0, 128}),
                new Step(new Tile(3313, 3331, 0)),
                new Step(new Tile(3334, 3355, 0)),
                new Step(new Tile(3343, 3366, 0)),
                new Step(new Tile(3343, 3374, 0)),
                new Step(new Tile(3340, 3375, 0)),
                new Step(new Tile(3341, 3380, 0)),
                new Step(new Tile(3345, 3381, 0)),
                new Step(new Tile(3345, 3379, 0))
        )));

        new TwoWayLink(NorthFenceOpening, Varrock.EastGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3283, 3332, 0)),
                new Step(new Tile(3298, 3358, 0)),
                new Step(new Tile(3291, 3407, 0)),
                new Step(new Tile(3275, 3429, 0))
        )));

        new TwoWayLink(NorthFenceOpening, Varrock.ExamCenter, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3284, 3331, 0)),
                new Step(new Tile(3297, 3335, 0)),
                new Step(new Tile(3310, 3331, 0)),
                new Obstacle(11766, "Open", new Tile(3311, 3331, 0), new int[]{0, 32, -128, 0, 0, 128}),
                new Obstacle(11767, "Open", new Tile(3311, 3332, 0), new int[]{0, 32, -128, 0, 0, 128}),
                new Step(new Tile(3313, 3331, 0)),
                new Step(new Tile(3326, 3347, 0)),
                new Step(new Tile(3349, 3346, 0)),
                new Step(new Tile(3355, 3343, 0)),
                new Obstacle(17316, "Open", new Tile(3357, 3344, 0)),
                new Step(new Tile(3358, 3343, 0))
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

        new OneWayLink(PalaceChests, PalaceThroneRoom, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3285, 3164, 1)),
                new Obstacle(16679, "Climb-down", new Tile(3284, 3165, 1)),
                new Step(new Tile(3284, 3164, 0))
        )));

        new OneWayLink(PalaceThroneRoom, PalaceChests, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3284, 3164, 0)),
                new Obstacle(16683, "Climb-up", new Tile(3284, 3165, 0)),
                new Step(new Tile(3285, 3164, 1))
        )));

        new OneWayLink(ShantyPass, PortSarim.ShantyPassCell, new ArrayList<>(Arrays.asList(
                new Shantay()
        )));
    }
}
