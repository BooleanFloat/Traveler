package org.booleanfloat.traveler.regions;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.Obstacle;
import org.booleanfloat.traveler.OneWayLink;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class Lumbridge {
    public static Location castleBank;
    public static Location castleCourtyard;

    public static void init() {
        castleBank = new Location("Lumbdridge castle bank", new Area(
                new Tile(3210, 3220, 2),
                new Tile(3207, 3218, 2)
        ));

        castleCourtyard = new Location("Lumbridge castle courtyard", new Area(
                new Tile(3222, 3219, 0),
                new Tile(3221, 3218, 0)
        ));

        new OneWayLink(castleBank, castleCourtyard,
                new ArrayList<>(Arrays.asList(
                        new Tile(3206, 3209, 2),
                        new Tile(3215, 3210, 0),
                        new Tile(3215, 3218, 0)
                )),
                new ArrayList<>(Arrays.asList(
                        new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2)),
                        new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1))
                ))
        );
    }
}
