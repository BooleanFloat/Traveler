package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.asgarnia.PortSarim;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.obstacles.DraynorManorBackDoor;
import org.booleanfloat.traveler.steps.obstacles.DraynorManorFrontDoor;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Draynor implements Region {
    public static Location Bank;
    public static Location CrossRoads;
    public static Location GloryTeleport;
    public static Location ManorAttic;
    public static Location ManorEntrance;
    public static Location ManorFountain;
    public static Location ManorKitchen;
    public static Location Market;
    public static Location NedsHouse;
    public static Location NorthHouse;
    public static Location WestFenceOpening;
    public static Location WitchAgiesHouse;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(CrossRoads);
        locations.add(GloryTeleport);
        locations.add(ManorAttic);
        locations.add(ManorEntrance);
        locations.add(ManorFountain);
        locations.add(ManorKitchen);
        locations.add(Market);
        locations.add(NedsHouse);
        locations.add(NorthHouse);
        locations.add(WestFenceOpening);
        locations.add(WitchAgiesHouse);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("Draynor, Bank", new Area(
                new Tile(3096, 3245, 0),
                new Tile(3091, 3239, 0)
        ));

        CrossRoads = new Location("Draynor, CrossRoads", new Area(
                new Tile(3111, 3295, 0),
                new Tile(3109, 3293, 0)
        ));

        GloryTeleport = new Location("Draynor, GloryTeleport", new Area(
                new Tile(3106, 3251, 0),
                new Tile(3102, 3247, 0)
        ));

        ManorAttic = new Location("Draynor, ManorAttic", new Area(
                new Tile(3107, 3370, 2),
                new Tile(3104, 3362, 2)
        ));

        ManorEntrance = new Location("Draynor, ManorEntrance", new Area(
                new Tile(3113, 3357, 0),
                new Tile(3105, 3353, 0)
        ));

        ManorFountain = new Location("Draynor, ManorFountain", new Area(
                new Tile(3091, 3337, 0),
                new Tile(3085, 3331, 0)
        ));

        ManorKitchen = new Location("Draynor, ManorKitchen", new Area(
                new Tile(3127, 3360, 0),
                new Tile(3119, 3354, 0)
        ));

        Market = new Location("Draynor, Market", new Area(
                new Tile(3084, 3253, 0),
                new Tile(3075, 3245, 0)
        ));

        NedsHouse = new Location("Draynor, NedsHouse", new Area(
                new Tile(3101, 3261, 0),
                new Tile(3096, 3256, 0)
        ));

        NorthHouse = new Location("Draynor, NorthHouse", new Area(
                new Tile(3102, 3280, 0),
                new Tile(3098, 3277, 0)
        ));

        WestFenceOpening = new Location("Draynor, WestFenceOpening", new Area(
                new Tile(3071, 3278, 0),
                new Tile(3069, 3275, 0)
        ));

        WitchAgiesHouse = new Location("Draynor, WitchAgiesHouse", new Area(
                new Tile(3088, 3262, 0),
                new Tile(3083, 3256, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Bank, Market, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3093, 3247, 0))
        )));

        new TwoWayLink(Bank, GloryTeleport, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3093, 3247, 0))
        )));

        new TwoWayLink(CrossRoads, GloryTeleport, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3294, 0)),
                new Step(new Tile(3109, 3282, 0)),
                new Step(new Tile(3105, 3275, 0)),
                new Step(new Tile(3104, 3249, 0))
        )));

        new TwoWayLink(CrossRoads, ManorEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3294, 0)),
                new Step(new Tile(3110, 3298, 0)),
                new Step(new Tile(3113, 3302, 0)),
                new Step(new Tile(3113, 3314, 0)),
                new Step(new Tile(3110, 3318, 0)),
                new Step(new Tile(3114, 3323, 0)),
                new Step(new Tile(3110, 3329, 0)),
                new Step(new Tile(3109, 3336, 0)),
                new Step(new Tile(3111, 3339, 0)),
                new Step(new Tile(3109, 3341, 0)),
                new Step(new Tile(3110, 3345, 0)),
                new Step(new Tile(3109, 3352, 0)),
                new DraynorManorFrontDoor(134, new Tile(3108, 3353, 0)),
                new DraynorManorFrontDoor(135, new Tile(3109, 3353, 0)),
                new Step(new Tile(3108, 3354, 0))
        )));

        new TwoWayLink(CrossRoads, ManorFountain, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3295, 0)),
                new Step(new Tile(3110, 3298, 0)),
                new Step(new Tile(3113, 3302, 0)),
                new Step(new Tile(3112, 3315, 0)),
                new Step(new Tile(3113, 3323, 0)),
                new Step(new Tile(3109, 3330, 0)),
                new Step(new Tile(3109, 3333, 0)),
                new Step(new Tile(3100, 3334, 0)),
                new Step(new Tile(3097, 3337, 0)),
                new Step(new Tile(3091, 3338, 0)),
                new Step(new Tile(3089, 3335, 0))
        )));

        new TwoWayLink(CrossRoads, NorthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3293, 0)),
                new Step(new Tile(3109, 3282, 0)),
                new Step(new Tile(3103, 3271, 0)),
                new Step(new Tile(3100, 3274, 0)),
                new Obstacle(7122, "Open", new Tile(3100, 3276, 0), Obstacle.Hitbox.DOOR_NORTH)
        )));

        new TwoWayLink(CrossRoads, WestFenceOpening, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3295, 0)),
                new Step(new Tile(3096, 3293, 0)),
                new Step(new Tile(3091, 3289, 0)),
                new Step(new Tile(3081, 3288, 0)),
                new Step(new Tile(3072, 3277, 0))
        )));

        new TwoWayLink(CrossRoads, Lumbridge.HamBuilding, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3295, 0)),
                new Step(new Tile(3132, 3293, 0)),
                new Step(new Tile(3138, 3265, 0)),
                new Step(new Tile(3166, 3248, 0))
        )));

        new TwoWayLink(CrossRoads, Lumbridge.WindMillCrossroads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3295, 0)),
                new Step(new Tile(3136, 3293, 0)),
                new Step(new Tile(3155, 3293, 0)),
                new Step(new Tile(3162, 3287, 0)),
                new Step(new Tile(3166, 3286, 0))
        )));

        new TwoWayLink(GloryTeleport, Market);

        new TwoWayLink(GloryTeleport, NedsHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3104, 3250, 0)),
                new Step(new Tile(3104, 3258, 0)),
                new Obstacle(7122, "Open", new Tile(3101, 3258, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(3100, 3258, 0))
        )));

        new TwoWayLink(GloryTeleport, WitchAgiesHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3105, 3250, 0)),
                new Step(new Tile(3104, 3263, 0)),
                new Step(new Tile(3095, 3262, 0)),
                new Step(new Tile(3090, 3258, 0)),
                new Obstacle(7122, "Open", new Tile(3088, 3258, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(3087, 3258, 0))
        )));

        new TwoWayLink(GloryTeleport, Lumbridge.HamBuilding, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3104, 3249, 0)),
                new Step(new Tile(3112, 3261, 0)),
                new Step(new Tile(3133, 3261, 0)),
                new Step(new Tile(3159, 3246, 0)),
                new Step(new Tile(3166, 3248, 0))
        )));

        new TwoWayLink(GloryTeleport, WizardsTower.Causeway, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3104, 3249, 0)),
                new Step(new Tile(3106, 3241, 0)),
                new Step(new Tile(3106, 3235, 0)),
                new Step(new Tile(3110, 3228, 0)),
                new Step(new Tile(3115, 3219, 0)),
                new Step(new Tile(3114, 3206, 0))
        )));

        new TwoWayLink(GloryTeleport, NorthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3105, 3249, 0)),
                new Step(new Tile(3106, 3272, 0)),
                new Step(new Tile(3099, 3271, 0)),
                new Step(new Tile(3100, 3275, 0)),
                new Obstacle(7122, "Open", new Tile(3100, 3276, 0), Obstacle.Hitbox.DOOR_NORTH)
        )));

        new TwoWayLink(GloryTeleport, LumbridgeCastle.BackEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3104, 3248, 0)),
                new Step(new Tile(3105, 3236, 0)),
                new Step(new Tile(3116, 3225, 0)),
                new Step(new Tile(3198, 3218, 0))
        )));

        new OneWayLink(ManorEntrance, ManorAttic, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3109, 3357, 0)),
                new Obstacle(11470, "Open", new Tile(3109, 3358, 0), Obstacle.Hitbox.DOOR_SOUTH),
                new Step(new Tile(3109, 3361, 0)),
                new Obstacle(11498, "Climb-up", new Tile(3109, 3364, 0)),
                new Step(new Tile(3106, 3364, 1)),
                new Obstacle(11511, "Climb-up", new Tile(3105, 3363, 1)),
                new Step(new Tile(3105, 3364, 2))
        )));

        new OneWayLink(ManorAttic, ManorKitchen, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3105, 3364, 2)),
                new Obstacle(9584, "Climb-down", new Tile(3105, 3363, 2)),
                new Step(new Tile(3108, 3366, 1)),
                new Obstacle(11499, "Climb-down", new Tile(3109, 3364, 1)),
                new Step(new Tile(3109, 3361, 0)),
                new Step(new Tile(3106, 3368, 0)),
                new Obstacle(11470, "Open", new Tile(3106, 3368, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3106, 3370, 0)),
                new Step(new Tile(3115, 3368, 0)),
                new Step(new Tile(3119, 3356, 0)),
                new Obstacle(11470, "Open", new Tile(3120, 3356, 0), Obstacle.Hitbox.DOOR_WEST),
                new Step(new Tile(3122, 3357, 0))
        )));

        new OneWayLink(ManorEntrance, ManorKitchen, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3109, 3357, 0)),
                new Obstacle(11470, "Open", new Tile(3109, 3358, 0), Obstacle.Hitbox.DOOR_SOUTH),
                new Step(new Tile(3109, 3361, 0)),
                new Step(new Tile(3106, 3368, 0)),
                new Obstacle(11470, "Open", new Tile(3106, 3368, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3106, 3370, 0)),
                new Step(new Tile(3115, 3368, 0)),
                new Step(new Tile(3119, 3356, 0)),
                new Obstacle(11470, "Open", new Tile(3120, 3356, 0), Obstacle.Hitbox.DOOR_WEST),
                new Step(new Tile(3122, 3357, 0))
        )));

        new OneWayLink(ManorKitchen, CrossRoads, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3123, 3359, 0)),
                new DraynorManorBackDoor(),
                new Step(new Tile(3124, 3361, 0)),
                new Step(new Tile(3126, 3364, 0)),
                new Step(new Tile(3129, 3361, 0)),
                new Step(new Tile(3129, 3354, 0)),
                new Step(new Tile(3128, 3350, 0)),
                new Step(new Tile(3118, 3349, 0)),
                new Step(new Tile(3110, 3345, 0)),
                new Step(new Tile(3109, 3339, 0)),
                new Step(new Tile(3109, 3332, 0)),
                new Step(new Tile(3113, 3325, 0)),
                new Step(new Tile(3111, 3316, 0)),
                new Step(new Tile(3113, 3309, 0)),
                new Step(new Tile(3112, 3303, 0)),
                new Step(new Tile(3110, 3295, 0))
        )));

        new TwoWayLink(Market, WestFenceOpening, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3081, 3253, 0)),
                new Step(new Tile(3082, 3264, 0)),
                new Step(new Tile(3070, 3276, 0))
        )));

        new TwoWayLink(WestFenceOpening, Falador.SouthCrossRoads);

        new TwoWayLink(WestFenceOpening, PortSarim.MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3071, 3277, 0)),
                new Step(new Tile(3062, 3271, 0)),
                new Step(new Tile(3042, 3260, 0)),
                new Step(new Tile(3042, 3236, 0)),
                new Step(new Tile(3027, 3235, 0)),
                new Step(new Tile(3027, 3217, 0))
        )));
    }
}
