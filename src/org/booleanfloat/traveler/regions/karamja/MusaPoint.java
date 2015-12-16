package org.booleanfloat.traveler.regions.karamja;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.asgarnia.PortSarim;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.npcs.KaramjaCustomsOfficer;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class MusaPoint implements Region {
    public static Location PortSarimBoat;
    public static Location VolcanoEntrance;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(PortSarimBoat);
        locations.add(VolcanoEntrance);

        return locations;
    }

    public static void initLocations() {
        PortSarimBoat = new Location("MusaPoint, PortSarimBoat", new Area(
                new Tile(2960, 3153, 0),
                new Tile(2949, 3141, 0)
        ));

        VolcanoEntrance = new Location("MusaPoint, VolcanoEntrance", new Area(
                new Tile(2860, 3167, 0),
                new Tile(2855, 3164, 0)
        ));
    }

    public static void initLinks(final ClientContext ctx) {
        new TwoWayLink(PortSarimBoat, VolcanoEntrance, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2952, 3145, 0)),
                new Step(new Tile(2937, 3145, 0)),
                new Step(new Tile(2929, 3151, 0)),
                new Step(new Tile(2909, 3151, 0)),
                new Step(new Tile(2900, 3157, 0)),
                new Step(new Tile(2890, 3153, 0)),
                new Step(new Tile(2878, 3155, 0)),
                new Step(new Tile(2859, 3157, 0)),
                new Step(new Tile(2857, 3166, 0))
        )));

        new OneWayLink(PortSarimBoat, PortSarim.MusaPointBoat, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2953, 3146, 0)),
                new KaramjaCustomsOfficer(3648, "Pay-fare", PortSarimBoat.area),
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
