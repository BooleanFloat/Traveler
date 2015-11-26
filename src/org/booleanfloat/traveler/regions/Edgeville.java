package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Edgeville implements Region {
    public static Location Bank;
    public static Location EastBridge;
    public static Location CoffinHouse;
    public static Location SouthFenceOpening;
    public static Location Yews;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(EastBridge);
        locations.add(CoffinHouse);
        locations.add(SouthFenceOpening);
        locations.add(Yews);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("Edgeville, Bank", new Area(
                new Tile(3097, 3498, 0),
                new Tile(3092, 3489, 0)
        ));

        EastBridge = new Location("EdgeVille, EastBridge", new Area(
                new Tile(3134, 3518, 0),
                new Tile(3129, 3515, 0)
        ));

        CoffinHouse = new Location("Edgeville, CoffinHouse", new Area(
                new Tile(3097, 3482, 0),
                new Tile(3091, 3474, 0)
        ));

        SouthFenceOpening = new Location("Edgeville, SouthFenceOpening", new Area(
                new Tile(3089, 3464, 0),
                new Tile(3086, 3461, 0)
        ));

        Yews = new Location("Edgeville, Yews", new Area(
                new Tile(3089, 3481, 0),
                new Tile(3085, 3467, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Bank, CoffinHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3091, 3491, 0)),
                new Step(new Tile(3089, 3489, 0)),
                new Step(new Tile(3093, 3480, 0))
        )));

        new TwoWayLink(Bank, EastBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3096, 3496, 0)),
                new Step(new Tile(3101, 3496, 0)),
                new Step(new Tile(3104, 3502, 0)),
                new Step(new Tile(3129, 3516, 0))
        )));

        new TwoWayLink(Bank, SouthFenceOpening, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3092, 3490, 0)),
                new Step(new Tile(3080, 3483, 0)),
                new Step(new Tile(3080, 3466, 0)),
                new Step(new Tile(3087, 3463, 0))
        )));

        new TwoWayLink(CoffinHouse, EastBridge, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3094, 3481, 0)),
                new Step(new Tile(3099, 3485, 0)),
                new Step(new Tile(3117, 3498, 0)),
                new Step(new Tile(3129, 3517, 0))
        )));

        new TwoWayLink(CoffinHouse, SouthFenceOpening, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3094, 3482, 0)),
                new Step(new Tile(3100, 3483, 0)),
                new Step(new Tile(3099, 3465, 0)),
                new Step(new Tile(3088, 3463, 0))
        )));

        new TwoWayLink(CoffinHouse, Yews, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3094, 3475, 0)),
                new Step(new Tile(3094, 3469, 0)),
                new Step(new Tile(3087, 3469, 0))
        )));

        new TwoWayLink(EastBridge, Varrock.NorthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3133, 3517, 0)),
                new Step(new Tile(3142, 3519, 0)),
                new Step(new Tile(3206, 3517, 0)),
                new Step(new Tile(3246, 3502, 0))
        )));
    }
}
