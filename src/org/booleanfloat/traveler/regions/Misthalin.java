package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.OneWayLink;
import org.booleanfloat.traveler.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Misthalin {
    public static Location HamEntrance;

    public static void initLocations() {
        Varrock.initLocations();
        Lumbridge.initLocations();

        HamEntrance = new Location("Misthalin, HamEntrance", new Area(
                new Tile(3166, 3251, 0),
                new Tile(3164, 3249, 0)
        ));
    }

    public static void initLinks() {
        Varrock.initLinks();
        Lumbridge.initLinks();

        new TwoWayLink(HamEntrance, Lumbridge.Castle.BackEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3167, 3247, 0)),
                new Step(new Tile(3197, 3218, 0))
        )));

        new TwoWayLink(Lumbridge.Center, Varrock.SouthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3234, 3218, 0)),
                new Step(new Tile(3234, 3225, 0)),
                new Step(new Tile(3258, 3225, 0)),
                new Step(new Tile(3252, 3254, 0)),
                new Step(new Tile(3239, 3283, 0)),
                new Step(new Tile(3238, 3306, 0)),
                new Step(new Tile(3226, 3309, 0)),
                new Step(new Tile(3205, 3343, 0)),
                new Step(new Tile(3211, 3380, 0))
        )));
    }

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(HamEntrance);
        locations.addAll(Varrock.getLocations());
        locations.addAll(Lumbridge.getLocations());

        return locations;
    }

    public static class Varrock {
        public static Location ClothesStore;
        public static Location EastBank;
        public static Location EastGate;
        public static Location Fountain;
        public static Location GrandExchange;
        public static Location SouthGate;
        public static Location WestBank;

        public static ArrayList<Location> getLocations() {
            ArrayList<Location> locations = new ArrayList<>();

            locations.add(ClothesStore);
            locations.add(EastBank);
            locations.add(EastGate);
            locations.add(Fountain);
            locations.add(GrandExchange);
            locations.add(SouthGate);
            locations.add(WestBank);
            locations.addAll(Castle.getLocations());

            return locations;
        }

        public static void initLocations() {
            Castle.initLocations();

            ClothesStore = new Location("Misthalin, Varrock, ClothesStore", new Area(
                    new Tile(3207, 3418, 0),
                    new Tile(3204, 3414, 0)
            ));

            EastBank = new Location("Misthalin, Varrock, EastBank", new Area(
                    new Tile(3254, 3422, 0),
                    new Tile(3250, 3420, 0)
            ));

            EastGate = new Location("Misthalin, Varrock, EastGate", new Area(
                    new Tile(3275, 3431, 0),
                    new Tile(3271, 3426, 0)
            ));

            Fountain = new Location("Misthalin, Varrock, Fountain", new Area(
                    new Tile(3216, 3432, 0),
                    new Tile(3209, 3425, 0)
            ));

            GrandExchange = new Location("Misthalin, Varrock, GrandExchange", new Area(
                    new Tile(3168, 3493, 0),
                    new Tile(3161, 3486, 0)
            ));

            SouthGate = new Location("Misthalin, Varrock, SouthGate", new Area(
                    new Tile(3213, 3382, 0),
                    new Tile(3210, 3380, 0)
            ));

            WestBank = new Location("Misthalin, Varrock, WestBank", new Area(
                    new Tile(3185, 3439, 0),
                    new Tile(3181, 3434, 0)
            ));
        }

        public static void initLinks() {
            Castle.initLinks();

            new TwoWayLink(ClothesStore, Fountain, new ArrayList<>(Arrays.asList(
                    new Obstacle(11775, "Open", new Tile(3209, 3415, 0)),
                    new Step(new Tile(3210, 3415, 0))
            )));

            new TwoWayLink(ClothesStore, SouthGate, new ArrayList<>(Arrays.asList(
                    new Step(new Tile(3210, 3415, 0))
            )));

            new TwoWayLink(EastBank, EastGate, new ArrayList<>(Arrays.asList(
                    new Step(new Tile(3255, 3427, 0))
            )));

            new TwoWayLink(Fountain, EastGate);

            new TwoWayLink(Fountain, EastBank, new ArrayList<>(Arrays.asList(
                    new Step(new Tile(3253, 3428, 0))
            )));

            new TwoWayLink(Fountain, SouthGate);

            new TwoWayLink(Fountain, WestBank, new ArrayList<>(Arrays.asList(
                    new Step(new Tile(3183, 3429, 0))
            )));

            new TwoWayLink(GrandExchange, WestBank, new ArrayList<>(Arrays.asList(
                    new Step(new Tile(3166, 3461, 0)),
                    new Step(new Tile(3183, 3448, 0))
            )));
        }

        public static class Castle {
            public static Location Courtyard;
            public static Location Entrance;
            public static Location TrainingRoom;

            public static ArrayList<Location> getLocations() {
                ArrayList<Location> locations = new ArrayList<>();

                locations.add(Courtyard);
                locations.add(Entrance);
                locations.add(TrainingRoom);

                return locations;
            }

            public static void initLocations() {
                Courtyard = new Location("Misthalin, Varrock, Castle, Courtyard", new Area(
                        new Tile(3214, 3449, 0),
                        new Tile(3211, 3448, 0)
                ));

                Entrance = new Location("Misthalin, Varrock, Castle, Entrance", new Area(
                        new Tile(3213, 3471, 0),
                        new Tile(3212, 3469, 0)
                ));

                TrainingRoom = new Location("Misthalin, Varrock, Castle, TraningRoom", new Area(
                        new Tile(3205, 3473, 1),
                        new Tile(3202, 3470, 1)
                ));
            }

            public static void initLinks() {
                new TwoWayLink(Courtyard, Entrance);
                new TwoWayLink(Courtyard, Fountain);

                new TwoWayLink(Courtyard, GrandExchange, new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3202, 3454, 0)),
                        new Step(new Tile(3197, 3462, 0)),
                        new Step(new Tile(3195, 3489, 0))
                )));

                new OneWayLink(Entrance, TrainingRoom, new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3212, 3472, 0)),
                        new Obstacle(11807, "Climb-up", new Tile(3213, 3474, 0)),
                        new Step(new Tile(3212, 3476, 1)),
                        new Step(new Tile(3207, 3473, 1)),
                        new Obstacle(11773, "Open", new Tile(3207, 3473, 1))
                )));

                new OneWayLink(TrainingRoom, Entrance, new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3207, 3473, 1)),
                        new Obstacle(11773, "Open", new Tile(3207, 3473, 1)),
                        new Step(new Tile(3212, 3476, 1)),
                        new Obstacle(11799, "Climb-down", new Tile(3213, 3475, 1)),
                        new Step(new Tile(3212, 3472, 0))
                )));
            }
        }
    }

    public static class Lumbridge {
        public static Location Center;
        public static Location Church;

        public static ArrayList<Location> getLocations() {
            ArrayList<Location> locations = new ArrayList<>();

            locations.add(Center);
            locations.add(Church);
            locations.addAll(Castle.getLocations());

            return locations;
        }

        public static void initLocations() {
            Castle.initLocations();

            Center = new Location("Misthalin, Lumbridge, Center", new Area(
                    new Tile(3237, 3220, 0),
                    new Tile(3234, 3217, 0)
            ));

            Church = new Location("Misthalin, Lumbridge, Church", new Area(
                    new Tile(3245, 3210, 0),
                    new Tile(3242, 3206, 0)
            ));
        }

        public static void initLinks() {
            Castle.initLinks();

            new TwoWayLink(Center, Church, new ArrayList<>(Arrays.asList(
                    new Step(new Tile(3235, 3210, 0)),
                    new Obstacle(7129, "Open", new Tile(3238, 3210, 0)),
                    new Step(new Tile(3242, 3210, 0))
            )));
        }

        public static class Castle {
            public static Location Bank;
            public static Location BackEntrance;
            public static Location Courtyard;

            public static ArrayList<Location> getLocations() {
                ArrayList<Location> locations = new ArrayList<>();

                locations.add(Bank);
                locations.add(BackEntrance);
                locations.add(Courtyard);

                return locations;
            }

            public static void initLocations() {
                Bank = new Location("Misthalin, Lumbridge, Castle, Bank", new Area(
                        new Tile(3210, 3220, 2),
                        new Tile(3207, 3218, 2)
                ));

                BackEntrance = new Location("Misthalin, Lumbridge, Castle, BackEntrance", new Area(
                        new Tile(3201, 3219, 0),
                        new Tile(3199, 3217, 0)
                ));

                Courtyard = new Location("Misthalin, Lumbridge, Castle, Courtyard", new Area(
                        new Tile(3224, 3220, 0),
                        new Tile(3221, 3217, 0)
                ));
            }

            public static void initLinks() {

                new TwoWayLink(BackEntrance, Lumbridge.Center, new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3202, 3218, 0)),
                        new Step(new Tile(3203, 3214, 0)),
                        new Step(new Tile(3212, 3210, 0)),
                        new Step(new Tile(3216, 3218, 0))
                )));

                new OneWayLink(BackEntrance, Bank,  new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3202, 3218, 0)),
                        new Step(new Tile(3203, 3214, 0)),
                        new Step(new Tile(3206, 3209, 0)),
                        new Obstacle(16671, "Climb-up", new Tile(3205, 3208, 0)),
                        new Obstacle(16672, "Climb-up", new Tile(3205, 3208, 1)),
                        new Step(new Tile(3205, 3210, 2))
                )));

                new OneWayLink(Bank, BackEntrance, new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3205, 3210, 2)),
                        new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2)),
                        new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1)),
                        new Step(new Tile(3208, 3210, 0)),
                        new Step(new Tile(3203, 3214, 0)),
                        new Step(new Tile(3202, 3218, 0))
                )));

                new OneWayLink(Bank, Courtyard, new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3205, 3210, 2)),
                        new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2)),
                        new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1)),
                        new Step(new Tile(3208, 3210, 0)),
                        new Step(new Tile(3215, 3211, 0)),
                        new Step(new Tile(3215, 3218, 0))
                )));

                new OneWayLink(Courtyard, Bank, new ArrayList<>(Arrays.asList(
                        new Step(new Tile(3215, 3218, 0)),
                        new Step(new Tile(3215, 3211, 0)),
                        new Step(new Tile(3208, 3210, 0)),
                        new Obstacle(16671, "Climb-up", new Tile(3205, 3208, 0)),
                        new Obstacle(16672, "Climb-up", new Tile(3205, 3208, 1)),
                        new Step(new Tile(3205, 3210, 2))
                )));

                new TwoWayLink(Courtyard, Lumbridge.Center);
            }
        }
    }
}
