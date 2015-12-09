package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.Resources;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TeleportLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.karamja.Brimhaven;
import org.booleanfloat.traveler.steps.ImportantStep;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.npcs.EastArdougneKaramjaCaptain;
import org.powerbot.script.Area;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Magic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class EastArdougne implements Region {
    public static Location BrimhavenBoat;
    public static Location Church;
    public static Location ChurchTower;
    public static Location EastGate;
    public static Location FishingGuildEntrance;
    public static Location GeneralStore;
    public static Location LegendsGuildEntrance;
    public static Location Market;
    public static Location MarketArmourStoreOutside;
    public static Location MarketNorthHouseUpstairs;
    public static Location NorthBank;
    public static Location NorthGate;
    public static Location NorthMill;
    public static Location NorthMillTop;
    public static Location NorthShed;
    public static Location NorthWestGate;
    public static Location PicnicArea;
    public static Location Pub;
    public static Location PubUpstairs;
    public static Location SouthBank;
    public static Location SouthGap;
    public static Location SouthZooEntrance;
    public static Location ZooMonkeyCage;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(BrimhavenBoat);
        locations.add(Church);
        locations.add(ChurchTower);
        locations.add(EastGate);
        locations.add(FishingGuildEntrance);
        locations.add(GeneralStore);
        locations.add(LegendsGuildEntrance);
        locations.add(Market);
        locations.add(MarketArmourStoreOutside);
        locations.add(MarketNorthHouseUpstairs);
        locations.add(NorthBank);
        locations.add(NorthGate);
        locations.add(NorthMill);
        locations.add(NorthMillTop);
        locations.add(NorthWestGate);
        locations.add(NorthShed);
        locations.add(PicnicArea);
        locations.add(Pub);
        locations.add(PubUpstairs);
        locations.add(SouthBank);
        locations.add(SouthGap);
        locations.add(SouthZooEntrance);
        locations.add(ZooMonkeyCage);

        return locations;
    }

    public static void initLocations() {
        BrimhavenBoat = new Location("EastArdougne, BrimhavenBoat", new Area(
                new Tile(2686, 3278, 0),
                new Tile(2676, 3270, 0)
        ));

        Church = new Location("EastArdougne, Church", new Area(
                new Tile(2622, 3310, 0),
                new Tile(2613, 3303, 0)
        ));

        ChurchTower = new Location("EastArdougne, ChurchTower", new Area(
                new Tile(2613, 3310, 1),
                new Tile(2609, 3303, 1)
        ));

        EastGate = new Location("EastArdougne, EastGate", new Area(
                new Tile(2689, 3306, 0),
                new Tile(2686, 3302, 0)
        ));

        FishingGuildEntrance = new Location("EastArdougne, FishingGuildEntrance", new Area(
                new Tile(2613, 3393, 0),
                new Tile(2610, 3391, 0)
        ));

        GeneralStore = new Location("EastArdougne, GeneralStore", new Area(
                new Tile(2617, 3294, 0),
                new Tile(2612, 3290, 0)
        ));

        LegendsGuildEntrance = new Location("EastArdougne, LegendsGuildEntrance", new Area(
                new Tile(2731, 3349, 0),
                new Tile(2727, 3347, 0)
        ));

        Market = new Location("EastArdougne, Market", new Area(
                new Tile(2666, 3317, 0),
                new Tile(2671, 3313, 0),
                new Tile(2671, 3295, 0),
                new Tile(2667, 3294, 0),
                new Tile(2657, 3295, 0),
                new Tile(2653, 3298, 0),
                new Tile(2653, 3311, 0),
                new Tile(2653, 3315, 0),
                new Tile(2656, 3317, 0)
        ));

        MarketArmourStoreOutside = new Location("EastArdougne, MarketArmourStoreOutside", new Area(
                new Tile(2656, 3299, 0),
                new Tile(2653, 3297, 0)
        ));

        MarketNorthHouseUpstairs = new Location("EastArdougne, MarketNorthHouseUpstairs", new Area(
                new Tile(2656, 3322, 1),
                new Tile(2653, 3317, 1)
        ));

        NorthBank = new Location("EastArdougne, NorthBank", new Area(
                new Tile(2621, 3335, 0),
                new Tile(2613, 3329, 0)
        ));

        NorthGate = new Location("EastArdougne, NorthGate", new Area(
                new Tile(2638, 3341, 0),
                new Tile(2634, 3337, 0)
        ));

        NorthMill = new Location("EastArdougne, NorthMill", new Area(
                new Tile(2634, 3389, 0),
                new Tile(2637, 3386, 0),
                new Tile(2637, 3383, 0),
                new Tile(2634, 3380, 0),
                new Tile(2632, 3380, 0),
                new Tile(2628, 3384, 0),
                new Tile(2628, 3385, 0),
                new Tile(2632, 3389, 0)
        ));


        NorthMillTop = new Location("EastArdougne, NorthMillTop", new Area(
                new Tile(2634, 3389, 2),
                new Tile(2637, 3386, 2),
                new Tile(2637, 3383, 2),
                new Tile(2634, 3380, 2),
                new Tile(2632, 3380, 2),
                new Tile(2628, 3384, 2),
                new Tile(2628, 3385, 2),
                new Tile(2632, 3389, 2)
        ));

        NorthShed = new Location("EastArdougne, NorthShed", new Area(
                new Tile(2621, 3347, 0),
                new Tile(2621, 3345, 0),
                new Tile(2623, 3345, 0),
                new Tile(2623, 3341, 0),
                new Tile(2617, 3341, 0),
                new Tile(2617, 3347, 0)
        ));

        NorthWestGate = new Location("EastArdougne, NorthWestGate", new Area(
                new Tile(2590, 3342, 0),
                new Tile(2586, 3339, 0)
        ));

        PicnicArea = new Location("EastArdougne, PicnicArea", new Area(
                new Tile(2725, 3341, 0),
                new Tile(2718, 3335, 0)
        ));

        Pub = new Location("EastArdougne, Pub", new Area(
                new Tile(2578, 3326, 0),
                new Tile(2572, 3317, 0)
        ));

        PubUpstairs = new Location("EastArdougne, PubUpstairs", new Area(
                new Tile(2578, 3326, 1),
                new Tile(2572, 3317, 1)
        ));

        SouthBank = new Location("EastArdougne, SouthBank", new Area(
                new Tile(2658, 3287, 0),
                new Tile(2651, 3279, 0)
        ));

        SouthGap = new Location("EastArdougne, SouthGap", new Area(
                new Tile(2641, 3263, 0),
                new Tile(2639, 3261, 0)
        ));

        SouthZooEntrance = new Location("EastArdougne, SouthZooEntrance", new Area(
                new Tile(2603, 3263, 0),
                new Tile(2600, 3261, 0)
        ));

        ZooMonkeyCage = new Location("EastArdougne, ZooMonkeyCage", new Area(
                new Tile(2605, 3283, 0),
                new Tile(2608, 3280, 0),
                new Tile(2608, 3276, 0),
                new Tile(2605, 3273, 0),
                new Tile(2602, 3273, 0),
                new Tile(2600, 3271, 0),
                new Tile(2598, 3271, 0),
                new Tile(2596, 3275, 0),
                new Tile(2596, 3277, 0),
                new Tile(2597, 3280, 0),
                new Tile(2600, 3283, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TeleportLink(Market, Magic.Spell.ARDOUGNE_TELEPORT, new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.skills.realLevel(Constants.SKILLS_MAGIC) >= 51
                        && ctx.inventory.select().id(Resources.WATER_RUNE_ID).poll().stackSize() > 2
                        && ctx.inventory.select().id(Resources.LAW_RUNE_ID).poll().stackSize() > 2;
            }
        });

        new TwoWayLink(BrimhavenBoat, SouthBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2680, 3274, 0)),
                new Step(new Tile(2673, 3275, 0)),
                new Step(new Tile(2666, 3280, 0)),
                new Step(new Tile(2661, 3280, 0)),
                new Step(new Tile(2661, 3277, 0)),
                new Step(new Tile(2643, 3277, 0)),
                new Step(new Tile(2643, 3283, 0)),
                new Step(new Tile(2654, 3283, 0))
        )));

        new TwoWayLink(BrimhavenBoat, Market, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2679, 3275, 0)),
                new Step(new Tile(2673, 3275, 0)),
                new Step(new Tile(2664, 3282, 0)),
                new Step(new Tile(2663, 3297, 0))
        )));

        new OneWayLink(BrimhavenBoat, Brimhaven.EastArdougneBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2679, 3276, 0)),
                new EastArdougneKaramjaCaptain(3649, "Pay-fare", BrimhavenBoat.area),
                new Step(new Tile(2775, 3234, 1)),
                new Obstacle(2088, "Cross", new Tile(2774, 3234, 1))
        )), new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // requires 30 coins
                return ctx.inventory.select().id(Config.COINS_ID).poll().stackSize() >= 30;
            }
        });

        new TwoWayLink(Church, GeneralStore, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2616, 3306, 0)),
                new Step(new Tile(2616, 3298, 0)),
                new Step(new Tile(2613, 3297, 0)),
                new Step(new Tile(2615, 3293, 0))
        )));

        new OneWayLink(Church, ChurchTower, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2613, 3309, 0)),
                new Obstacle(7129, "Open", new Tile(2612, 3309, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Obstacle(7122, "Open", new Tile(2610, 3307, 0), new int[]{0, 128, -196, 0, 96, 128}),
                new Obstacle(11683, "Climb-up", new Tile(2610, 3306, 0))
        )));

        new OneWayLink(ChurchTower, Church, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2611, 3306, 1)),
                new Obstacle(11684, "Climb-down", new Tile(2610, 3306, 1)),
                new Obstacle(7122, "Open", new Tile(2610, 3307, 0), new int[]{0, 128, -196, 0, 96, 128}),
                new Obstacle(7129, "Open", new Tile(2612, 3309, 0), new int[]{96, 128, -192, 0, 0, 128})
        )));

        new TwoWayLink(EastGate, Market);

        new TwoWayLink(EastGate, PicnicArea, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2688, 3304, 0)),
                new Step(new Tile(2691, 3306, 0)),
                new Step(new Tile(2699, 3322, 0)),
                new Step(new Tile(2718, 3327, 0)),
                new Step(new Tile(2722, 3338, 0))
        )));

        new TwoWayLink(EastGate, SeersVillage.Bank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2687, 3304, 0)),
                new Step(new Tile(2691, 3306, 0)),
                new Step(new Tile(2699, 3323, 0)),
                new Step(new Tile(2704, 3349, 0)),
                new Step(new Tile(2708, 3387, 0)),
                new Step(new Tile(2716, 3398, 0)),
                new Step(new Tile(2717, 3427, 0)),
                new Step(new Tile(2729, 3437, 0)),
                new Step(new Tile(2727, 3463, 0)),
                new Step(new Tile(2725, 3490, 0))
        )));

        new TwoWayLink(FishingGuildEntrance, NorthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2611, 3392, 0)),
                new Step(new Tile(2632, 3379, 0)),
                new Step(new Tile(2635, 3373, 0)),
                new Step(new Tile(2636, 3339, 0))
        )));

        new TwoWayLink(FishingGuildEntrance, NorthMill, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2611, 3392, 0)),
                new Step(new Tile(2632, 3379, 0)),
                new Obstacle(7122, "Open", new Tile(2632, 3381, 0), new int[]{0, 128, -196, 0, 96, 128}),
                new Step(new Tile(2632, 3383, 0))
        )));

        new TwoWayLink(FishingGuildEntrance, NorthWestGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2611, 3392, 0)),
                new Step(new Tile(2588, 3383, 0)),
                new Step(new Tile(2582, 3369, 0)),
                new Step(new Tile(2582, 3351, 0)),
                new Step(new Tile(2587, 3341, 0))
        )));

        new TwoWayLink(FishingGuildEntrance, SeersVillage.RangeGuildEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2611, 3392, 0)),
                new Step(new Tile(2620, 3391, 0)),
                new Step(new Tile(2630, 3395, 0)),
                new Step(new Tile(2638, 3407, 0)),
                new Step(new Tile(2639, 3412, 0)),
                new Step(new Tile(2647, 3418, 0)),
                new Step(new Tile(2645, 3431, 0)),
                new Step(new Tile(2656, 3440, 0))
        )));

        new TwoWayLink(GeneralStore, Market, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3292, 0)),
                new Step(new Tile(2614, 3297, 0)),
                new Step(new Tile(2629, 3296, 0)),
                new Step(new Tile(2637, 3299, 0)),
                new Step(new Tile(2643, 3305, 0)),
                new Step(new Tile(2662, 3305, 0))
        )));

        new TwoWayLink(GeneralStore, NorthBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3292, 0)),
                new Step(new Tile(2614, 3297, 0)),
                new Step(new Tile(2607, 3297, 0)),
                new Step(new Tile(2609, 3336, 0)),
                new Step(new Tile(2611, 3339, 0)),
                new Step(new Tile(2617, 3338, 0)),
                new Step(new Tile(2617, 3333, 0))
        )));

        new TwoWayLink(GeneralStore, Pub, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3293, 0)),
                new Step(new Tile(2613, 3297, 0)),
                new Step(new Tile(2593, 3296, 0)),
                new Step(new Tile(2592, 3305, 0)),
                new Step(new Tile(2582, 3319, 0)),
                new Step(new Tile(2578, 3319, 0)),
                new Obstacle(7129, "Open", new Tile(2576, 3320, 0), new int[]{-16, 32, -192, 0, 0, 128}),
                new Step(new Tile(2576, 3320, 0))
        )));

        new TwoWayLink(GeneralStore, SouthBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3293, 0)),
                new Step(new Tile(2614, 3296, 0)),
                new Step(new Tile(2630, 3296, 0)),
                new Step(new Tile(2634, 3289, 0)),
                new Step(new Tile(2643, 3287, 0)),
                new Step(new Tile(2643, 3283, 0)),
                new Step(new Tile(2652, 3283, 0))
        )));

        new TwoWayLink(GeneralStore, SouthZooEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2615, 3293, 0)),
                new Step(new Tile(2614, 3297, 0)),
                new Step(new Tile(2609, 3297, 0)),
                new Step(new Tile(2608, 3291, 0)),
                new Step(new Tile(2604, 3287, 0)),
                new Step(new Tile(2604, 3285, 0)),
                new Step(new Tile(2599, 3281, 0)),
                new Step(new Tile(2597, 3277, 0)),
                new Step(new Tile(2597, 3272, 0)),
                new Step(new Tile(2600, 3269, 0)),
                new Step(new Tile(2601, 3261, 0))
        )));

        new TwoWayLink(GeneralStore, ZooMonkeyCage, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2615, 3293, 0)),
                new Step(new Tile(2614, 3297, 0)),
                new Step(new Tile(2609, 3298, 0)),
                new Step(new Tile(2604, 3288, 0)),
                new Step(new Tile(2604, 3284, 0)),
                new Step(new Tile(2600, 3283, 0)),
                new Step(new Tile(2598, 3280, 0))
        )));

        new TwoWayLink(LegendsGuildEntrance, PicnicArea);

        new TwoWayLink(Market, MarketArmourStoreOutside);

        new OneWayLink(Market, MarketNorthHouseUpstairs, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2659, 3320, 0)),
                new Obstacle(7122, "Open", new Tile(2659, 3320, 0), new int[]{0, 128, -196, 0, 96, 128}),
                new Step(new Tile(2657, 3321, 0)),
                new Obstacle(17026, "Climb-up", new Tile(2655, 3322, 0))
        )));

        new TwoWayLink(Market, NorthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2661, 3306, 0)),
                new Step(new Tile(2652, 3317, 0)),
                new Step(new Tile(2648, 3329, 0)),
                new Step(new Tile(2639, 3334, 0))
        )));

        new TwoWayLink(Market, SouthBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2662, 3303, 0)),
                new Step(new Tile(2663, 3289, 0)),
                new Step(new Tile(2644, 3289, 0)),
                new Step(new Tile(2644, 3283, 0)),
                new Step(new Tile(2655, 3283, 0))
        )));

        new OneWayLink(MarketNorthHouseUpstairs, Market, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2655, 3321, 1)),
                new Obstacle(16685, "Climb-down", new Tile(2655, 3322, 1)),
                new Step(new Tile(2657, 3321, 0)),
                new Obstacle(7122, "Open", new Tile(2659, 3320, 0), new int[]{0, 128, -196, 0, 96, 128}),
                new Step(new Tile(2659, 3320, 0))
        )));


        new TwoWayLink(NorthBank, NorthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2617, 3332, 0)),
                new Step(new Tile(2617, 3337, 0)),
                new Step(new Tile(2632, 3337, 0))
        )));

        new TwoWayLink(NorthBank, NorthShed, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2617, 3333, 0)),
                new Step(new Tile(2617, 3337, 0)),
                new Step(new Tile(2613, 3339, 0)),
                new Step(new Tile(2613, 3345, 0)),
                new Obstacle(7122, "Open", new Tile(2616, 3345, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2618, 3344, 0))
        )));

        new TwoWayLink(NorthBank, NorthWestGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2617, 3334, 0)),
                new Step(new Tile(2617, 3337, 0)),
                new Step(new Tile(2613, 3339, 0)),
                new Step(new Tile(2611, 3369, 0)),
                new Step(new Tile(2582, 3370, 0)),
                new Step(new Tile(2582, 3351, 0)),
                new Step(new Tile(2587, 3341, 0))
        )));

        new TwoWayLink(NorthGate, NorthMill, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2636, 3339, 0)),
                new Step(new Tile(2636, 3373, 0)),
                new Step(new Tile(2633, 3375, 0)),
                new Step(new Tile(2632, 3380, 0)),
                new Obstacle(7122, "Open", new Tile(2632, 3381, 0), new int[]{0, 128, -196, 0, 96, 128}),
                new Step(new Tile(2632, 3382, 0))
        )));

        new TwoWayLink(NorthGate, SeersVillage.RangeGuildEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2636, 3339, 0)),
                new Step(new Tile(2636, 3373, 0)),
                new Step(new Tile(2645, 3374, 0)),
                new Step(new Tile(2646, 3391, 0)),
                new Step(new Tile(2643, 3401, 0)),
                new Step(new Tile(2647, 3407, 0)),
                new Step(new Tile(2645, 3419, 0)),
                new Step(new Tile(2646, 3431, 0)),
                new Step(new Tile(2655, 3441, 0))
        )));

        new OneWayLink(NorthMill, NorthMillTop, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2631, 3386, 0)),
                new Obstacle(16683, "Climb-up", new Tile(2630, 3386, 0)),
                new Obstacle(16684, "Climb-up", new Tile(2630, 3386, 1)),
                new Step(new Tile(2631, 3385, 2))
        )));

        new OneWayLink(NorthMillTop, NorthMill, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2631, 3385, 2)),
                new Obstacle(16679, "Climb-down", new Tile(2630, 3386, 2)),
                new Obstacle(16684, "Climb-down", new Tile(2630, 3386, 1)),
                new Step(new Tile(2631, 3386, 0))
        )));

        new TwoWayLink(NorthMill, SeersVillage.RangeGuildEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2633, 3382, 0)),
                new Obstacle(7122, "Open", new Tile(2632, 3381, 0), new int[]{0, 128, -196, 0, 96, 128}),
                new Step(new Tile(2633, 3380, 0)),
                new Step(new Tile(2645, 3381, 0)),
                new Step(new Tile(2646, 3391, 0)),
                new Step(new Tile(2643, 3402, 0)),
                new Step(new Tile(2647, 3409, 0)),
                new Step(new Tile(2645, 3420, 0)),
                new Step(new Tile(2647, 3432, 0)),
                new Step(new Tile(2655, 3440, 0))
        )));

        new TwoWayLink(NorthWestGate, Pub, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2587, 3340, 0)),
                new Step(new Tile(2587, 3332, 0)),
                new Step(new Tile(2582, 3328, 0)),
                new Step(new Tile(2581, 3320, 0)),
                new Step(new Tile(2578, 3318, 0)),
                new Obstacle(7129, "Open", new Tile(2576, 3320, 0), new int[]{-16, 32, -192, 0, 0, 128}),
                new Step(new Tile(2576, 3320, 0))
        )));

        new TwoWayLink(NorthWestGate, TreeGnomeStronghold.GateOutside, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2588, 3341, 0)),
                new Step(new Tile(2587, 3345, 0)),
                new Step(new Tile(2554, 3345, 0)),
                new Step(new Tile(2519, 3348, 0)),
                new Step(new Tile(2471, 3356, 0)),
                new Step(new Tile(2460, 3382, 0))
        )));

        new TwoWayLink(PicnicArea, Catherby.GeneralStore, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2722, 3338, 0)),
                new Step(new Tile(2726, 3344, 0)),
                new Step(new Tile(2735, 3347, 0)),
                new Step(new Tile(2740, 3363, 0)),
                new Step(new Tile(2742, 3387, 0)),
                new Step(new Tile(2749, 3401, 0)),
                new Step(new Tile(2763, 3428, 0)),
                new Step(new Tile(2777, 3434, 0)),
                new Step(new Tile(2803, 3431, 0))
        )));

        new TwoWayLink(PicnicArea, SeersVillage.CastleGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2724, 3340, 0)),
                new Step(new Tile(2727, 3344, 0)),
                new Step(new Tile(2736, 3348, 0)),
                new Step(new Tile(2740, 3364, 0)),
                new Step(new Tile(2739, 3387, 0)),
                new Step(new Tile(2736, 3414, 0)),
                new Step(new Tile(2734, 3453, 0)),
                new Step(new Tile(2749, 3462, 0)),
                new Step(new Tile(2757, 3478, 0))
        )));

        new OneWayLink(Pub, PubUpstairs, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2574, 3324, 0)),
                new Obstacle(16671, "Climb-up", new Tile(2573, 3326, 0)),
                new Step(new Tile(2574, 3324, 1))
        )));

        new OneWayLink(PubUpstairs, Pub, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2574, 3324, 1)),
                new Obstacle(16673, "Climb-down", new Tile(2573, 3325, 1)),
                new Step(new Tile(2574, 3324, 0))
        )));

        new TwoWayLink(SouthBank, SouthGap, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2652, 3283, 0)),
                new Step(new Tile(2642, 3283, 0)),
                new Step(new Tile(2641, 3266, 0)),
                new Step(new Tile(2640, 3262, 0))
        )));

        new TwoWayLink(SouthGap, PortKhazard.Entrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2640, 3263, 0)),
                new Step(new Tile(2631, 3244, 0)),
                new Step(new Tile(2624, 3171, 0))
        )));

        new TwoWayLink(SouthZooEntrance, ZooMonkeyCage, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2601, 3262, 0)),
                new Step(new Tile(2600, 3266, 0)),
                new Step(new Tile(2599, 3271, 0)),
                new Step(new Tile(2597, 3273, 0)),
                new Step(new Tile(2597, 3279, 0))
        )));

        new TwoWayLink(SouthZooEntrance, PortKhazard.Entrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2600, 3262, 0)),
                new Step(new Tile(2602, 3244, 0)),
                new Step(new Tile(2619, 3217, 0)),
                new Step(new Tile(2625, 3208, 0)),
                new Step(new Tile(2624, 3174, 0))
        )));
    }
}
