package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.Resources;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TeleportLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.obstacles.CamelotCastleGateIn;
import org.booleanfloat.traveler.steps.obstacles.CamelotCastleGateOut;
import org.powerbot.script.Area;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Magic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class SeersVillage implements Region {
    public static Location Bank;
    public static Location CastleCourtyard;
    public static Location CastleGate;
    public static Location GalahadsHouseEntrance;
    public static Location RangeGuildEntrance;
    public static Location SpinningHouse;
    public static Location SouthHouse;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(CastleCourtyard);
        locations.add(CastleGate);
        locations.add(GalahadsHouseEntrance);
        locations.add(RangeGuildEntrance);
        locations.add(SpinningHouse);
        locations.add(SouthHouse);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("SeersVillage, Bank", new Area(
                new Tile(2730, 3492, 0),
                new Tile(2721, 3489, 0)
        ));

        CastleCourtyard = new Location("SeersVillage, CastleCourtyard", new Area(
                new Tile(2764, 3502, 0),
                new Tile(2753, 3492, 0)
        ));

        CastleGate = new Location("SeersVillage, CastleGate", new Area(
                new Tile(2761, 3480, 0),
                new Tile(2756, 3476, 0)
        ));

        GalahadsHouseEntrance = new Location("SeersVillage, GalahadsHouseEntrance", new Area(
                new Tile(2615, 3483, 0),
                new Tile(2610, 3481, 0)
        ));

        RangeGuildEntrance = new Location("SeersVillage, RangeGuildEntrance", new Area(
                new Tile(2660, 3443, 0),
                new Tile(2651, 3437, 0)
        ));

        SpinningHouse = new Location("SeersVillage, SpinningHouse", new Area(
                new Tile(2716, 3473, 1),
                new Tile(2709, 3469, 1)
        ));

        SouthHouse = new Location("SeersVillage, SouthHouse", new Area(
                new Tile(2706, 3476, 0),
                new Tile(2699, 3469, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TeleportLink(CastleGate, Magic.Spell.CAMELOT_TELEPORT, new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().id(Resources.AIR_RUNE_ID).poll().stackSize() > 5
                        && ctx.inventory.select().id(Resources.LAW_RUNE_ID).poll().stackSize() > 1;
            }
        });

        new TwoWayLink(Bank, CastleGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2726, 3487, 0)),
                new Step(new Tile(2726, 3484, 0)),
                new Step(new Tile(2732, 3484, 0)),
                new Step(new Tile(2740, 3479, 0)),
                new Step(new Tile(2758, 3477, 0))
        )));

        new TwoWayLink(Bank, RangeGuildEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2726, 3491, 0)),
                new Step(new Tile(2725, 3483, 0)),
                new Step(new Tile(2706, 3484, 0)),
                new Step(new Tile(2681, 3472, 0)),
                new Step(new Tile(2673, 3465, 0)),
                new Step(new Tile(2672, 3459, 0)),
                new Step(new Tile(2655, 3441, 0))
        )));

        new OneWayLink(Bank, SpinningHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2725, 3491, 0)),
                new Step(new Tile(2725, 3473, 0)),
                new Step(new Tile(2717, 3471, 0)),
                new Obstacle(25819, "Open", new Tile(2716, 3472, 0), new int[]{-32, 32, -196, 0, 16, 128}),
                new Step(new Tile(2713, 3471, 0)),
                new Obstacle(25938, "Climb-up", new Tile(2715, 3470, 0))
        )));

        new TwoWayLink(Bank, SouthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2726, 3491, 0)),
                new Step(new Tile(2726, 3483, 0)),
                new Step(new Tile(2706, 3483, 0)),
                new Step(new Tile(2701, 3477, 0)),
                new Obstacle(25819, "Open", new Tile(2701, 3477, 0), new int[]{0, 128, -224, 0, -32, 32}),
                new Step(new Tile(2702, 3473, 0))
        )));

        new OneWayLink(CastleCourtyard, CastleGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2758, 3483, 0)),
                new CamelotCastleGateOut(26082, new Tile(2758, 3482, 0)),
                new CamelotCastleGateOut(26081, new Tile(2757, 3482, 0)),
                new Step(new Tile(2758, 3481, 0))
        )));

        new OneWayLink(CastleGate, CastleCourtyard, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2758, 3481, 0)),
                new CamelotCastleGateIn(26082, new Tile(2758, 3482, 0)),
                new CamelotCastleGateIn(26081, new Tile(2757, 3482, 0)),
                new Step(new Tile(2758, 3483, 0))
        )));

        new TwoWayLink(GalahadsHouseEntrance, RangeGuildEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2612, 3481, 0)),
                new Step(new Tile(2617, 3480, 0)),
                new Step(new Tile(2620, 3471, 0)),
                new Step(new Tile(2631, 3457, 0)),
                new Step(new Tile(2643, 3455, 0)),
                new Step(new Tile(2644, 3447, 0)),
                new Step(new Tile(2653, 3441, 0))
        )));

        new OneWayLink(SpinningHouse, Bank, new ArrayList<>(Arrays.asList(
                new Obstacle(25939, "Climb-down", new Tile(2715, 3470, 1)),
                new Step(new Tile(2713, 3471, 0)),
                new Obstacle(25819, "Open", new Tile(2716, 3472, 0), new int[]{-32, 32, -196, 0, 16, 128}),
                new Step(new Tile(2717, 3471, 0)),
                new Step(new Tile(2725, 3473, 0)),
                new Step(new Tile(2725, 3491, 0))
        )));
    }
}
