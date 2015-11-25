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

public class Varrock implements Region {
    public static Location ClothesStore;
    public static Location EastBank;
    public static Location EastGate;
    public static Location Fountain;
    public static Location GrandExchange;
    public static Location SouthGate;
    public static Location WestBank;
    public static Location WestGate;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(ClothesStore);
        locations.add(EastBank);
        locations.add(EastGate);
        locations.add(Fountain);
        locations.add(GrandExchange);
        locations.add(SouthGate);
        locations.add(WestBank);
        locations.add(WestGate);

        return locations;
    }

    public static void initLocations() {
        ClothesStore = new Location("Varrock, ClothesStore", new Area(
                new Tile(3207, 3418, 0),
                new Tile(3204, 3414, 0)
        ));

        EastBank = new Location("Varrock, EastBank", new Area(
                new Tile(3254, 3422, 0),
                new Tile(3250, 3420, 0)
        ));

        EastGate = new Location("Varrock, EastGate", new Area(
                new Tile(3275, 3431, 0),
                new Tile(3271, 3426, 0)
        ));

        Fountain = new Location("Varrock, Fountain", new Area(
                new Tile(3216, 3432, 0),
                new Tile(3209, 3425, 0)
        ));

        GrandExchange = new Location("Varrock, GrandExchange", new Area(
                new Tile(3168, 3493, 0),
                new Tile(3161, 3486, 0)
        ));

        SouthGate = new Location("Varrock, SouthGate", new Area(
                new Tile(3213, 3382, 0),
                new Tile(3210, 3380, 0)
        ));

        WestBank = new Location("Varrock, WestBank", new Area(
                new Tile(3185, 3439, 0),
                new Tile(3181, 3434, 0)
        ));

        WestGate = new Location("Varrock, WestGate", new Area(
                new Tile(3176, 3430, 0),
                new Tile(3172, 3425, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(ClothesStore, Fountain, new ArrayList<>(Arrays.asList(
                new Obstacle(11775, "Open", new Tile(3209, 3415, 0)),
                new Step(new Tile(3210, 3415, 0))
        )));

        new TwoWayLink(ClothesStore, SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3210, 3415, 0))
        )));

        new TwoWayLink(EastBank, EastGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3255, 3427, 0))
        )));

        new TwoWayLink(Fountain, EastGate);

        new TwoWayLink(Fountain, EastBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3253, 3428, 0))
        )));

        new TwoWayLink(Fountain, SouthGate);

        new TwoWayLink(Fountain, WestBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3183, 3429, 0))
        )));

        new TwoWayLink(GrandExchange, WestBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3166, 3461, 0)),
                new Step(new Tile(3183, 3448, 0))
        )));

         new TwoWayLink(GrandExchange, WestGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3164, 3484, 0)),
                new Step(new Tile(3165, 3465, 0)),
                new Step(new Tile(3176, 3445, 0)),
                new Step(new Tile(3175, 3430, 0))
        )));

        new TwoWayLink(WestBank, WestGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3175, 3428, 0)),
                new Step(new Tile(3183, 3431, 0))
        )));
    }

    public static class Castle {

    }
}