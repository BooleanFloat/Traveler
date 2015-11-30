package org.booleanfloat.traveler.regions.asgarnia;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.kandarin.Catherby;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Taverly implements Region {
    public static Location DruidsCircle;
    public static Location HerbloreStore;
    public static Location MembersGate;
    public static Location POHPortal;
    public static Location SouthHouse;
    public static Location TwoHandedSwordStore;
    public static Location WhiteWolfMountainEntrance;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(DruidsCircle);
        locations.add(HerbloreStore);
        locations.add(MembersGate);
        locations.add(POHPortal);
        locations.add(SouthHouse);
        locations.add(TwoHandedSwordStore);
        locations.add(WhiteWolfMountainEntrance);

        return locations;
    }

    public static void initLocations() {
        DruidsCircle = new Location("Taverly, DruidsCircle", new Area(
                new Tile(2926, 3487, 0),
                new Tile(2929, 3486, 0),
                new Tile(2931, 3481, 0),
                new Tile(2929, 3478, 0),
                new Tile(2926, 3477, 0),
                new Tile(2922, 3478, 0),
                new Tile(2921, 3482, 0),
                new Tile(2922, 3486, 0)
        ));

        HerbloreStore = new Location("Taverly, HerbloreStore", new Area(
                new Tile(2900, 3431, 0),
                new Tile(2902, 3429, 0),
                new Tile(2902, 3426, 0),
                new Tile(2899, 3423, 0),
                new Tile(2897, 3423, 0),
                new Tile(2895, 3425, 0),
                new Tile(2895, 3428, 0),
                new Tile(2897, 3431, 0)
        ));

        MembersGate = new Location("Taverly, MembersGate", new Area(
                new Tile(2933, 3453, 0),
                new Tile(2929, 3447, 0)
        ));

        POHPortal = new Location("Taverly, POHPortal", new Area(
                new Tile(2897, 3466, 0),
                new Tile(2892, 3461, 0)
        ));

        SouthHouse = new Location("Taverly, SouthHouse", new Area(
                new Tile(2894, 3420, 0),
                new Tile(2895, 3419, 0),
                new Tile(2895, 3417, 0),
                new Tile(2894, 3416, 0),
                new Tile(2892, 3416, 0),
                new Tile(2891, 3417, 0),
                new Tile(2891, 3419, 0),
                new Tile(2892, 3420, 0)
        ));

        TwoHandedSwordStore = new Location("Taverly, TwoHandedSwordStore", new Area(
                new Tile(2885, 3452, 0),
                new Tile(2888, 3450, 0),
                new Tile(2888, 3448, 0),
                new Tile(2886, 3446, 0),
                new Tile(2884, 3446, 0),
                new Tile(2882, 3448, 0),
                new Tile(2882, 3450, 0),
                new Tile(2884, 3452, 0)
        ));

        WhiteWolfMountainEntrance = new Location("Taverly, WhiteWolfMountainEntrance", new Area(
                new Tile(2876, 3430, 0),
                new Tile(2871, 3426, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(DruidsCircle, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2923, 3484, 0)),
                new Step(new Tile(2899, 3477, 0)),
                new Step(new Tile(2897, 3464, 0))
        )));

        new TwoWayLink(DruidsCircle, MembersGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2926, 3483, 0)),
                new Step(new Tile(2938, 3469, 0)),
                new Step(new Tile(2938, 3458, 0)),
                new Step(new Tile(2931, 3450, 0))
        )));

        new TwoWayLink(HerbloreStore, WhiteWolfMountainEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2898, 3427, 0)),
                new Obstacle(7122, "Open", new Tile(2894, 3428, 0), new int[]{112, 144, -192, 0, 0, 128}),
                new Step(new Tile(2894, 3427, 0)),
                new Step(new Tile(2875, 3428, 0))
        )));

        new TwoWayLink(HerbloreStore, MembersGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2899, 3427, 0)),
                new Obstacle(7122, "Open", new Tile(2902, 3428, 0), new int[]{0, 32, -192, 0, 0, 128}),
                new Step(new Tile(2907, 3427, 0)),
                new Step(new Tile(2920, 3432, 0)),
                new Step(new Tile(2931, 3450, 0))
        )));

        new TwoWayLink(POHPortal, WhiteWolfMountainEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2896, 3464, 0)),
                new Step(new Tile(2896, 3454, 0)),
                new Step(new Tile(2888, 3427, 0)),
                new Step(new Tile(2875, 3427, 0))
        )));

        new TwoWayLink(POHPortal, MembersGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2895, 3463, 0)),
                new Step(new Tile(2897, 3463, 0)),
                new Step(new Tile(2897, 3455, 0)),
                new Step(new Tile(2919, 3455, 0)),
                new Step(new Tile(2931, 3449, 0))
        )));

        new TwoWayLink(POHPortal, TwoHandedSwordStore, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2897, 3463, 0)),
                new Step(new Tile(2897, 3455, 0)),
                new Step(new Tile(2890, 3454, 0)),
                new Step(new Tile(2887, 3452, 0)),
                new Obstacle(7122, "Open", new Tile(2885, 3453, 0), new int[]{0, 128, -192, 0, 0, 32}),
                new Step(new Tile(2886, 3450, 0))
        )));

        new TwoWayLink(MembersGate, SouthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2931, 3450, 0)),
                new Step(new Tile(2920, 3432, 0)),
                new Step(new Tile(2909, 3429, 0)),
                new Step(new Tile(2900, 3421, 0)),
                new Step(new Tile(2893, 3421, 0)),
                new Obstacle(7122, "Open", new Tile(2893, 3421, 0), new int[]{0, 128, -192, 0, -32, 32}),
                new Step(new Tile(2893, 3419, 0))
        )));

        new TwoWayLink(MembersGate, WhiteWolfMountainEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2930, 3449, 0)),
                new Step(new Tile(2919, 3432, 0)),
                new Step(new Tile(2910, 3429, 0)),
                new Step(new Tile(2900, 3421, 0)),
                new Step(new Tile(2892, 3421, 0)),
                new Step(new Tile(2881, 3428, 0)),
                new Step(new Tile(2876, 3428, 0))
        )));

        new TwoWayLink(SouthHouse, WhiteWolfMountainEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2893, 3419, 0)),
                new Obstacle(7122, "Open", new Tile(2893, 3421, 0), new int[]{0, 128, -192, 0, -32, 32}),
                new Step(new Tile(2893, 3421, 0)),
                new Step(new Tile(2881, 3428, 0)),
                new Step(new Tile(2874, 3428, 0))
        )));

        new TwoWayLink(WhiteWolfMountainEntrance, Catherby.FishingSpot, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2874, 3429, 0)),
                new Step(new Tile(2864, 3444, 0)),
                new Step(new Tile(2865, 3458, 0)),
                new Step(new Tile(2855, 3473, 0)),
                new Step(new Tile(2856, 3484, 0)),
                new Step(new Tile(2862, 3493, 0)),
                new Step(new Tile(2862, 3499, 0)),
                new Step(new Tile(2857, 3509, 0)),
                new Step(new Tile(2847, 3508, 0)),
                new Step(new Tile(2840, 3503, 0)),
                new Step(new Tile(2840, 3497, 0)),
                new Step(new Tile(2849, 3496, 0)),
                new Step(new Tile(2851, 3492, 0)),
                new Step(new Tile(2851, 3487, 0)),
                new Step(new Tile(2848, 3475, 0)),
                new Step(new Tile(2843, 3467, 0)),
                new Step(new Tile(2844, 3462, 0)),
                new Step(new Tile(2848, 3454, 0)),
                new Step(new Tile(2848, 3449, 0)),
                new Step(new Tile(2855, 3444, 0)),
                new Step(new Tile(2854, 3433, 0))
        )));
    }
}
