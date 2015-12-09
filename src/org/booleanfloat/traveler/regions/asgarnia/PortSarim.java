package org.booleanfloat.traveler.regions.asgarnia;

import org.booleanfloat.traveler.Config;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.karamja.MusaPoint;
import org.booleanfloat.traveler.regions.misthalin.Draynor;
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
    public static Location EntranaBoat;
    public static Location FishingStore;
    public static Location FoodStore;
    public static Location FoodStoreUpstairs;
    public static Location Jail;
    public static Location MudskipperPoint;
    public static Location MusaPointBoat;
    public static Location NorthHouse;
    public static Location RustyAnchor;
    public static Location ShantyPassCell;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(EntranaBoat);
        locations.add(FishingStore);
        locations.add(FoodStore);
        locations.add(FoodStoreUpstairs);
        locations.add(Jail);
        locations.add(MudskipperPoint);
        locations.add(MusaPointBoat);
        locations.add(NorthHouse);
        locations.add(RustyAnchor);
        locations.add(ShantyPassCell);

        return locations;
    }

    public static void initLocations() {
        EntranaBoat = new Location("PortSarim, EntranaBoat", new Area(
                new Tile(3052, 3237, 0),
                new Tile(3040, 3233, 0)
        ));

        FishingStore = new Location("PortSarim, FishingStore", new Area(
                new Tile(3018, 3229, 0),
                new Tile(3018, 3222, 0),
                new Tile(3015, 3219, 0),
                new Tile(3011, 3219, 0),
                new Tile(3011, 3229, 0)
        ));

        FoodStore = new Location("PortSarim, FoodStore", new Area(
                new Tile(3014, 3210, 0),
                new Tile(3017, 3207, 0),
                new Tile(3017, 3201, 0),
                new Tile(3012, 3201, 0),
                new Tile(3012, 3210, 0)
        ));

        FoodStoreUpstairs = new Location("PortSarim, FoodStoreUpstairs", new Area(
                new Tile(3014, 3210, 1),
                new Tile(3017, 3207, 1),
                new Tile(3017, 3201, 1),
                new Tile(3008, 3201, 1),
                new Tile(3008, 3210, 1)
        ));

        Jail = new Location("PortSarim, Jail", new Area(
                new Tile(3017, 3196, 0),
                new Tile(3017, 3190, 0),
                new Tile(3021, 3190, 0),
                new Tile(3021, 3181, 0),
                new Tile(3010, 3181, 0),
                new Tile(3010, 3196, 0)
        ));

        MudskipperPoint = new Location("PortSarim, MudskipperPoint", new Area(
                new Tile(3000, 3129, 0),
                new Tile(3006, 3127, 0),
                new Tile(3008, 3113, 0),
                new Tile(3004, 3106, 0),
                new Tile(2990, 3103, 0),
                new Tile(2980, 3105, 0),
                new Tile(2980, 3110, 0),
                new Tile(2981, 3121, 0),
                new Tile(2991, 3129, 0)
        ));

        MusaPointBoat = new Location("PortSarim, MusaPointBoat", new Area(
                new Tile(3029, 3222, 0),
                new Tile(3027, 3212, 0)
        ));

        NorthHouse = new Location("PortSarim, NorthHouse", new Area(
                new Tile(3030, 3261, 0),
                new Tile(3023, 3258, 0)
        ));

        RustyAnchor = new Location("PortSarim, RustyAnchor", new Area(
                new Tile(3055, 3258, 0),
                new Tile(3044, 3254, 0)
        ));

        ShantyPassCell = new Location("PortSarim, ShantyPassCell", new Area(
                new Tile(3016, 3182, 0),
                new Tile(3013, 3179, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(EntranaBoat, MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3048, 3235, 0)),
                new Step(new Tile(3027, 3235, 0)),
                new Step(new Tile(3028, 3218, 0))
        )));

        new TwoWayLink(EntranaBoat, NorthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3043, 3235, 0)),
                new Step(new Tile(3041, 3255, 0)),
                new Step(new Tile(3026, 3256, 0)),
                new Obstacle(7122, "Open", new Tile(3028, 3258, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3026, 3259, 0))
        )));

        new TwoWayLink(EntranaBoat, RustyAnchor, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3042, 3235, 0)),
                new Step(new Tile(3042, 3247, 0)),
                new Step(new Tile(3053, 3247, 0)),
                new Step(new Tile(3053, 3252, 0)),
                new Obstacle(7122, "Open", new Tile(3053, 3254, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3053, 3255, 0))
        )));

        new TwoWayLink(EntranaBoat, Draynor.WestFenceOpening, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3047, 3235, 0)),
                new Step(new Tile(3042, 3235, 0)),
                new Step(new Tile(3042, 3247, 0)),
                new Step(new Tile(3053, 3247, 0)),
                new Step(new Tile(3053, 3252, 0)),
                new Step(new Tile(3058, 3252, 0)),
                new Step(new Tile(3065, 3256, 0)),
                new Step(new Tile(3066, 3265, 0)),
                new Step(new Tile(3068, 3275, 0)),
                new Step(new Tile(3069, 3276, 0))
        )));

        new TwoWayLink(FishingStore, MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3014, 3221, 0)),
                new Obstacle(7122, "Open", new Tile(3014, 3219, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3014, 3217, 0)),
                new Step(new Tile(3028, 3217, 0))
        )));

        new TwoWayLink(FishingStore, Rimmington.Mine, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3014, 3220, 0)),
                new Obstacle(7122, "Open", new Tile(3014, 3219, 0), Obstacle.Hitbox.DOOR_NORTH),
                new Step(new Tile(3014, 3217, 0)),
                new Step(new Tile(3006, 3218, 0)),
                new Step(new Tile(2989, 3231, 0)),
                new Step(new Tile(2986, 3233, 0))
        )));

        new OneWayLink(FoodStore, FoodStoreUpstairs, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3014, 3204, 0)),
                new Obstacle(16683, "Climb-up", new Tile(3013, 3203, 0))
        )));

        new TwoWayLink(FoodStore, MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3015, 3204, 0)),
                new Obstacle(7122, "Open", new Tile(3016, 3206, 0), Obstacle.Hitbox.DOOR_EAST),
                new Step(new Tile(3018, 3204, 0)),
                new Step(new Tile(3028, 3209, 0)),
                new Step(new Tile(3028, 3214, 0))
        )));

        new OneWayLink(FoodStoreUpstairs, FoodStore, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3013, 3204, 1)),
                new Obstacle(16679, "Climb-down", new Tile(3013, 3203, 1))
        )));

        new TwoWayLink(Jail, MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3011, 3191, 0)),
                new Obstacle(7122, "Open", new Tile(3011, 3197, 0), Obstacle.Hitbox.DOOR_SOUTH),
                new Step(new Tile(3012, 3198, 0)),
                new Step(new Tile(3017, 3201, 0)),
                new Step(new Tile(3028, 3210, 0)),
                new Step(new Tile(3028, 3214, 0))
        )));

        new TwoWayLink(MudskipperPoint, MusaPointBoat, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2999, 3124, 0)),
                new Step(new Tile(3000, 3135, 0)),
                new Step(new Tile(2997, 3142, 0)),
                new Step(new Tile(2997, 3152, 0)),
                new Step(new Tile(3003, 3167, 0)),
                new Step(new Tile(3008, 3183, 0)),
                new Step(new Tile(3008, 3199, 0)),
                new Step(new Tile(3018, 3200, 0)),
                new Step(new Tile(3018, 3203, 0)),
                new Step(new Tile(3028, 3207, 0)),
                new Step(new Tile(3028, 3214, 0))
        )));

        new TwoWayLink(MudskipperPoint, Rimmington.POHPortal, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2999, 3125, 0)),
                new Step(new Tile(3002, 3140, 0)),
                new Step(new Tile(3002, 3156, 0)),
                new Step(new Tile(2992, 3171, 0)),
                new Step(new Tile(2989, 3183, 0)),
                new Step(new Tile(2987, 3195, 0)),
                new Step(new Tile(2974, 3199, 0)),
                new Step(new Tile(2963, 3199, 0)),
                new Step(new Tile(2962, 3206, 0)),
                new Step(new Tile(2959, 3212, 0)),
                new Step(new Tile(2956, 3223, 0))
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

        new TwoWayLink(RustyAnchor, Draynor.WestFenceOpening, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3053, 3257, 0)),
                new Obstacle(7122, "Open", new Tile(3053, 3260, 0), Obstacle.Hitbox.DOOR_SOUTH),
                new Step(new Tile(3053, 3260, 0)),
                new Step(new Tile(3069, 3277, 0))
        )));

        new OneWayLink(ShantyPassCell, Jail, new ArrayList<>(Arrays.asList(
                new Obstacle(9565, "Pick-lock", new Tile(3014, 3182, 0), new int[]{0, 128, -192, 0, -16, 32})
        )));
    }
}
