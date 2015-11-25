package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Draynor implements Region {
    public static Location Bank;
    public static Location GloryTeleport;
    public static Location Market;
    public static Location NorthHouse;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(GloryTeleport);
        locations.add(Market);
        locations.add(NorthHouse);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("Draynor, Bank", new Area(
                new Tile(3096, 3245, 0),
                new Tile(3091, 3239, 0)
        ));

        GloryTeleport = new Location("Draynor, GloryTeleport", new Area(
                new Tile(3106, 3251, 0),
                new Tile(3102, 3247, 0)
        ));

        Market = new Location("Draynor, Market", new Area(
                new Tile(3084, 3253, 0),
                new Tile(3075, 3245, 0)
        ));

        NorthHouse = new Location("Draynor, NorthHouse", new Area(
                new Tile(3102, 3280, 0),
                new Tile(3098, 3277, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Bank, Market, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3093, 3247, 0))
        )));

        new TwoWayLink(Bank, GloryTeleport, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3093, 3247, 0))
        )));

        new TwoWayLink(GloryTeleport, Market);

        new TwoWayLink(GloryTeleport, Lumbridge.HamEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3104, 3249, 0)),
                new Step(new Tile(3112, 3261, 0)),
                new Step(new Tile(3133, 3261, 0)),
                new Step(new Tile(3159, 3246, 0)),
                new Step(new Tile(3166, 3248, 0))
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

        new TwoWayLink(Market, Falador.SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3081, 3255, 0)),
                new Step(new Tile(3082, 3262, 0)),
                new Step(new Tile(3070, 3276, 0)),
                new Step(new Tile(3009, 3276, 0)),
                new Step(new Tile(3007, 3321, 0))
        )));

        new TwoWayLink(Market, PortSarim.MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3080, 3253, 0)),
                new Step(new Tile(3082, 3263, 0)),
                new Step(new Tile(3071, 3277, 0)),
                new Step(new Tile(3062, 3271, 0)),
                new Step(new Tile(3042, 3260, 0)),
                new Step(new Tile(3042, 3236, 0)),
                new Step(new Tile(3027, 3235, 0)),
                new Step(new Tile(3027, 3217, 0))
        )));
    }
}
