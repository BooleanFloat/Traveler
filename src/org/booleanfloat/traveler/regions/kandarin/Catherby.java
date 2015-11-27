package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Catherby implements Region {
    public static Location Bank;
    public static Location FishingSpot;
    public static Location GeneralStore;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(FishingSpot);
        locations.add(GeneralStore);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("Catherby, Bank", new Area(
                new Tile(2812, 3441, 0),
                new Tile(2806, 3437, 0)
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
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Bank, GeneralStore);

        new TwoWayLink(Bank, FishingSpot, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2809, 3437, 0)),
                new Step(new Tile(2809, 3436, 0)),
                new Step(new Tile(2828, 3437, 0)),
                new Step(new Tile(2834, 3437, 0)),
                new Step(new Tile(2842, 3432, 0))
        )));

        new TwoWayLink(GeneralStore, SeersVillage.CastleGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2804, 3431, 0)),
                new Step(new Tile(2793, 3433, 0)),
                new Step(new Tile(2774, 3451, 0)),
                new Step(new Tile(2764, 3466, 0)),
                new Step(new Tile(2758, 3476, 0))
        )));
    }
}
