package org.booleanfloat.traveler.regions.asgarnia;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.kandarin.Catherby;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Taverly implements Region {
    public static Location POHPortal;
    public static Location MembersGate;
    public static Location WhiteWolfMountainEntrance;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(POHPortal);
        locations.add(MembersGate);
        locations.add(WhiteWolfMountainEntrance);

        return locations;
    }

    public static void initLocations() {
        POHPortal = new Location("Taverly, POHPortal", new Area(
                new Tile(2897, 3466, 0),
                new Tile(2892, 3461, 0)
        ));

        MembersGate = new Location("Taverly, MembersGate", new Area(
                new Tile(2933, 3453, 0),
                new Tile(2929, 3447, 0)
        ));

        WhiteWolfMountainEntrance = new Location("Taverly, WhiteWolfMountainEntrance", new Area(
                new Tile(2876, 3430, 0),
                new Tile(2871, 3426, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
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

        new TwoWayLink(MembersGate, WhiteWolfMountainEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2930, 3449, 0)),
                new Step(new Tile(2919, 3432, 0)),
                new Step(new Tile(2910, 3429, 0)),
                new Step(new Tile(2900, 3421, 0)),
                new Step(new Tile(2892, 3421, 0)),
                new Step(new Tile(2881, 3428, 0)),
                new Step(new Tile(2876, 3428, 0))
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
