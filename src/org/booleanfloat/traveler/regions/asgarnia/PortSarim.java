package org.booleanfloat.traveler.regions.asgarnia;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.karamja.MusaPoint;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.npcs.PortSarimKaramjaSailor;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class PortSarim implements Region {
    public static Location Jail;
    public static Location MudskipperPoint;
    public static Location MusaPointBoat;
    public static Location ShantyPassCell;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Jail);
        locations.add(MudskipperPoint);
        locations.add(MusaPointBoat);
        locations.add(ShantyPassCell);

        return locations;
    }

    public static void initLocations() {
        Jail = new Location("PortSarim, Jail", new Area(
                new Tile(3017, 3196, 0),
                new Tile(3017, 3190, 0),
                new Tile(3021, 3190, 0),
                new Tile(3021, 3181, 0),
                new Tile(3010, 3181, 0),
                new Tile(3010, 3196, 0)
        ));

        MudskipperPoint = new Location("PortSarim, MudskipperPoint", new Area(
                new Tile(3000, 3129, 0),
                new Tile(3006, 3127, 0),
                new Tile(3008, 3113, 0),
                new Tile(3004, 3106, 0),
                new Tile(2990, 3103, 0),
                new Tile(2980, 3105, 0),
                new Tile(2980, 3110, 0),
                new Tile(2981, 3121, 0),
                new Tile(2991, 3129, 0)
        ));

        MusaPointBoat = new Location("PortSarim, MusaPointBoat", new Area(
                new Tile(3029, 3222, 0),
                new Tile(3027, 3212, 0)
        ));

        ShantyPassCell = new Location("PortSarim, ShantyPassCell", new Area(
                new Tile(3016, 3182, 0),
                new Tile(3013, 3179, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Jail, MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3011, 3191, 0)),
                new Obstacle(7122, "Open", new Tile(3011, 3197, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(3012, 3198, 0)),
                new Step(new Tile(3017, 3201, 0)),
                new Step(new Tile(3028, 3210, 0)),
                new Step(new Tile(3028, 3214, 0))
        )));

        new TwoWayLink(MudskipperPoint, MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2999, 3124, 0)),
                new Step(new Tile(3000, 3135, 0)),
                new Step(new Tile(2997, 3142, 0)),
                new Step(new Tile(2997, 3152, 0)),
                new Step(new Tile(3003, 3167, 0)),
                new Step(new Tile(3008, 3183, 0)),
                new Step(new Tile(3008, 3199, 0)),
                new Step(new Tile(3018, 3200, 0)),
                new Step(new Tile(3018, 3203, 0)),
                new Step(new Tile(3028, 3207, 0)),
                new Step(new Tile(3028, 3214, 0))
        )));

        new TwoWayLink(MudskipperPoint, Rimmington.POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2999, 3125, 0)),
                new Step(new Tile(3002, 3140, 0)),
                new Step(new Tile(3002, 3156, 0)),
                new Step(new Tile(2992, 3171, 0)),
                new Step(new Tile(2989, 3183, 0)),
                new Step(new Tile(2987, 3195, 0)),
                new Step(new Tile(2974, 3199, 0)),
                new Step(new Tile(2963, 3199, 0)),
                new Step(new Tile(2962, 3206, 0)),
                new Step(new Tile(2959, 3212, 0)),
                new Step(new Tile(2956, 3223, 0))
        )));

        new OneWayLink(MusaPointBoat, MusaPoint.PortSarimBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3027, 3217, 0)),
                new PortSarimKaramjaSailor(3644, "Pay-fare", MusaPointBoat.area),
                new PortSarimKaramjaSailor(3645, "Pay-fare", MusaPointBoat.area),
                new PortSarimKaramjaSailor(3646, "Pay-fare", MusaPointBoat.area),
                new Obstacle(2082, "Cross", new Tile(2956, 3144, 1))
        )), new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // requires 30 coins
                return ctx.inventory.select().id(Config.COINS_ID).poll().stackSize() >= 30;
            }
        });

        new TwoWayLink(MusaPointBoat, Rimmington.Mine, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3027, 3216, 0)),
                new Step(new Tile(3007, 3217, 0)),
                new Step(new Tile(2990, 3231, 0)),
                new Step(new Tile(2983, 3233, 0))
        )));

        new OneWayLink(ShantyPassCell, Jail, new ArrayList<>(Arrays.asList(
                new Obstacle(9565, "Pick-lock", new Tile(3014, 3182, 0), new int[]{0, 128, -192, 0, -16, 32})
        )));
    }
}
