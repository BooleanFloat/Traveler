package org.booleanfloat.traveler.regions.karamja;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.regions.asgarnia.PortSarim;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class MusaPoint implements Region {
    public static Location PortSarimBoat;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(PortSarimBoat);

        return locations;
    }

    public static void initLocations() {
        PortSarimBoat = new Location("MusaPoint, PortSarimBoat", new Area(
                new Tile(2960, 3153, 0),
                new Tile(2949, 3141, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new OneWayLink(PortSarimBoat, PortSarim.MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2953, 3146, 0)),
//                new KaramjaCustomsOfficer(3648, "Pay-fare", PortSarimBoat.area),
                new Obstacle(2084, "Cross", new Tile(3031, 3217, 1))
        )), new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // requires 30 coins
                return ctx.inventory.select().id(Config.COINS_ID).poll().stackSize() >= 30;
            }
        });
    }
}
