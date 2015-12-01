package org.booleanfloat.traveler.regions.asgarnia;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.regions.misthalin.BarbarianVillage;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DwarvenMine implements Region {
    public static Location CampEntrance;
    public static Location CrossbowStore;
    public static Location OreStore;
    public static Location ScorpionPit;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(CampEntrance);
        locations.add(CrossbowStore);
        locations.add(OreStore);
        locations.add(ScorpionPit);

        return locations;
    }

    public static void initLocations() {
        CampEntrance = new Location("DwarvenMine, CampEntrance", new Area(
                new Tile(3021, 3451, 0),
                new Tile(3012, 3445, 0)
        ));

        CrossbowStore = new Location("DwarvenMine, CrossbowStore", new Area(
                new Tile(3007, 9802, 0),
                new Tile(2999, 9795, 0)
        ));

        OreStore = new Location("DwarvenMine, OreStore", new Area(
                new Tile(3041, 9849, 0),
                new Tile(3032, 9842, 0)
        ));

        ScorpionPit = new Location("DwarvenMine, ScorpionPit", new Area(
                new Tile(3050, 9784, 0),
                new Tile(3060, 9778, 0),
                new Tile(3052, 9760, 0),
                new Tile(3035, 9760, 0),
                new Tile(3031, 9771, 0),
                new Tile(3039, 9785, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new OneWayLink(CampEntrance, OreStore, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3018, 3450, 0)),
                new Obstacle(11867, "Climb-down", new Tile(3019, 3450, 0)),
                new Step(new Tile(3018, 9850, 0)),
                new Step(new Tile(3024, 9847, 0))
        )));

        new TwoWayLink(CampEntrance, BarbarianVillage.Mine, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3016, 3449, 0)),
                new Step(new Tile(3016, 3455, 0)),
                new Step(new Tile(3029, 3460, 0)),
                new Step(new Tile(3032, 3470, 0)),
                new Step(new Tile(3044, 3470, 0)),
                new Step(new Tile(3052, 3466, 0)),
                new Step(new Tile(3069, 3442, 0)),
                new Step(new Tile(3069, 3427, 0)),
                new Step(new Tile(3080, 3421, 0))
        )));

        new TwoWayLink(CrossbowStore, OreStore, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3000, 9804, 0)),
                new Step(new Tile(3001, 9811, 0)),
                new Step(new Tile(3018, 9814, 0)),
                new Step(new Tile(3021, 9845, 0))
        )));

        new OneWayLink(OreStore, CampEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3024, 9847, 0)),
                new Step(new Tile(3018, 9850, 0)),
                new Obstacle(17387, "Climb-up", new Tile(3019, 9850, 0)),
                new Step(new Tile(3018, 3450, 0))
        )));

        new TwoWayLink(OreStore, ScorpionPit, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3022, 9847, 0)),
                new Step(new Tile(3022, 9837, 0)),
                new Step(new Tile(3041, 9831, 0)),
                new Step(new Tile(3044, 9806, 0)),
                new Step(new Tile(3043, 9792, 0))
        )));

        new OneWayLink(ScorpionPit, Falador.DwarvenMineEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3058, 9776, 0)),
                new Obstacle(23969, "Climb-up", new Tile(3060, 9777, 0)),
                new Step(new Tile(3061, 3377, 0))
        )));
    }
}
