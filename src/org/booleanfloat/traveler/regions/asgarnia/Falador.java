package org.booleanfloat.traveler.regions.asgarnia;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.Resources;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TeleportLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.misthalin.Draynor;
import org.booleanfloat.traveler.regions.misthalin.Edgeville;
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

public class Falador implements Region {
    public static Location Barber;
    public static Location CastleCourtyard;
    public static Location CastleThroneRoom;
    public static Location ChainMailStore;
    public static Location DoricsHouse;
    public static Location DoricsHouseCrossRoads;
    public static Location DwarvenMineEntrance;
    public static Location EastBank;
    public static Location EastBankHouse;
    public static Location EastHouseUpstairs;
    public static Location Farm;
    public static Location GemStore;
    public static Location GeneralStore;
    public static Location NorthFencedStones;
    public static Location NorthGate;
    public static Location NorthSquare;
    public static Location PartyRoom;
    public static Location PartyRoomSouthHouseUpstairs;
    public static Location PartyRoomUpstairs;
    public static Location Rusty;
    public static Location ShieldStore;
    public static Location ShieldStoreUpstairs;
    public static Location SouthCrossRoads;
    public static Location SouthGate;
    public static Location Square;
    public static Location WestBank;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(Barber);
        locations.add(CastleCourtyard);
        locations.add(CastleThroneRoom);
        locations.add(ChainMailStore);
        locations.add(DoricsHouse);
        locations.add(DoricsHouseCrossRoads);
        locations.add(DwarvenMineEntrance);
        locations.add(EastBank);
        locations.add(EastBankHouse);
        locations.add(EastHouseUpstairs);
        locations.add(Farm);
        locations.add(GemStore);
        locations.add(GeneralStore);
        locations.add(NorthFencedStones);
        locations.add(NorthGate);
        locations.add(NorthSquare);
        locations.add(PartyRoom);
        locations.add(PartyRoomSouthHouseUpstairs);
        locations.add(PartyRoomUpstairs);
        locations.add(Rusty);
        locations.add(ShieldStore);
        locations.add(ShieldStoreUpstairs);
        locations.add(SouthCrossRoads);
        locations.add(SouthGate);
        locations.add(Square);
        locations.add(WestBank);

        return locations;
    }

    public static void initLocations() {
        Barber = new Location("Falador, Barber", new Area(
                new Tile(2946, 3385, 0),
                new Tile(2946, 3381, 0),
                new Tile(2949, 3381, 0),
                new Tile(2949, 3377, 0),
                new Tile(2947, 3376, 0),
                new Tile(2943, 3376, 0),
                new Tile(2942, 3377, 0),
                new Tile(2942, 3385, 0)
        ));

        CastleCourtyard = new Location("Falador, CastleCourtyard", new Area(
                new Tile(2980, 3347, 0),
                new Tile(2966, 3336, 0)
        ));

        CastleThroneRoom = new Location("Falador, CastleThroneRoom", new Area(
                new Tile(2986, 3344, 1),
                new Tile(2979, 3332, 1)
        ));

        ChainMailStore = new Location("Falador, ChainMailStore", new Area(
                new Tile(2975, 3314, 0),
                new Tile(2969, 3309, 0)
        ));

        DoricsHouse = new Location("Falador, DoricsHouse", new Area(
                new Tile(2954, 3454, 0),
                new Tile(2950, 3448, 0)
        ));

        DoricsHouseCrossRoads = new Location("Falador, DoricsHouseCrossRoads", new Area(
                new Tile(2949, 3452, 0),
                new Tile(2945, 3448, 0)
        ));

        DwarvenMineEntrance = new Location("Falador, DwarvenMineEntrance", new Area(
                new Tile(3063, 3377, 0),
                new Tile(3060, 3374, 0)
        ));

        EastBank = new Location("Falador, EastBank", new Area(
                new Tile(3015, 3357, 0),
                new Tile(3009, 3354, 0)
        ));

        EastBankHouse = new Location("Falador, EastBankHouse", new Area(
                new Tile(3030, 3355, 0),
                new Tile(3026, 3351, 0)
        ));

        EastHouseUpstairs = new Location("Falador, EastHouseUpstairs", new Area(
                new Tile(3041, 3348, 1),
                new Tile(3035, 3341, 1)
        ));

        Farm = new Location("Falador, Farm", new Area(
                new Tile(3041, 3296, 0),
                new Tile(3041, 3288, 0),
                new Tile(3038, 3288, 0),
                new Tile(3037, 3290, 0),
                new Tile(3030, 3290, 0),
                new Tile(3030, 3296, 0)
        ));

        GemStore = new Location("Falador, GemStore", new Area(
                new Tile(2947, 3337, 0),
                new Tile(2944, 3331, 0)
        ));

        GeneralStore = new Location("Falador, GeneralStore", new Area(
                new Tile(2961, 3390, 0),
                new Tile(2961, 3384, 0),
                new Tile(2956, 3384, 0),
                new Tile(2956, 3386, 0),
                new Tile(2953, 3386, 0),
                new Tile(2953, 3390, 0)
        ));

        NorthFencedStones = new Location("Falador, NorthFencedStones", new Area(
                new Tile(3046, 3400, 0),
                new Tile(3033, 3394, 0)
        ));

        NorthGate = new Location("Falador, NorthGate", new Area(
                new Tile(2968, 3395, 0),
                new Tile(2963, 3391, 0)
        ));

        NorthSquare = new Location("Falador, NorthSquare", new Area(
                new Tile(2973, 3417, 0),
                new Tile(2964, 3409, 0)
        ));

        PartyRoom = new Location("Falador, PartyRoom", new Area(
                new Tile(3055, 3384, 0),
                new Tile(3037, 3371, 0)
        ));

        PartyRoomSouthHouseUpstairs = new Location("Falador, PartyRoomSouthHouseUpstairs", new Area(
                new Tile(3042, 3364, 1),
                new Tile(3034, 3359, 1)
        ));

        PartyRoomUpstairs = new Location("Falador, PartyRoomUpstairs", new Area(
                new Tile(3055, 3384, 1),
                new Tile(3037, 3371, 1)
        ));

        Rusty = new Location("Falador, Rusty", new Area(
                new Tile(2987, 3444, 0),
                new Tile(2989, 3440, 0),
                new Tile(2994, 3436, 0),
                new Tile(2990, 3431, 0),
                new Tile(2985, 3426, 0),
                new Tile(2980, 3430, 0),
                new Tile(2975, 3434, 0),
                new Tile(2978, 3441, 0)
        ));

        ShieldStore = new Location("Falador, ShieldStore", new Area(
                new Tile(2975, 3386, 0),
                new Tile(2975, 3384, 0),
                new Tile(2980, 3384, 0),
                new Tile(2980, 3380, 0),
                new Tile(2972, 3380, 0),
                new Tile(2972, 3386, 0)
        ));

        ShieldStoreUpstairs = new Location("Falador, ShieldStoreUpstairs", new Area(
                new Tile(2975, 3386, 1),
                new Tile(2975, 3384, 1),
                new Tile(2980, 3384, 1),
                new Tile(2980, 3380, 1),
                new Tile(2972, 3380, 1),
                new Tile(2972, 3386, 1)
        ));

        SouthCrossRoads = new Location("Falador, SouthCrossRoads", new Area(
                new Tile(3010, 3281, 0),
                new Tile(3005, 3276, 0)
        ));

        SouthGate = new Location("Falador, SouthGate", new Area(
                new Tile(3010, 3324, 0),
                new Tile(3005, 3320, 0)
        ));

        Square = new Location("Falador, Square", new Area(
                new Tile(2969, 3383, 0),
                new Tile(2962, 3376, 0)
        ));

        WestBank = new Location("Falador, WestBank", new Area(
                new Tile(2947, 3372, 0),
                new Tile(2943, 3368, 0)
        ));
    }

    public static void initLinks(final ClientContext ctx) {
        new TeleportLink(Square, Magic.Spell.FALADOR_TELEPORT, new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return  ctx.skills.realLevel(Constants.SKILLS_MAGIC) >= 37
                        && ctx.inventory.select().id(Resources.WATER_RUNE_ID).poll().stackSize() > 1
                        && ctx.inventory.select().id(Resources.AIR_RUNE_ID).poll().stackSize() > 3
                        && ctx.inventory.select().id(Resources.LAW_RUNE_ID).poll().stackSize() > 1;
            }
        });

        new TwoWayLink(Barber, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2946, 3379, 0)),
                new Obstacle(24050, "Open", new Tile(2949, 3379, 0)),
                new Step(new Tile(2950, 3379, 0)),
                new Step(new Tile(2951, 3375, 0)),
                new Step(new Tile(2946, 3375, 0)),
                new Step(new Tile(2945, 3370, 0))
        )));

        new TwoWayLink(Barber, Square, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2945, 3379, 0)),
                new Obstacle(24050, "Open", new Tile(2949, 3379, 0)),
                new Step(new Tile(2951, 3379, 0)),
                new Step(new Tile(2965, 3380, 0))
        )));

        new TwoWayLink(CastleCourtyard, Square, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2971, 3341, 0)),
                new Step(new Tile(2965, 3345, 0)),
                new Step(new Tile(2964, 3379, 0))
        )));

        new OneWayLink(CastleCourtyard, CastleThroneRoom, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2981, 3341, 0)),
                new Obstacle(24059, "Open", new Tile(2981, 3341, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Obstacle(24064, "Open", new Tile(2981, 3340, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2985, 3341, 0)),
                new Obstacle(24057, "Open", new Tile(2985, 3341, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2990, 3341, 0)),
                new Obstacle(24057, "Open", new Tile(2991, 3341, 0), new int[]{-32, 32, -192, 0, 0, 128}),
                new Step(new Tile(2993, 3341, 0)),
                new Obstacle(24070, "Climb-up", new Tile(2994, 3341, 0)),
                new Step(new Tile(2991, 3341, 1)),
                new Obstacle(24057, "Open", new Tile(2991, 3341, 1), new int[]{-32, 32, -192, 0, 0, 128}),
                new Step(new Tile(2983, 3341, 1))
        )));

        new OneWayLink(CastleThroneRoom, CastleCourtyard, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2983, 3341, 1)),
                new Obstacle(24057, "Open", new Tile(2991, 3341, 1), new int[]{-32, 32, -192, 0, 0, 128}),
                new Step(new Tile(2991, 3341, 1)),
                new Obstacle(24071, "Climb-down", new Tile(2994, 3341, 0)),
                new Step(new Tile(2993, 3341, 0)),
                new Obstacle(24057, "Open", new Tile(2991, 3341, 0), new int[]{-32, 32, -192, 0, 0, 128}),
                new Step(new Tile(2990, 3341, 0)),
                new Obstacle(24057, "Open", new Tile(2985, 3341, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2985, 3341, 0)),
                new Obstacle(24064, "Open", new Tile(2981, 3340, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Obstacle(24059, "Open", new Tile(2981, 3341, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2981, 3341, 0))
        )));

        new TwoWayLink(ChainMailStore, SouthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2972, 3312, 0)),
                new Obstacle(23972, "Open", new Tile(2972, 3315, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(2972, 3315, 0)),
                new Step(new Tile(2978, 3317, 0)),
                new Step(new Tile(2990, 3318, 0)),
                new Step(new Tile(3000, 3325, 0)),
                new Step(new Tile(3006, 3324, 0))
        )));

        new TwoWayLink(ChainMailStore, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2971, 3312, 0)),
                new Obstacle(23972, "Open", new Tile(2972, 3315, 0), new int[]{0, 128, -192, 0, -16, 32}),
                new Step(new Tile(2971, 3316, 0)),
                new Step(new Tile(2964, 3316, 0)),
                new Step(new Tile(2956, 3319, 0)),
                new Step(new Tile(2949, 3329, 0)),
                new Step(new Tile(2948, 3335, 0)),
                new Step(new Tile(2946, 3343, 0)),
                new Step(new Tile(2949, 3353, 0)),
                new Step(new Tile(2951, 3366, 0)),
                new Step(new Tile(2950, 3374, 0)),
                new Step(new Tile(2945, 3375, 0)),
                new Step(new Tile(2946, 3371, 0))
        )));

        new TwoWayLink(DoricsHouse, DoricsHouseCrossRoads, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2951, 3450, 0)),
                new Obstacle(7122, "Open", new Tile(2949, 3450, 0), new int[]{112, 128, -196, 0, 0, 100}),
                new Step(new Tile(2948, 3450, 0))
        )));

        new TwoWayLink(DoricsHouseCrossRoads, NorthSquare, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2947, 3450, 0)),
                new Step(new Tile(2951, 3423, 0)),
                new Step(new Tile(2966, 3413, 0))
        )));

        new TwoWayLink(DoricsHouseCrossRoads, Taverly.MembersGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2945, 3451, 0)),
                new Step(new Tile(2936, 3450, 0)),
                new Obstacle(7168, "Open", new Tile(2935, 3451, 0), new int[]{112, 128, -196, 0, 0, 100}),
                new Obstacle(7169, "Open", new Tile(2935, 3451, 0), new int[]{112, 128, -196, 0, 0, 100}),
                new Obstacle(7407, "Open", new Tile(2935, 3451, 0), new int[]{112, 128, -196, 0, 0, 100}),
                new Obstacle(7408, "Open", new Tile(2935, 3451, 0), new int[]{112, 128, -196, 0, 0, 100}),
                new Step(new Tile(2934, 3450, 0))
        )));

        new TwoWayLink(DwarvenMineEntrance, EastBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3061, 3376, 0)),
                new Obstacle(24057, "Open", new Tile(3061, 3374, 0), new int[]{0, 128, -192, 0, 96, 144}),
                new Step(new Tile(3062, 3372, 0)),
                new Step(new Tile(3056, 3368, 0)),
                new Step(new Tile(3033, 3368, 0)),
                new Step(new Tile(3013, 3359, 0)),
                new Step(new Tile(3013, 3356, 0))
        )));

        new OneWayLink(DwarvenMineEntrance, DwarvenMine.ScorpionPit, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3061, 3377, 0)),
                new Obstacle(16664, "Climb-down", new Tile(3059, 3377, 0)),
                new Step(new Tile(3058, 9776, 0))
        )));

        new TwoWayLink(EastBank, EastBankHouse, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3012, 3356, 0)),
                new Step(new Tile(3013, 3360, 0)),
                new Step(new Tile(3028, 3357, 0)),
                new Obstacle(24050, "Open", new Tile(3028, 3356, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(3028, 3354, 0))
        )));

        new OneWayLink(EastBank, EastHouseUpstairs, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3012, 3357, 0)),
                new Step(new Tile(3013, 3360, 0)),
                new Step(new Tile(3026, 3360, 0)),
                new Step(new Tile(3035, 3353, 0)),
                new Step(new Tile(3037, 3347, 0)),
                new Obstacle(24050, "Open", new Tile(3037, 3347, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(3038, 3344, 0)),
                new Obstacle(24082, "Climb-up", new Tile(3035, 3344, 0), new int[]{-32, 32, -196, 0, -64, 0}),
                new Step(new Tile(3037, 3346, 1))
        )));

        new OneWayLink(EastHouseUpstairs, EastBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3037, 3346, 1)),
                new Obstacle(24085, "Climb-down", new Tile(3035, 3344, 1), new int[]{-48, 64, -64, 0, -48, 64}),
                new Step(new Tile(3038, 3344, 0)),
                new Obstacle(24050, "Open", new Tile(3037, 3347, 0), new int[]{0, 128, -196, 0, -32, 32}),
                new Step(new Tile(3037, 3347, 0)),
                new Step(new Tile(3035, 3353, 0)),
                new Step(new Tile(3026, 3360, 0)),
                new Step(new Tile(3013, 3360, 0)),
                new Step(new Tile(3012, 3357, 0))
        )));

        new TwoWayLink(EastBank, PartyRoom, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3013, 3356, 0)),
                new Step(new Tile(3013, 3360, 0)),
                new Step(new Tile(3033, 3368, 0)),
                new Step(new Tile(3046, 3368, 0)),
                new Obstacle(24059, "Open", new Tile(3045, 3371, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Obstacle(24064, "Open", new Tile(3046, 3371, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Step(new Tile(3046, 3374, 0))
        )));

        new OneWayLink(EastBank, PartyRoomSouthHouseUpstairs, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3013, 3356, 0)),
                new Step(new Tile(3012, 3359, 0)),
                new Step(new Tile(3039, 3360, 0)),
                new Obstacle(24050, "Open", new Tile(3038, 3361, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3039, 3362, 0)),
                new Obstacle(24075, "Climb-up", new Tile(3035, 3364, 0))
        )));

        new TwoWayLink(EastBank, SouthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3013, 3359, 0)),
                new Step(new Tile(3006, 3359, 0)),
                new Step(new Tile(3007, 3323, 0))
        )));

        new TwoWayLink(EastBank, Square, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3013, 3361, 0)),
                new Step(new Tile(2979, 3377, 0)),
                new Step(new Tile(2966, 3379, 0))
        )));

        new TwoWayLink(Farm, SouthCrossRoads, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3034, 3292, 0)),
                new Obstacle(8695, "Open", new Tile(3034, 3291, 0), Obstacle.Hitbox.DOOR_SOUTH),
                new Step(new Tile(3034, 3289, 0)),
                new Step(new Tile(3034, 3278, 0)),
                new Step(new Tile(3008, 3278, 0))
        )));

        new TwoWayLink(Farm, SouthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3039, 3295, 0)),
                new Obstacle(8695, "Open", new Tile(3039, 3297, 0), Obstacle.Hitbox.DOOR_SOUTH),
                new Step(new Tile(3039, 3297, 0)),
                new Step(new Tile(3032, 3312, 0)),
                new Obstacle(7161, "Open", new Tile(3031, 3313, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Obstacle(7162, "Open", new Tile(3032, 3313, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3032, 3314, 0)),
                new Step(new Tile(3008, 3321, 0))
        )));

        new TwoWayLink(Farm, Draynor.WestFenceOpening, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3034, 3291, 0)),
                new Obstacle(8695, "Open", new Tile(3034, 3291, 0), Obstacle.Hitbox.DOOR_SOUTH),
                new Step(new Tile(3034, 3289, 0)),
                new Step(new Tile(3033, 3277, 0)),
                new Step(new Tile(3070, 3276, 0))
        )));

        new TwoWayLink(GemStore, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2945, 3335, 0)),
                new Obstacle(24050, "Open", new Tile(2945, 3338, 0)),
                new Step(new Tile(2945, 3338, 0)),
                new Step(new Tile(2950, 3354, 0)),
                new Step(new Tile(2951, 3366, 0)),
                new Step(new Tile(2951, 3374, 0)),
                new Step(new Tile(2945, 3375, 0)),
                new Step(new Tile(2945, 3371, 0))
        )));

        new TwoWayLink(GeneralStore, Square, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2958, 3385, 0)),
                new Obstacle(24056, "Open", new Tile(2958, 3384, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Step(new Tile(2958, 3382, 0)),
                new Step(new Tile(2963, 3380, 0))
        )));

        new TwoWayLink(GeneralStore, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2959, 3387, 0)),
                new Obstacle(24056, "Open", new Tile(2958, 3384, 0), new int[]{0, 128, -192, 0, 96, 128}),
                new Step(new Tile(2958, 3381, 0)),
                new Step(new Tile(2951, 3379, 0)),
                new Step(new Tile(2950, 3375, 0)),
                new Step(new Tile(2946, 3374, 0)),
                new Step(new Tile(2946, 3371, 0))
        )));

        new TwoWayLink(NorthFencedStones, NorthGate, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3040, 3398, 0)),
                new Step(new Tile(3034, 3401, 0)),
                new Step(new Tile(3034, 3404, 0)),
                new Step(new Tile(2966, 3394, 0))
        )));

        new TwoWayLink(NorthGate, NorthSquare);
        new TwoWayLink(NorthGate, Square);

        new TwoWayLink(NorthSquare, Rusty, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2971, 3414, 0)),
                new Step(new Tile(2987, 3419, 0)),
                new Step(new Tile(2988, 3427, 0)),
                new Step(new Tile(2983, 3436, 0))
        )));

        new TwoWayLink(NorthSquare, Edgeville.Monastery, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2971, 3414, 0)),
                new Step(new Tile(2987, 3419, 0)),
                new Step(new Tile(2988, 3428, 0)),
                new Step(new Tile(3022, 3432, 0)),
                new Step(new Tile(3038, 3446, 0)),
                new Step(new Tile(3050, 3463, 0)),
                new Step(new Tile(3052, 3468, 0)),
                new Step(new Tile(3051, 3487, 0))
        )));

        new OneWayLink(PartyRoom, PartyRoomUpstairs, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3053, 3382, 0)),
                new Obstacle(24249, "Climb-up", new Tile(3054, 3384, 0)),
                new Step(new Tile(3053, 3382, 1))
        )));

        new OneWayLink(PartyRoomSouthHouseUpstairs, EastBank, new ArrayList<Traversable>(Arrays.asList(
                new Obstacle(24076, "Climb-down", new Tile(3035, 3363, 1)),
                new Step(new Tile(3039, 3362, 0)),
                new Obstacle(24050, "Open", new Tile(3038, 3361, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3039, 3360, 0)),
                new Step(new Tile(3012, 3359, 0)),
                new Step(new Tile(3013, 3356, 0))
        )));

        new OneWayLink(PartyRoomUpstairs, PartyRoom, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3053, 3382, 1)),
                new Obstacle(24254, "Climb-down", new Tile(3054, 3384, 1)),
                new Step(new Tile(3053, 3382, 0))
        )));

        new TwoWayLink(ShieldStore, Square, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2973, 3382, 0)),
                new Obstacle(24050, "Open", new Tile(2971, 3383, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2971, 3382, 0)),
                new Step(new Tile(2967, 3381, 0))
        )));

        new OneWayLink(Square, ShieldStoreUpstairs, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2967, 3381, 0)),
                new Step(new Tile(2971, 3382, 0)),
                new Obstacle(24050, "Open", new Tile(2971, 3383, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2972, 3385, 0)),
                new Obstacle(24075, "Climb-up", new Tile(2974, 3385, 0)),
                new Step(new Tile(2972, 3385, 1))
        )));

        new OneWayLink(ShieldStore, Square, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2972, 3385, 1)),
                new Obstacle(24076, "Climb-down", new Tile(2974, 3385, 1)),
                new Step(new Tile(2972, 3385, 0)),
                new Obstacle(24050, "Open", new Tile(2971, 3383, 0), new int[]{96, 128, -192, 0, 0, 128}),
                new Step(new Tile(2971, 3382, 0)),
                new Step(new Tile(2967, 3381, 0))
        )));

        new TwoWayLink(SouthCrossRoads, SouthGate);

        new TwoWayLink(SouthCrossRoads, PortSarim.MusaPointBoat, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3007, 3278, 0)),
                new Step(new Tile(3018, 3261, 0)),
                new Step(new Tile(3019, 3245, 0)),
                new Step(new Tile(3028, 3239, 0)),
                new Step(new Tile(3028, 3216, 0))
        )));

        new TwoWayLink(SouthCrossRoads, PortSarim.NorthHouse, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3007, 3279, 0)),
                new Step(new Tile(3019, 3260, 0)),
                new Step(new Tile(3020, 3255, 0)),
                new Step(new Tile(3026, 3256, 0)),
                new Obstacle(7122, "Open", new Tile(3028, 3258, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3026, 3259, 0))
        )));

        new TwoWayLink(SouthCrossRoads, Rimmington.NorthCrossRoads, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3007, 3279, 0)),
                new Step(new Tile(3000, 3277, 0)),
                new Step(new Tile(2982, 3277, 0))
        )));

        new TwoWayLink(SouthGate, Square, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3007, 3323, 0)),
                new Step(new Tile(3006, 3362, 0)),
                new Step(new Tile(2966, 3381, 0))
        )));

        new TwoWayLink(Square, WestBank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(2964, 3380, 0)),
                new Step(new Tile(2953, 3379, 0)),
                new Step(new Tile(2945, 3373, 0))
        )));
    }
}
