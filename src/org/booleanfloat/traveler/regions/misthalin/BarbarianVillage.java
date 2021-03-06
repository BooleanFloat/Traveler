package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import sun.security.provider.ConfigFile;

import java.util.ArrayList;
import java.util.Arrays;

public class BarbarianVillage implements Region {
    public static Location Bridge;
    public static Location HelmetStore;
    public static Location Mine;
    public static Location SpinningHut;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(Bridge);
        locations.add(HelmetStore);
        locations.add(Mine);
        locations.add(SpinningHut);

        return locations;
    }

    public static void initLocations() {
        Bridge = new Location("BarbarianVillage, Bridge", new Area(
                new Tile(3108, 3421, 0),
                new Tile(3102, 3419, 0)
        ));

        HelmetStore = new Location("BarbarianVillage, HelmetStore", new Area(
                new Tile(3077, 3430, 0),
                new Tile(3073, 3426, 0)
        ));

        Mine = new Location("BarbarianVillage, Mine", new Area(
                new Tile(3085, 3422, 0),
                new Tile(3077, 3415, 0)
        ));

        SpinningHut = new Location("BarbarianVillage, SpinningHut", new Area(
                new Tile(3084, 3432, 0),
                new Tile(3086, 3430, 0),
                new Tile(3086, 3428, 0),
                new Tile(3084, 3426, 0),
                new Tile(3082, 3426, 0),
                new Tile(3080, 3427, 0),
                new Tile(3080, 3430, 0),
                new Tile(3082, 3432, 0)
        ));
    }

    public static void initLinks(final ClientContext ctx) {
        new TwoWayLink(Bridge, Mine);

        new TwoWayLink(Bridge, Draynor.CrossRoads, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3102, 3420, 0)),
                new Step(new Tile(3097, 3415, 0)),
                new Step(new Tile(3108, 3391, 0)),
                new Step(new Tile(3120, 3384, 0)),
                new Step(new Tile(3131, 3384, 0)),
                new Step(new Tile(3137, 3367, 0)),
                new Step(new Tile(3135, 3352, 0)),
                new Step(new Tile(3135, 3327, 0)),
                new Step(new Tile(3113, 3312, 0)),
                new Step(new Tile(3113, 3302, 0)),
                new Step(new Tile(3110, 3299, 0)),
                new Step(new Tile(3109, 3295, 0))
        )));

        new TwoWayLink(Bridge, Draynor.WestFenceOpening, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3099, 3419, 0)),
                new Step(new Tile(3087, 3396, 0)),
                new Step(new Tile(3073, 3385, 0)),
                new Step(new Tile(3072, 3276, 0))
        )));

        new TwoWayLink(Bridge, Edgeville.SouthFenceOpening, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3104, 3420, 0)),
                new Step(new Tile(3101, 3427, 0)),
                new Step(new Tile(3098, 3436, 0)),
                new Step(new Tile(3091, 3445, 0)),
                new Step(new Tile(3087, 3463, 0))
        )));

        new TwoWayLink(Bridge, Varrock.GrandExchange, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3106, 3420, 0)),
                new Step(new Tile(3122, 3423, 0)),
                new Step(new Tile(3142, 3431, 0)),
                new Step(new Tile(3150, 3444, 0)),
                new Step(new Tile(3161, 3453, 0)),
                new Step(new Tile(3164, 3461, 0)),
                new Step(new Tile(3164, 3488, 0))
        )));

        new TwoWayLink(Bridge, Varrock.WestGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3116, 3420, 0)),
                new Step(new Tile(3127, 3414, 0)),
                new Step(new Tile(3155, 3416, 0)),
                new Step(new Tile(3170, 3429, 0)),
                new Step(new Tile(3176, 3428, 0))
        )));

        new TwoWayLink(HelmetStore, Mine, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3076, 3427, 0)),
                new Obstacle(11616, "Open", new Tile(3076, 3426, 0), new int[]{0, 128, -192, 0, 96, 144}),
                new Step(new Tile(3076, 3425, 0)),
                new Step(new Tile(3080, 3419, 0))
        )));

        new TwoWayLink(Mine, SpinningHut, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3081, 3420, 0)),
                new Step(new Tile(3083, 3424, 0)),
                new Obstacle(11616, "Open", new Tile(3082, 3426, 0), new int[]{0, 128, -192, 0, 96, 144}),
                new Step(new Tile(3083, 3428, 0))
        )));

        new TwoWayLink(Mine, Edgeville.Monastery, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3079, 3420, 0)),
                new Step(new Tile(3069, 3428, 0)),
                new Step(new Tile(3069, 3442, 0)),
                new Step(new Tile(3051, 3467, 0)),
                new Step(new Tile(3052, 3489, 0))
        )));

        new TwoWayLink(Mine, Edgeville.SouthFenceOpening, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3079, 3422, 0)),
                new Step(new Tile(3079, 3433, 0)),
                new Step(new Tile(3084, 3435, 0)),
                new Step(new Tile(3084, 3438, 0)),
                new Step(new Tile(3087, 3440, 0)),
                new Step(new Tile(3087, 3462, 0))
        )));

        new TwoWayLink(Mine, Falador.NorthFencedStones, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3039, 3399, 0)),
                new Step(new Tile(3034, 3401, 0)),
                new Step(new Tile(3034, 3405, 0)),
                new Step(new Tile(3044, 3405, 0)),
                new Step(new Tile(3053, 3402, 0)),
                new Step(new Tile(3062, 3404, 0)),
                new Step(new Tile(3069, 3410, 0)),
                new Step(new Tile(3071, 3418, 0)),
                new Step(new Tile(3080, 3419, 0))
        )));

        new TwoWayLink(Mine, Falador.NorthSquare, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3077, 3418, 0)),
                new Step(new Tile(3071, 3418, 0)),
                new Step(new Tile(3034, 3425, 0)),
                new Step(new Tile(3016, 3429, 0)),
                new Step(new Tile(3000, 3431, 0)),
                new Step(new Tile(2988, 3427, 0)),
                new Step(new Tile(2987, 3419, 0)),
                new Step(new Tile(2967, 3411, 0))
        )));
    }
}
