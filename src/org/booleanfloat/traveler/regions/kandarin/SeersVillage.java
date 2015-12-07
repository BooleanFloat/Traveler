package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.Resources;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TeleportLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.obstacles.CamelotCastleGate;
import org.booleanfloat.traveler.steps.obstacles.SinclairMansionDoor;
import org.powerbot.script.Area;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Magic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class SeersVillage implements Region {
    public static Location Bank;
    public static Location CastleCourtyard;
    public static Location CastleGate;
    public static Location CastleSouthWestTower;
    public static Location GalahadsHouseEntrance;
    public static Location HemensterNorthHouse;
    public static Location KeepLeFayeEntrance;
    public static Location RangeGuildEntrance;
    public static Location SinclairMansion;
    public static Location SinclairMansionGate;
    public static Location SinclairMansionKitchen;
    public static Location SpinningHouse;
    public static Location SouthHouse;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(CastleCourtyard);
        locations.add(CastleGate);
        locations.add(CastleSouthWestTower);
        locations.add(GalahadsHouseEntrance);
        locations.add(HemensterNorthHouse);
        locations.add(KeepLeFayeEntrance);
        locations.add(RangeGuildEntrance);
        locations.add(SinclairMansion);
        locations.add(SinclairMansionGate);
        locations.add(SinclairMansionKitchen);
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

        CastleSouthWestTower = new Location("SeersVillage, CastleSouthWestTower", new Area(
                new Tile(2752, 3495, 2),
                new Tile(2746, 3489, 2)
        ));

        GalahadsHouseEntrance = new Location("SeersVillage, GalahadsHouseEntrance", new Area(
                new Tile(2615, 3483, 0),
                new Tile(2610, 3481, 0)
        ));

        HemensterNorthHouse = new Location("SeersVillage, HemensterNorthHouse", new Area(
                new Tile(2641, 3454, 0),
                new Tile(2635, 3448, 0)
        ));

        KeepLeFayeEntrance = new Location("SeersVillage, KeepLeFayeEntrance", new Area(
                new Tile(2763, 3404, 0),
                new Tile(2759, 3399, 0)
        ));

        RangeGuildEntrance = new Location("SeersVillage, RangeGuildEntrance", new Area(
                new Tile(2660, 3443, 0),
                new Tile(2651, 3437, 0)
        ));

        SinclairMansion = new Location("SeersVillage, SinclairMansion", new Area(
                new Tile(2745, 3582, 0),
                new Tile(2736, 3573, 0)
        ));

        SinclairMansionGate = new Location("SeersVillage, SinclairMansionGate", new Area(
                new Tile(2743, 3554, 0),
                new Tile(2740, 3551, 0)
        ));

        SinclairMansionKitchen = new Location("SeersVillage, SinclairMansionKitchen", new Area(
                new Tile(2735, 3582, 0),
                new Tile(2733, 3580, 0)
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
                return ctx.skills.realLevel(Constants.SKILLS_MAGIC) >= 45
                        && ctx.inventory.select().id(Resources.AIR_RUNE_ID).poll().stackSize() > 5
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

        new TwoWayLink(Bank, KeepLeFayeEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2725, 3490, 0)),
                new Step(new Tile(2727, 3461, 0)),
                new Step(new Tile(2733, 3436, 0)),
                new Step(new Tile(2743, 3420, 0)),
                new Step(new Tile(2753, 3416, 0)),
                new Step(new Tile(2751, 3402, 0)),
                new Step(new Tile(2759, 3401, 0))
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

        new TwoWayLink(Bank, SinclairMansionGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2725, 3490, 0)),
                new Step(new Tile(2725, 3483, 0)),
                new Step(new Tile(2733, 3484, 0)),
                new Step(new Tile(2741, 3496, 0)),
                new Step(new Tile(2742, 3515, 0)),
                new Step(new Tile(2742, 3553, 0))
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
                new CamelotCastleGate(26082, new Tile(2758, 3482, 0), CamelotCastleGate.Direction.OUT),
                new CamelotCastleGate(26081, new Tile(2757, 3482, 0), CamelotCastleGate.Direction.OUT),
                new Step(new Tile(2758, 3481, 0))
        )));

        new OneWayLink(CastleCourtyard, CastleSouthWestTower, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2758, 3503, 0)),
                new Obstacle(25638, "Open", new Tile(2757, 3503, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Obstacle(25640, "Open", new Tile(2758, 3503, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Step(new Tile(2757, 3505, 0)),
                new Step(new Tile(2750, 3505, 0)),
                new Obstacle(25642, "Open", new Tile(2750, 3503, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Step(new Tile(2750, 3496, 0)),
                new Obstacle(25642, "Open", new Tile(2750, 3496, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(2748, 3493, 0)),
                new Obstacle(26107, "Climb-up", new Tile(2747, 3493, 0)),
                new Step(new Tile(2749, 3492, 1)),
                new Obstacle(26107, "Climb-up", new Tile(2749, 3491, 1)),
                new Step(new Tile(2748, 3493, 2))
        )));

        new OneWayLink(CastleSouthWestTower, CastleCourtyard, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2748, 3493, 2)),
                new Obstacle(25606, "Climb-down", new Tile(2749, 3491, 2)),
                new Step(new Tile(2749, 3492, 1)),
                new Obstacle(25606, "Climb-down", new Tile(2747, 3493, 1)),
                new Step(new Tile(2748, 3493, 0)),
                new Obstacle(25642, "Open", new Tile(2750, 3496, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(2750, 3496, 0)),
                new Obstacle(25642, "Open", new Tile(2750, 3503, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Step(new Tile(2750, 3505, 0)),
                new Step(new Tile(2757, 3505, 0)),
                new Obstacle(25640, "Open", new Tile(2758, 3503, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Obstacle(25638, "Open", new Tile(2757, 3503, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Step(new Tile(2758, 3503, 0))
        )));

        new OneWayLink(CastleGate, CastleCourtyard, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2758, 3481, 0)),
                new CamelotCastleGate(26082, new Tile(2758, 3482, 0), CamelotCastleGate.Direction.IN),
                new CamelotCastleGate(26081, new Tile(2757, 3482, 0), CamelotCastleGate.Direction.IN),
                new Step(new Tile(2758, 3483, 0)),
                new Step(new Tile(2758, 3490, 0)),
                new Step(new Tile(2758, 3496, 0))
        )));

        new TwoWayLink(CastleGate, KeepLeFayeEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2758, 3477, 0)),
                new Step(new Tile(2765, 3460, 0)),
                new Step(new Tile(2770, 3449, 0)),
                new Step(new Tile(2769, 3432, 0)),
                new Step(new Tile(2762, 3425, 0)),
                new Step(new Tile(2754, 3412, 0)),
                new Step(new Tile(2751, 3401, 0)),
                new Step(new Tile(2761, 3401, 0))
        )));

        new TwoWayLink(CastleGate, SinclairMansionGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2758, 3478, 0)),
                new Step(new Tile(2750, 3477, 0)),
                new Step(new Tile(2741, 3479, 0)),
                new Step(new Tile(2739, 3494, 0)),
                new Step(new Tile(2741, 3498, 0)),
                new Step(new Tile(2742, 3553, 0))
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

        new TwoWayLink(HemensterNorthHouse, RangeGuildEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2639, 3451, 0)),
                new Obstacle(7129, "Open", new Tile(2641, 3452, 0), Obstacle.Hitbox.DOOR_WEST),
                new Step(new Tile(2643, 3451, 0)),
                new Step(new Tile(2644, 3447, 0)),
                new Step(new Tile(2654, 3441, 0))
        )));

        new OneWayLink(SinclairMansion, SinclairMansionGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2740, 3574, 0)),
                new SinclairMansionDoor(25748, new Tile(2740, 3572, 0), SinclairMansionDoor.Direction.OUT),
                new SinclairMansionDoor(25750, new Tile(2741, 3572, 0), SinclairMansionDoor.Direction.OUT),
                new Step(new Tile(2742, 3570, 0)),
                new Step(new Tile(2742, 3556, 0)),
                new Obstacle(26130, "Open", new Tile(2741, 3555, 0), new int[]{0, 128, -160, 0, 112, 144}),
                new Obstacle(26131, "Open", new Tile(2742, 3555, 0), new int[]{0, 128, -160, 0, 112, 144}),
                new Step(new Tile(2742, 3553, 0))
        )));

        new OneWayLink(SinclairMansionGate, SinclairMansion, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2742, 3553, 0)),
                new Obstacle(26131, "Open", new Tile(2742, 3555, 0), new int[]{0, 128, -160, 0, 112, 144}),
                new Obstacle(26130, "Open", new Tile(2741, 3555, 0), new int[]{0, 128, -160, 0, 112, 144}),
                new Step(new Tile(2742, 3556, 0)),
                new Step(new Tile(2742, 3570, 0)),
                new SinclairMansionDoor(25750, new Tile(2741, 3572, 0), SinclairMansionDoor.Direction.IN),
                new SinclairMansionDoor(25748, new Tile(2740, 3572, 0), SinclairMansionDoor.Direction.IN),
                new Step(new Tile(2740, 3574, 0))
        )));

        new TwoWayLink(SinclairMansion, SinclairMansionKitchen, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2737, 3579, 0)),
                new Obstacle(25718, "Open", new Tile(2735, 3580, 0), new int[]{112, 128, -196, 0, 0, 128}),
                new Step(new Tile(2735, 3580, 0))
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
