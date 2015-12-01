package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.asgarnia.PortSarim;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Draynor implements Region {
    public static Location Bank;
    public static Location CrossRoads;
    public static Location GloryTeleport;
    public static Location Market;
    public static Location NedsHouse;
    public static Location NorthHouse;
    public static Location WestFenceOpening;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(CrossRoads);
        locations.add(GloryTeleport);
        locations.add(Market);
        locations.add(NedsHouse);
        locations.add(NorthHouse);
        locations.add(WestFenceOpening);

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

        Market = new Location("Draynor, Market", new Area(
                new Tile(3084, 3253, 0),
                new Tile(3075, 3245, 0)
        ));

        NedsHouse = new Location("Draynor, NedsHouse", new Area(
                new Tile(3101, 3260, 0),
                new Tile(3096, 3255, 0)
        ));

        NorthHouse = new Location("Draynor, NorthHouse", new Area(
                new Tile(3102, 3280, 0),
                new Tile(3098, 3277, 0)
        ));

        WestFenceOpening = new Location("Draynor, WestFenceOpening", new Area(
                new Tile(3071, 3278, 0),
                new Tile(3069, 3275, 0)
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

        new TwoWayLink(CrossRoads, NorthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3110, 3293, 0)),
                new Step(new Tile(3109, 3282, 0)),
                new Step(new Tile(3103, 3271, 0)),
                new Step(new Tile(3100, 3274, 0)),
                new Obstacle(7122, "Open", new Tile(3100, 3276, 0))
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

        new TwoWayLink(CrossRoads, Lumbridge.NorthBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3111, 3295, 0)),
                new Step(new Tile(3138, 3295, 0)),
                new Step(new Tile(3155, 3292, 0)),
                new Step(new Tile(3161, 3287, 0)),
                new Step(new Tile(3194, 3281, 0)),
                new Step(new Tile(3215, 3276, 0)),
                new Step(new Tile(3219, 3261, 0)),
                new Step(new Tile(3230, 3261, 0))
        )));

        new TwoWayLink(GloryTeleport, Market);

        new TwoWayLink(GloryTeleport, NedsHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3104, 3250, 0)),
                new Step(new Tile(3104, 3258, 0)),
                new Obstacle(7122, "Open", new Tile(3101, 3258, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(3100, 3258, 0))
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
                new Obstacle(7122, "Open", new Tile(3100, 3276, 0))
        )));

        new TwoWayLink(GloryTeleport, LumbridgeCastle.BackEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3104, 3248, 0)),
                new Step(new Tile(3105, 3236, 0)),
                new Step(new Tile(3116, 3225, 0)),
                new Step(new Tile(3198, 3218, 0))
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
