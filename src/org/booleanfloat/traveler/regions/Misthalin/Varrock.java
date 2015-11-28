package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Varrock implements Region {
    public static Location ClothesStore;
    public static Location EastBank;
    public static Location EastGate;
    public static Location Fountain;
    public static Location GrandExchange;
    public static Location NorthGate;
    public static Location SouthGate;
    public static Location SouthMine;
    public static Location SouthMineDigSpot;
    public static Location WestBank;
    public static Location WestBankBasement;
    public static Location WestBankBasementClueSpot;
    public static Location WestGate;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(ClothesStore);
        locations.add(EastBank);
        locations.add(EastGate);
        locations.add(Fountain);
        locations.add(GrandExchange);
        locations.add(NorthGate);
        locations.add(SouthGate);
        locations.add(SouthMine);
        locations.add(SouthMineDigSpot);
        locations.add(WestBank);
        locations.add(WestBankBasement);
        locations.add(WestBankBasementClueSpot);
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

        NorthGate = new Location("Varrock, NorthGate", new Area(
                new Tile(3248, 3503, 0),
                new Tile(3244, 3498, 0)
        ));

        SouthGate = new Location("Varrock, SouthGate", new Area(
                new Tile(3213, 3382, 0),
                new Tile(3210, 3380, 0)
        ));

        SouthMine = new Location("Varrock, SouthMine", new Area(
                new Tile(3292, 3373, 0),
                new Tile(3291, 3370, 0),
                new Tile(3291, 3364, 0),
                new Tile(3293, 3359, 0),
                new Tile(3291, 3357, 0),
                new Tile(3288, 3359, 0),
                new Tile(3282, 3359, 0),
                new Tile(3281, 3358, 0),
                new Tile(3278, 3361, 0),
                new Tile(3281, 3364, 0),
                new Tile(3281, 3371, 0)
        ));

        SouthMineDigSpot = new Location("Varrock, SouthMineDigSpot", new Area(
                new Tile(3290, 3375, 0),
                new Tile(3288, 3373, 0)
        ));

        WestBank = new Location("Varrock, WestBank", new Area(
                new Tile(3185, 3439, 0),
                new Tile(3181, 3434, 0)
        ));

        WestBankBasement = new Location("Varrock, WestBankBasement", new Area(
                new Tile(3196, 9834, 0),
                new Tile(3187, 9825, 0)
        ));

        WestBankBasementClueSpot = new Location("Varrock, WestBankBasementClueSpot", new Area(
                new Tile(3189, 9826, 0),
                new Tile(3186, 9824, 0)
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

        new TwoWayLink(EastBank, NorthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3254, 3421, 0)),
                new Step(new Tile(3254, 3428, 0)),
                new Step(new Tile(3246, 3429, 0)),
                new Step(new Tile(3245, 3499, 0))
        )));

        new TwoWayLink(EastGate, SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3272, 3428, 0)),
                new Step(new Tile(3276, 3428, 0)),
                new Step(new Tile(3290, 3409, 0)),
                new Step(new Tile(3294, 3378, 0)),
                new Step(new Tile(3286, 3370, 0))
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

        new TwoWayLink(NorthGate, VarrockCastle.Courtyard, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3245, 3500, 0)),
                new Step(new Tile(3246, 3465, 0)),
                new Step(new Tile(3232, 3464, 0)),
                new Step(new Tile(3232, 3456, 0)),
                new Step(new Tile(3213, 3448, 0))
        )));

        new OneWayLink(WestBank, WestBankBasement, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3184, 3434, 0)),
                new Obstacle(11775, "Open", new Tile(3186, 3434, 0), new int[]{-16, 32, -196, 0, 16, 128}),
                new Step(new Tile(3186, 3434, 0)),
                new Obstacle(11800, "Climb-down", new Tile(3188, 3434, 0), new int[]{-128, 128, -64, 0, -64, 64}),
                new Step(new Tile(3190, 9834, 0)),
                new Step(new Tile(3191, 9829, 0))
        )));

        new OneWayLink(WestBankBasement, WestBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3191, 9829, 0)),
                new Step(new Tile(3190, 9834, 0)),
                new Obstacle(11805, "Climb-up", new Tile(3188, 9834, 0), new int[]{-128, 128, -64, 0, -64, 64}),
                new Step(new Tile(3186, 3434, 0)),
                new Obstacle(11775, "Open", new Tile(3186, 3434, 0), new int[]{-16, 32, -196, 0, 16, 128}),
                new Step(new Tile(3184, 3434, 0))
        )));

        new TwoWayLink(WestBankBasement, WestBankBasementClueSpot);

        new TwoWayLink(WestBank, WestGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3175, 3428, 0)),
                new Step(new Tile(3183, 3431, 0))
        )));

        new TwoWayLink(SouthGate, SouthMine, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3211, 3381, 0)),
                new Step(new Tile(3213, 3378, 0)),
                new Step(new Tile(3237, 3379, 0)),
                new Step(new Tile(3242, 3373, 0)),
                new Step(new Tile(3285, 3371, 0))
        )));

        new TwoWayLink(SouthMine, SouthMineDigSpot);
    }
}