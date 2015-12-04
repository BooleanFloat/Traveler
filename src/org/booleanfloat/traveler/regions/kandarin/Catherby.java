package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Catherby implements Region {
    public static Location ArcheryStore;
    public static Location Bank;
    public static Location FarmingPatch;
    public static Location FishingSpot;
    public static Location GeneralStore;
    public static Location NorthWestHouseUpstairs;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(ArcheryStore);
        locations.add(Bank);
        locations.add(FarmingPatch);
        locations.add(FishingSpot);
        locations.add(GeneralStore);
        locations.add(NorthWestHouseUpstairs);

        return locations;
    }

    public static void initLocations() {
        ArcheryStore = new Location("Catherby, ArcheryStore", new Area(
                new Tile(2826, 3445, 0),
                new Tile(2821, 3439, 0)
        ));

        Bank = new Location("Catherby, Bank", new Area(
                new Tile(2812, 3441, 0),
                new Tile(2806, 3437, 0)
        ));

        FarmingPatch = new Location("Catherby, FarmingPatch", new Area(
                new Tile(2814, 3466, 0),
                new Tile(2804, 3460, 0)
        ));

        FishingSpot = new Location("Catherby, FishingSpot", new Area(
                new Tile(2857, 3435, 0),
                new Tile(2862, 3426, 0),
                new Tile(2855, 3420, 0),
                new Tile(2848, 3424, 0),
                new Tile(2846, 3429, 0),
                new Tile(2836, 3430, 0),
                new Tile(2835, 3434, 0)
        ));

        GeneralStore = new Location("Catherby, GeneralStore", new Area(
                new Tile(2806, 3432, 0),
                new Tile(2803, 3429, 0)
        ));

        NorthWestHouseUpstairs = new Location("Catherby, NorthWestHouseUpstairs", new Area(
                new Tile(2809, 3453, 1),
                new Tile(2807, 3449, 1)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(ArcheryStore, Bank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2823, 3442, 0)),
                new Obstacle(7122, "Open", new Tile(2822, 3441, 0)),
                new Step(new Tile(2823, 3438, 0)),
                new Step(new Tile(2817, 3436, 0)),
                new Step(new Tile(2808, 3436, 0)),
                new Step(new Tile(2808, 3439, 0))
        )));

        new TwoWayLink(ArcheryStore, FishingSpot, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2824, 3441, 0)),
                new Obstacle(7122, "Open", new Tile(2822, 3441, 0)),
                new Step(new Tile(2823, 3436, 0)),
                new Step(new Tile(2833, 3437, 0)),
                new Step(new Tile(2841, 3433, 0))
        )));

        new TwoWayLink(Bank, GeneralStore);

        new TwoWayLink(Bank, FishingSpot, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2809, 3437, 0)),
                new Step(new Tile(2809, 3436, 0)),
                new Step(new Tile(2828, 3437, 0)),
                new Step(new Tile(2834, 3437, 0)),
                new Step(new Tile(2842, 3432, 0))
        )));

        new OneWayLink(Bank, NorthWestHouseUpstairs, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2809, 3436, 0)),
                new Step(new Tile(2804, 3436, 0)),
                new Step(new Tile(2804, 3452, 0)),
                new Obstacle(7129, "Open", new Tile(2806, 3452, 0), new int[]{-32, 32, -196, 0, 0, 128}),
                new Step(new Tile(2808, 3452, 0)),
                new Obstacle(16683, "Climb-up", new Tile(2807, 3454, 0))
        )));

        new OneWayLink(FarmingPatch, NorthWestHouseUpstairs, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2805, 3463, 0)),
                new Step(new Tile(2804, 3463, 0)),
                new Step(new Tile(2805, 3451, 0)),
                new Obstacle(7129, "Open", new Tile(2806, 3452, 0), new int[]{-32, 32, -196, 0, 0, 128}),
                new Step(new Tile(2808, 3451, 0)),
                new Obstacle(16683, "Climb-up", new Tile(2807, 3454, 0))
        )));

        new TwoWayLink(FarmingPatch, SeersVillage.CastleGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2805, 3463, 0)),
                new Step(new Tile(2759, 3477, 0))
        )));

        new TwoWayLink(GeneralStore, SeersVillage.CastleGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2804, 3431, 0)),
                new Step(new Tile(2793, 3433, 0)),
                new Step(new Tile(2774, 3451, 0)),
                new Step(new Tile(2764, 3466, 0)),
                new Step(new Tile(2758, 3476, 0))
        )));

        new TwoWayLink(GeneralStore, SeersVillage.KeepLeFayeEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2804, 3431, 0)),
                new Step(new Tile(2796, 3432, 0)),
                new Step(new Tile(2776, 3435, 0)),
                new Step(new Tile(2762, 3427, 0)),
                new Step(new Tile(2750, 3402, 0)),
                new Step(new Tile(2760, 3401, 0))
        )));

        new OneWayLink(NorthWestHouseUpstairs, Bank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2807, 3453, 1)),
                new Obstacle(16679, "Climb-down", new Tile(2807, 3454, 1)),
                new Step(new Tile(2808, 3451, 0)),
                new Obstacle(7129, "Open", new Tile(2806, 3452, 0), new int[]{-32, 32, -196, 0, 0, 128}),
                new Step(new Tile(2804, 3452, 0)),
                new Step(new Tile(2805, 3435, 0)),
                new Step(new Tile(2810, 3435, 0)),
                new Step(new Tile(2808, 3439, 0))
        )));

        new OneWayLink(NorthWestHouseUpstairs, FarmingPatch, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2807, 3453, 1)),
                new Obstacle(16679, "Climb-down", new Tile(2807, 3454, 1)),
                new Step(new Tile(2808, 3451, 0)),
                new Obstacle(7129, "Open", new Tile(2806, 3452, 0), new int[]{-32, 32, -196, 0, 0, 128}),
                new Step(new Tile(2805, 3451, 0)),
                new Step(new Tile(2804, 3463, 0))
        )));
    }
}
