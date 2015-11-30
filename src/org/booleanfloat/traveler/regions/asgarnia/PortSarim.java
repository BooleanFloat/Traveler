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
    public static Location MusaPointBoat;
    public static Location ShantyPassCell;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Jail);
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
