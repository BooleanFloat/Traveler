package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Falador implements Region {
    public static Location EastBank;
    public static Location NorthGate;
    public static Location NorthSquare;
    public static Location SouthCrossRoads;
    public static Location SouthGate;
    public static Location Square;
    public static Location WestBank;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(EastBank);
        locations.add(NorthGate);
        locations.add(NorthSquare);
        locations.add(SouthCrossRoads);
        locations.add(SouthGate);
        locations.add(Square);
        locations.add(WestBank);

        return locations;
    }

    public static void initLocations() {
        EastBank = new Location("Falador, EastBank", new Area(
                new Tile(3015, 3357, 0),
                new Tile(3009, 3354, 0)
        ));

        NorthGate = new Location("Falador, NorthGate", new Area(
                new Tile(2968, 3395, 0),
                new Tile(2963, 3391, 0)
        ));

        NorthSquare = new Location("Falador, NorthSquare", new Area(
                new Tile(2971, 3414, 0),
                new Tile(2964, 3409, 0)
        ));

        SouthCrossRoads = new Location("Falador, SouthCrossRoads", new Area(
                new Tile(3010, 3281, 0),
                new Tile(3005, 3276, 0)
        ));

        SouthGate = new Location("Falador, SouthGate", new Area(
                new Tile(3010, 3324, 0),
                new Tile(3005, 3320, 0)
        ));

        Square = new Location("Falador, Square", new Area(
                new Tile(2969, 3383, 0),
                new Tile(2962, 3376, 0)
        ));

        WestBank = new Location("Falador, WestBank", new Area(
                new Tile(2947, 3372, 0),
                new Tile(2943, 3368, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(EastBank, SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3013, 3359, 0)),
                new Step(new Tile(3006, 3359, 0)),
                new Step(new Tile(3007, 3323, 0))
        )));

        new TwoWayLink(EastBank, Square, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3013, 3361, 0)),
                new Step(new Tile(2979, 3377, 0)),
                new Step(new Tile(2966, 3379, 0))
        )));

        new TwoWayLink(NorthGate, NorthSquare);
        new TwoWayLink(NorthGate, Square);

        new TwoWayLink(SouthCrossRoads, SouthGate);

        new TwoWayLink(SouthCrossRoads, PortSarim.MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3007, 3278, 0)),
                new Step(new Tile(3018, 3261, 0)),
                new Step(new Tile(3019, 3245, 0)),
                new Step(new Tile(3028, 3239, 0)),
                new Step(new Tile(3028, 3216, 0))
        )));

        new TwoWayLink(SouthGate, Square, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3007, 3323, 0)),
                new Step(new Tile(3006, 3362, 0)),
                new Step(new Tile(2966, 3381, 0))
        )));

        new TwoWayLink(Square, WestBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2964, 3380, 0)),
                new Step(new Tile(2953, 3379, 0)),
                new Step(new Tile(2945, 3373, 0))
        )));
    }
}
