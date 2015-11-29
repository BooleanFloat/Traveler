package org.booleanfloat.traveler.regions.karamja;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.kandarin.EastArdougne;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.npcs.KaramjaCustomsOfficer;
import org.powerbot.script.Area;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Brimhaven implements Region {
    public static Location EastArdougneBoat;
    public static Location MembersGate;
    public static Location POHPortal;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(EastArdougneBoat);
        locations.add(MembersGate);
        locations.add(POHPortal);

        return locations;
    }

    public static void initLocations() {
        EastArdougneBoat = new Location("Brimhaven, EastArdougneBoat", new Area(
                new Tile(2775, 3236, 0),
                new Tile(2769, 3223, 0)
        ));

        MembersGate = new Location("Brimhaven, MembersGate", new Area(
                new Tile(2814, 3183, 0),
                new Tile(2812, 3181, 0)
        ));

        POHPortal = new Location("Brimhaven, POHPortal", new Area(
                new Tile(2759, 3179, 0),
                new Tile(2757, 3174, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(EastArdougneBoat, MembersGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2772, 3226, 0)),
                new Step(new Tile(2773, 3217, 0)),
                new Step(new Tile(2786, 3211, 0)),
                new Step(new Tile(2797, 3206, 0)),
                new Step(new Tile(2802, 3195, 0)),
                new Step(new Tile(2803, 3184, 0)),
                new Step(new Tile(2815, 3182, 0))
        )));

        new TwoWayLink(EastArdougneBoat, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2772, 3225, 0)),
                new Step(new Tile(2772, 3217, 0)),
                new Step(new Tile(2762, 3213, 0)),
                new Step(new Tile(2757, 3198, 0)),
                new Step(new Tile(2758, 3176, 0))
        )));

        new OneWayLink(EastArdougneBoat, EastArdougne.BrimhavenBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2772, 3226, 0)),
                new KaramjaCustomsOfficer(3648, "Pay-fare", EastArdougneBoat.area),
                new Obstacle(2086, "Cross", new Tile(2683, 3269, 1))
        )), new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // requires 30 coins
                return ctx.inventory.select().id(Config.COINS_ID).poll().stackSize() >= 30;
            }
        });

        new TwoWayLink(MembersGate, POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2814, 3182, 0)),
                new Step(new Tile(2803, 3183, 0)),
                new Step(new Tile(2801, 3177, 0)),
                new Step(new Tile(2787, 3178, 0)),
                new Step(new Tile(2781, 3185, 0)),
                new Step(new Tile(2764, 3185, 0)),
                new Step(new Tile(2764, 3180, 0)),
                new Step(new Tile(2759, 3177, 0))
        )));

        new TwoWayLink(MembersGate, MusaPoint.VolcanoEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2813, 3182, 0)),
                new Obstacle(7168, "Open", new Tile(2816, 3182, 0), new int[]{-16, 32, -196, 0, 0, 128}),
                new Obstacle(7169, "Open", new Tile(2816, 3183, 0), new int[]{-16, 32, -196, 0, 0, 128}),
                new Obstacle(7407, "Open", new Tile(2816, 3182, 0), new int[]{-16, 32, -196, 0, 0, 128}),
                new Obstacle(7408, "Open", new Tile(2816, 3183, 0), new int[]{-16, 32, -196, 0, 0, 128}),
                new Step(new Tile(2822, 3181, 0)),
                new Step(new Tile(2829, 3157, 0)),
                new Step(new Tile(2857, 3157, 0)),
                new Step(new Tile(2857, 3166, 0))
        )));
    }
}
