package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.Resources;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TeleportLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Magic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Varrock implements Region {
    public static Location BlueMoonInn;
    public static Location ClothesStore;
    public static Location ClothesStoreUpstairs;
    public static Location DigSiteBush;
    public static Location EastBank;
    public static Location EastBankUpstairs;
    public static Location EastGate;
    public static Location ExamCenter;
    public static Location Fountain;
    public static Location GertrudesBedroom;
    public static Location GertrudesHouse;
    public static Location GrandExchange;
    public static Location HorviksArmoury;
    public static Location LimeStoneMine;
    public static Location LumberYard;
    public static Location MembersGate;
    public static Location NorthGate;
    public static Location RiverDigSpot;
    public static Location SouthGate;
    public static Location SouthGateHouse;
    public static Location SouthMine;
    public static Location SouthMineDigSpot;
    public static Location WestBank;
    public static Location WestBankBasement;
    public static Location WestBankBasementClueSpot;
    public static Location WestGate;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(BlueMoonInn);
        locations.add(ClothesStore);
        locations.add(ClothesStoreUpstairs);
        locations.add(DigSiteBush);
        locations.add(EastBank);
        locations.add(EastBankUpstairs);
        locations.add(EastGate);
        locations.add(ExamCenter);
        locations.add(Fountain);
        locations.add(GertrudesBedroom);
        locations.add(GertrudesHouse);
        locations.add(GrandExchange);
        locations.add(HorviksArmoury);
        locations.add(MembersGate);
        locations.add(LimeStoneMine);
        locations.add(LumberYard);
        locations.add(NorthGate);
        locations.add(RiverDigSpot);
        locations.add(SouthGate);
        locations.add(SouthGateHouse);
        locations.add(SouthMine);
        locations.add(SouthMineDigSpot);
        locations.add(WestBank);
        locations.add(WestBankBasement);
        locations.add(WestBankBasementClueSpot);
        locations.add(WestGate);

        return locations;
    }

    public static void initLocations() {
        BlueMoonInn = new Location("Varrock, BlueMoonInn", new Area(
                new Tile(3229, 3402, 0),
                new Tile(3217, 3392, 0)
        ));

        ClothesStore = new Location("Varrock, ClothesStore", new Area(
                new Tile(3207, 3419, 0),
                new Tile(3210, 3417, 0),
                new Tile(3209, 3416, 0),
                new Tile(3209, 3411, 0),
                new Tile(3208, 3410, 0),
                new Tile(3207, 3409, 0),
                new Tile(3202, 3414, 0),
                new Tile(3202, 3417, 0),
                new Tile(3204, 3419, 0)
        ));

        ClothesStoreUpstairs = new Location("Varrock, ClothesStoreUpstairs", new Area(
                new Tile(3207, 3419, 1),
                new Tile(3210, 3417, 1),
                new Tile(3209, 3416, 1),
                new Tile(3209, 3411, 1),
                new Tile(3208, 3410, 1),
                new Tile(3207, 3409, 1),
                new Tile(3202, 3414, 1),
                new Tile(3202, 3417, 1),
                new Tile(3204, 3419, 1)
        ));

        EastBank = new Location("Varrock, EastBank", new Area(
                new Tile(3254, 3422, 0),
                new Tile(3250, 3420, 0)
        ));

        EastBankUpstairs = new Location("Varrock, EastBankUpstairs", new Area(
                new Tile(3254, 3422, 1),
                new Tile(3250, 3420, 1)
        ));


        EastGate = new Location("Varrock, EastGate", new Area(
                new Tile(3275, 3431, 0),
                new Tile(3271, 3426, 0)
        ));

        ExamCenter = new Location("Varrock, ExamCenter", new Area(
                new Tile(3367, 3347, 0),
                new Tile(3357, 3340, 0)
        ));

        DigSiteBush = new Location("Varrock, DigSiteBush", new Area(
                new Tile(3347, 3380, 0),
                new Tile(3344, 3377, 0)
        ));

        Fountain = new Location("Varrock, Fountain", new Area(
                new Tile(3216, 3432, 0),
                new Tile(3209, 3425, 0)
        ));

        GertrudesBedroom = new Location("Varrock, GertrudesBedroom", new Area(
                new Tile(3156, 3407, 0),
                new Tile(3154, 3404, 0)
        ));

        GertrudesHouse = new Location("Varrock, GertrudesHouse", new Area(
                new Tile(3157, 3410, 0),
                new Tile(3157, 3403, 0),
                new Tile(3148, 3403, 0),
                new Tile(3148, 3411, 0)
        ));

        GrandExchange = new Location("Varrock, GrandExchange", new Area(
                new Tile(3168, 3493, 0),
                new Tile(3161, 3486, 0)
        ));

        HorviksArmoury = new Location("Varrock, HorviksArmoury", new Area(
                new Tile(3233, 3441, 0),
                new Tile(3227, 3432, 0)
        ));

        LimeStoneMine = new Location("Varrock, LimeStoneMine", new Area(
                new Tile(3375, 3504, 0),
                new Tile(3378, 3501, 0),
                new Tile(3377, 3497, 0),
                new Tile(3374, 3494, 0),
                new Tile(3370, 3493, 0),
                new Tile(3367, 3492, 0),
                new Tile(3367, 3495, 0),
                new Tile(3365, 3497, 0),
                new Tile(3368, 3501, 0),
                new Tile(3371, 3504, 0)
        ));

        LumberYard = new Location("Varrock, LumberYard", new Area(
                new Tile(3311, 3492, 0),
                new Tile(3301, 3488, 0)
        ));

        MembersGate = new Location("Varrock, MembersGate", new Area(
                new Tile(3319, 3468, 0),
                new Tile(3317, 3465, 0)
        ));

        NorthGate = new Location("Varrock, NorthGate", new Area(
                new Tile(3248, 3503, 0),
                new Tile(3244, 3498, 0)
        ));

        RiverDigSpot = new Location("Varrock, RiverDigSpot", new Area(
                new Tile(3169, 3361, 0),
                new Tile(3164, 3356, 0)
        ));

        SouthGate = new Location("Varrock, SouthGate", new Area(
                new Tile(3213, 3382, 0),
                new Tile(3210, 3380, 0)
        ));

        SouthGateHouse = new Location("Varrock, SouthGateHouse", new Area(
                new Tile(3207, 3389, 0),
                new Tile(3207, 3384, 0),
                new Tile(3202, 3384, 0),
                new Tile(3201, 3385, 0),
                new Tile(3201, 3388, 0),
                new Tile(3203, 3390, 0),
                new Tile(3206, 3390, 0)
        ));

        SouthMine = new Location("Varrock, SouthMine", new Area(
                new Tile(3292, 3373, 0),
                new Tile(3291, 3370, 0),
                new Tile(3291, 3364, 0),
                new Tile(3293, 3359, 0),
                new Tile(3291, 3357, 0),
                new Tile(3288, 3359, 0),
                new Tile(3282, 3359, 0),
                new Tile(3281, 3358, 0),
                new Tile(3278, 3361, 0),
                new Tile(3281, 3364, 0),
                new Tile(3281, 3371, 0)
        ));

        SouthMineDigSpot = new Location("Varrock, SouthMineDigSpot", new Area(
                new Tile(3290, 3375, 0),
                new Tile(3288, 3373, 0)
        ));

        WestBank = new Location("Varrock, WestBank", new Area(
                new Tile(3185, 3439, 0),
                new Tile(3181, 3434, 0)
        ));

        WestBankBasement = new Location("Varrock, WestBankBasement", new Area(
                new Tile(3196, 9834, 0),
                new Tile(3187, 9825, 0)
        ));

        WestBankBasementClueSpot = new Location("Varrock, WestBankBasementClueSpot", new Area(
                new Tile(3189, 9826, 0),
                new Tile(3186, 9824, 0)
        ));

        WestGate = new Location("Varrock, WestGate", new Area(
                new Tile(3176, 3430, 0),
                new Tile(3172, 3425, 0)
        ));
    }

    public static void initLinks(final ClientContext ctx) {
        new TeleportLink(Fountain, Magic.Spell.VARROCK_TELEPORT, new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.skills.realLevel(Constants.SKILLS_MAGIC) >= 25
                        && ctx.inventory.select().id(Resources.FIRE_RUNE_ID).poll().stackSize() > 1
                        && ctx.inventory.select().id(Resources.AIR_RUNE_ID).poll().stackSize() > 3
                        && ctx.inventory.select().id(Resources.LAW_RUNE_ID).poll().stackSize() > 1;
            }
        });

        new TwoWayLink(BlueMoonInn, SouthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3221, 3394, 0)),
                new Obstacle(11775, "Open", new Tile(3215, 3395, 0)),
                new Step(new Tile(3212, 3394, 0)),
                new Step(new Tile(3212, 3381, 0))
        )));

        new TwoWayLink(BlueMoonInn, Fountain, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3221, 3395, 0)),
                new Obstacle(11775, "Open", new Tile(3215, 3395, 0)),
                new Step(new Tile(3212, 3394, 0)),
                new Step(new Tile(3212, 3427, 0))
        )));

        new OneWayLink(ClothesStore, ClothesStoreUpstairs, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3202, 3417, 0)),
                new Obstacle(11794, "Climb-up", new Tile(3202, 3416, 0)),
                new Step(new Tile(3202, 3417, 1))
        )));

        new OneWayLink(ClothesStoreUpstairs, ClothesStore, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3202, 3417, 1)),
                new Obstacle(11795, "Climb-down", new Tile(3202, 3416, 1)),
                new Step(new Tile(3202, 3417, 0))
        )));

        new TwoWayLink(ClothesStore, Fountain, new ArrayList<Traversable>(Arrays.asList(
                new Obstacle(11775, "Open", new Tile(3209, 3415, 0)),
                new Step(new Tile(3210, 3415, 0))
        )));

        new TwoWayLink(ClothesStore, SouthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3210, 3415, 0))
        )));

        new OneWayLink(EastBank, EastBankUpstairs, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3254, 3421, 0)),
                new Obstacle(11789, "Climb-up", new Tile(3256, 3422, 0)),
                new Step(new Tile(3254, 3421, 1))
        )));

        new OneWayLink(EastBankUpstairs, EastBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3254, 3421, 1)),
                new Obstacle(11793, "Climb-down", new Tile(3256, 3422, 1)),
                new Step(new Tile(3254, 3421, 0))
        )));

        new TwoWayLink(EastBank, EastGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3255, 3427, 0))
        )));

        new TwoWayLink(EastBank, NorthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3254, 3421, 0)),
                new Step(new Tile(3254, 3428, 0)),
                new Step(new Tile(3246, 3429, 0)),
                new Step(new Tile(3245, 3499, 0))
        )));

        new TwoWayLink(EastGate, LumberYard, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3274, 3427, 0)),
                new Step(new Tile(3283, 3428, 0)),
                new Step(new Tile(3288, 3437, 0)),
                new Step(new Tile(3287, 3457, 0)),
                new Step(new Tile(3296, 3473, 0)),
                new Step(new Tile(3306, 3490, 0))
        )));

        new TwoWayLink(EastGate, MembersGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3273, 3429, 0)),
                new Step(new Tile(3283, 3429, 0)),
                new Step(new Tile(3287, 3438, 0)),
                new Step(new Tile(3288, 3458, 0)),
                new Step(new Tile(3304, 3461, 0)),
                new Step(new Tile(3318, 3467, 0))
        )));

        new TwoWayLink(EastGate, SouthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3272, 3428, 0)),
                new Step(new Tile(3276, 3428, 0)),
                new Step(new Tile(3290, 3409, 0)),
                new Step(new Tile(3294, 3378, 0)),
                new Step(new Tile(3286, 3370, 0))
        )));

        new TwoWayLink(Fountain, EastGate);

        new TwoWayLink(Fountain, EastBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3253, 3428, 0))
        )));

        new TwoWayLink(Fountain, HorviksArmoury, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3213, 3428, 0)),
                new Step(new Tile(3230, 3429, 0)),
                new Step(new Tile(3230, 3435, 0))
        )));

        new TwoWayLink(Fountain, SouthGate);

        new TwoWayLink(Fountain, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3183, 3429, 0))
        )));

        new TwoWayLink(GertrudesBedroom, GertrudesHouse, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3154, 3405, 0)),
                new Obstacle(11780, "Open", new Tile(3154, 3405, 0)),
                new Step(new Tile(3153, 3405, 0))
        )));

        new TwoWayLink(GertrudesHouse, WestGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3152, 3411, 0)),
                new Obstacle(11775, "Open", new Tile(3151, 3412, 0)),
                new Step(new Tile(3151, 3416, 0)),
                new Step(new Tile(3159, 3418, 0)),
                new Step(new Tile(3168, 3427, 0)),
                new Step(new Tile(3173, 3427, 0))
        )));

        new TwoWayLink(GrandExchange, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3166, 3461, 0)),
                new Step(new Tile(3183, 3448, 0))
        )));

         new TwoWayLink(GrandExchange, WestGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3164, 3484, 0)),
                new Step(new Tile(3165, 3465, 0)),
                new Step(new Tile(3176, 3445, 0)),
                new Step(new Tile(3175, 3430, 0))
        )));

        new TwoWayLink(LimeStoneMine, MembersGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3371, 3499, 0)),
                new Step(new Tile(3369, 3494, 0)),
                new Step(new Tile(3373, 3488, 0)),
                new Step(new Tile(3359, 3483, 0)),
                new Step(new Tile(3332, 3475, 0)),
                new Step(new Tile(3326, 3467, 0)),
                new Step(new Tile(3321, 3467, 0)),
                new Obstacle(11766, "Open", new Tile(3319, 3468, 0), new int[]{112, 160, -128, 0, 0, 128}),
                new Obstacle(11767, "Open", new Tile(3319, 3467, 0), new int[]{112, 160, -128, 0, 0, 128}),
                new Step(new Tile(3319, 3467, 0))
        )));

        new TwoWayLink(NorthGate, VarrockCastle.Crossroads, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3245, 3500, 0)),
                new Step(new Tile(3246, 3465, 0)),
                new Step(new Tile(3232, 3464, 0)),
                new Step(new Tile(3232, 3456, 0)),
                new Step(new Tile(3213, 3448, 0))
        )));

        new TwoWayLink(RiverDigSpot, SouthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3165, 3359, 0)),
                new Step(new Tile(3179, 3361, 0)),
                new Step(new Tile(3191, 3368, 0)),
                new Step(new Tile(3211, 3376, 0)),
                new Step(new Tile(3211, 3382, 0))
        )));

        new TwoWayLink(RiverDigSpot, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3165, 3358, 0)),
                new Step(new Tile(3173, 3377, 0)),
                new Step(new Tile(3171, 3424, 0)),
                new Step(new Tile(3173, 3427, 0))
        )));

        new OneWayLink(WestBank, WestBankBasement, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3184, 3434, 0)),
                new Obstacle(11775, "Open", new Tile(3186, 3434, 0), new int[]{-16, 32, -196, 0, 16, 128}),
                new Step(new Tile(3186, 3434, 0)),
                new Obstacle(11800, "Climb-down", new Tile(3188, 3434, 0), new int[]{-128, 128, -64, 0, -64, 64}),
                new Step(new Tile(3190, 9834, 0)),
                new Step(new Tile(3191, 9829, 0))
        )));

        new OneWayLink(WestBankBasement, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3191, 9829, 0)),
                new Step(new Tile(3190, 9834, 0)),
                new Obstacle(11805, "Climb-up", new Tile(3188, 9834, 0), new int[]{-128, 128, -64, 0, -64, 64}),
                new Step(new Tile(3186, 3434, 0)),
                new Obstacle(11775, "Open", new Tile(3186, 3434, 0), new int[]{-16, 32, -196, 0, 16, 128}),
                new Step(new Tile(3184, 3434, 0))
        )));

        new TwoWayLink(WestBankBasement, WestBankBasementClueSpot);

        new TwoWayLink(WestBank, WestGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3175, 3428, 0)),
                new Step(new Tile(3183, 3431, 0))
        )));

        new TwoWayLink(SouthGate, SouthGateHouse, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3211, 3382, 0)),
                new Step(new Tile(3208, 3385, 0)),
                new Obstacle(11777, "Open", new Tile(3208, 3385, 0)),
                new Step(new Tile(3207, 3385, 0))
        )));

        new TwoWayLink(SouthGate, SouthMine, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3211, 3381, 0)),
                new Step(new Tile(3213, 3378, 0)),
                new Step(new Tile(3237, 3379, 0)),
                new Step(new Tile(3242, 3373, 0)),
                new Step(new Tile(3285, 3371, 0))
        )));

        new TwoWayLink(SouthMine, SouthMineDigSpot);
    }
}