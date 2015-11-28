package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class SeersVillage implements Region {
    public static Location Bank;
    public static Location CastleGate;
    public static Location SouthHouse;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(Bank);
        locations.add(CastleGate);
        locations.add(SouthHouse);

        return locations;
    }

    public static void initLocations() {
        Bank = new Location("SeersVillage, Bank", new Area(
                new Tile(2730, 3492, 0),
                new Tile(2721, 3489, 0)
        ));

        CastleGate = new Location("SeersVillage, CastleGate", new Area(
                new Tile(2761, 3480, 0),
                new Tile(2756, 3476, 0)
        ));

        SouthHouse = new Location("SeersVillage, SouthHouse", new Area(
                new Tile(2706, 3476, 0),
                new Tile(2699, 3469, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Bank, CastleGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2726, 3487, 0)),
                new Step(new Tile(2726, 3484, 0)),
                new Step(new Tile(2732, 3484, 0)),
                new Step(new Tile(2740, 3479, 0)),
                new Step(new Tile(2758, 3477, 0))
        )));

        new TwoWayLink(Bank, SouthHouse, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2726, 3491, 0)),
                new Step(new Tile(2726, 3483, 0)),
                new Step(new Tile(2706, 3483, 0)),
                new Step(new Tile(2701, 3477, 0)),
                new Obstacle(25819, "Open", new Tile(2701, 3477, 0), new int[]{0, 128, -224, 0, -32, 32}),
                new Step(new Tile(2702, 3473, 0))
        )));
    }
}
