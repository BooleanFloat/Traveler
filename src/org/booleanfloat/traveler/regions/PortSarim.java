package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.npcs.PortSarimKaramjaSailor;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class PortSarim implements Region {
    public static Location MusaPointBoat;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(MusaPointBoat);

        return locations;
    }

    public static void initLocations() {
        MusaPointBoat = new Location("PortSarim, MusaPointBoat", new Area(
                new Tile(3029, 3222, 0),
                new Tile(3027, 3212, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
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
    }
}
