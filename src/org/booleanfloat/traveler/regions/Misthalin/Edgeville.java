package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.ImportantStep;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Edgeville implements Region {
    public static Location Bank;
    public static Location CoffinHouse;
    public static Location EastBridge;
    public static Location EvilDavesHouse;
    public static Location Monastery;
    public static Location MonasteryClueBookcase;
    public static Location SouthFenceOpening;
    public static Location Yews;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(Bank);
        locations.add(CoffinHouse);
        locations.add(EastBridge);
        locations.add(EvilDavesHouse);
        locations.add(Monastery);
        locations.add(MonasteryClueBookcase);
        locations.add(SouthFenceOpening);
        locations.add(Yews);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("Edgeville, Bank", new Area(
                new Tile(3097, 3498, 0),
                new Tile(3092, 3489, 0)
        ));

        CoffinHouse = new Location("Edgeville, CoffinHouse", new Area(
                new Tile(3098, 3482, 0),
                new Tile(3090, 3473, 0)
        ));

        EastBridge = new Location("Edgeville, EastBridge", new Area(
                new Tile(3134, 3518, 0),
                new Tile(3129, 3515, 0)
        ));

        EvilDavesHouse = new Location("Edgeville, EvilDavesHouse", new Area(
                new Tile(3082, 3496, 0),
                new Tile(3077, 3488, 0)
        ));

        Monastery = new Location("Edgeville, Monastery", new Area(
                new Tile(3057, 3495, 0),
                new Tile(3047, 3486, 0)
        ));

        MonasteryClueBookcase = new Location("Edgeville, MonasteryClueBookcase", new Area(
                new Tile(3056, 3484, 0),
                new Tile(3054, 3482, 0)
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

    public static void initLinks(final ClientContext ctx) {
        new TwoWayLink(Bank, CoffinHouse, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3091, 3491, 0)),
                new Step(new Tile(3089, 3489, 0)),
                new Step(new Tile(3093, 3480, 0))
        )));

        new TwoWayLink(Bank, EastBridge, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3096, 3496, 0)),
                new Step(new Tile(3101, 3496, 0)),
                new Step(new Tile(3104, 3502, 0)),
                new Step(new Tile(3129, 3516, 0))
        )));

        new TwoWayLink(Bank, Monastery, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3094, 3495, 0)),
                new Step(new Tile(3092, 3501, 0)),
                new Step(new Tile(3083, 3519, 0)),
                new Step(new Tile(3061, 3520, 0)),
                new Step(new Tile(3052, 3509, 0)),
                new Step(new Tile(3052, 3491, 0))
        )));

        new TwoWayLink(Bank, SouthFenceOpening, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3092, 3490, 0)),
                new Step(new Tile(3080, 3483, 0)),
                new Step(new Tile(3080, 3466, 0)),
                new Step(new Tile(3087, 3463, 0))
        )));

        new TwoWayLink(Bank, EvilDavesHouse, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3093, 3495, 0)),
                new Step(new Tile(3093, 3501, 0)),
                new Step(new Tile(3079, 3501, 0)),
                new Obstacle(7158, "Open", new Tile(3080, 3501, 0), new int[]{0, 128, -128, 0, 0, 32}),
                new Obstacle(7160, "Open", new Tile(3079, 3501, 0), new int[]{0, 128, -128, 0, 0, 32}),
                new Step(new Tile(3080, 3499, 0)),
                new Obstacle(7122, "Open", new Tile(3079, 3497, 0), new int[]{0, 128, -192, 0, 0, 32}),
                new Step(new Tile(3080, 3495, 0))
        )));

        new TwoWayLink(CoffinHouse, EastBridge, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3094, 3481, 0)),
                new Step(new Tile(3099, 3485, 0)),
                new Step(new Tile(3117, 3498, 0)),
                new Step(new Tile(3129, 3517, 0))
        )));

        new TwoWayLink(CoffinHouse, SouthFenceOpening, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3094, 3482, 0)),
                new Step(new Tile(3100, 3483, 0)),
                new Step(new Tile(3099, 3465, 0)),
                new Step(new Tile(3088, 3463, 0))
        )));

        new TwoWayLink(CoffinHouse, Yews, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3094, 3475, 0)),
                new Step(new Tile(3094, 3469, 0)),
                new Step(new Tile(3087, 3469, 0))
        )));

        new TwoWayLink(EastBridge, Varrock.NorthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3133, 3517, 0)),
                new Step(new Tile(3142, 3519, 0)),
                new Step(new Tile(3206, 3517, 0)),
                new Step(new Tile(3246, 3502, 0))
        )));

        new TwoWayLink(Monastery, MonasteryClueBookcase, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3052, 3489, 0)),
                new Step(new Tile(3058, 3490, 0)),
                new Step(new Tile(3059, 3483, 0)),
                new Step(new Tile(3055, 3483, 0))
        )));
    }
}
