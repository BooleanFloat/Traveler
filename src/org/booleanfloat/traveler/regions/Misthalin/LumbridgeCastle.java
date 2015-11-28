package org.booleanfloat.traveler.regions.misthalin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.OneWayLink;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Obstacle;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;

public class LumbridgeCastle implements Region {
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
        Bank = new Location("LumbridgeCastle, Bank", new Area(
                new Tile(3210, 3220, 2),
                new Tile(3207, 3218, 2)
        ));

        BackEntrance = new Location("LumbridgeCastle, BackEntrance", new Area(
                new Tile(3201, 3219, 0),
                new Tile(3199, 3217, 0)
        ));

        Courtyard = new Location("LumbridgeCastle, Courtyard", new Area(
                new Tile(3224, 3220, 0),
                new Tile(3221, 3217, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
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
                new Obstacle(16671, "Climb-up", new Tile(3205, 3208, 0), new int[]{-64, 64, -128, 0, -64, 64}),
                new Obstacle(16672, "Climb-up", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3205, 3210, 2))
        )));

        new TwoWayLink(BackEntrance, Lumbridge.HamBuilding, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3197, 3218, 0)),
                new Step(new Tile(3167, 3247, 0))
        )));

        new TwoWayLink(BackEntrance, WizardsTower.Causeway, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3200, 3218, 0)),
                new Step(new Tile(3129, 3218, 0)),
                new Step(new Tile(3115, 3208, 0))
        )));

        new OneWayLink(Bank, BackEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3205, 3210, 2)),
                new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2), new int[]{-160, 64, -64, 0, -160, 32}),
                new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3208, 3210, 0)),
                new Step(new Tile(3203, 3214, 0)),
                new Step(new Tile(3202, 3218, 0))
        )));

        new OneWayLink(Bank, Courtyard, new ArrayList<>(Arrays.asList(
                new Step(new Tile(3205, 3210, 2)),
                new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2), new int[]{-160, 64, -64, 0, -160, 32}),
                new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
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
