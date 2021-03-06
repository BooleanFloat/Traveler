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

public class LumbridgeCastle implements Region {
    public static Location Bank;
    public static Location BackEntrance;
    public static Location Courtyard;
    public static Location DukesRoom;
    public static Location SouthTowerUpstairs;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(Bank);
        locations.add(BackEntrance);
        locations.add(Courtyard);
        locations.add(DukesRoom);
        locations.add(SouthTowerUpstairs);

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

        Courtyard = new Location("LumbridgeCastle, Crossroads", new Area(
                new Tile(3224, 3220, 0),
                new Tile(3221, 3217, 0)
        ));

        DukesRoom = new Location("LumbridgeCastle, DukesRoom", new Area(
                new Tile(3213, 3225, 1),
                new Tile(3208, 3218, 1)
        ));

        SouthTowerUpstairs = new Location("LumbridgeCastle, SouthTowerUpstairs", new Area(
                new Tile(3231, 3216, 1),
                new Tile(3227, 3211, 1)
        ));
    }

    public static void initLinks(final ClientContext ctx) {
        new TeleportLink(Courtyard, Magic.Spell.LUMBRIDGE_TELEPORT, new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.skills.realLevel(Constants.SKILLS_MAGIC) >= 31
                        && ctx.inventory.select().id(Resources.EARTH_RUNE_ID).poll().stackSize() > 1
                        && ctx.inventory.select().id(Resources.AIR_RUNE_ID).poll().stackSize() > 3
                        && ctx.inventory.select().id(Resources.LAW_RUNE_ID).poll().stackSize() > 1;
            }
        });

        new TwoWayLink(BackEntrance, Lumbridge.Center, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3202, 3218, 0)),
                new Step(new Tile(3203, 3214, 0)),
                new Step(new Tile(3212, 3210, 0)),
                new Step(new Tile(3216, 3218, 0))
        )));

        new OneWayLink(BackEntrance, Bank,  new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3202, 3218, 0)),
                new Step(new Tile(3203, 3214, 0)),
                new Step(new Tile(3206, 3209, 0)),
                new Obstacle(16671, "Climb-up", new Tile(3205, 3208, 0), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3206, 3208, 1)),
                new Obstacle(16672, "Climb-up", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3205, 3210, 2))
        )));

        new OneWayLink(BackEntrance, DukesRoom, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3202, 3218, 0)),
                new Step(new Tile(3203, 3214, 0)),
                new Step(new Tile(3206, 3209, 0)),
                new Obstacle(16671, "Climb-up", new Tile(3205, 3208, 0), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3206, 3210, 1)),
                new Step(new Tile(3206, 3222, 1)),
                new Obstacle(7143, "Open", new Tile(3207, 3222, 1), new int[]{96, 144, -192, 0, 0, 128}),
                new Step(new Tile(3210, 3222, 1))
        )));

        new TwoWayLink(BackEntrance, Lumbridge.HamBuilding, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3197, 3218, 0)),
                new Step(new Tile(3167, 3247, 0))
        )));

        new TwoWayLink(BackEntrance, WizardsTower.Causeway, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3200, 3218, 0)),
                new Step(new Tile(3129, 3218, 0)),
                new Step(new Tile(3115, 3208, 0))
        )));

        new OneWayLink(Bank, BackEntrance, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3205, 3210, 2)),
                new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2), new int[]{-160, 64, -64, 0, -160, 32}),
                new Step(new Tile(3206, 3208, 1)),
                new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3208, 3210, 0)),
                new Step(new Tile(3203, 3214, 0)),
                new Step(new Tile(3202, 3218, 0))
        )));

        new OneWayLink(Bank, Courtyard, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3205, 3210, 2)),
                new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2), new int[]{-160, 64, -64, 0, -160, 32}),
                new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3208, 3210, 0)),
                new Step(new Tile(3215, 3211, 0)),
                new Step(new Tile(3215, 3218, 0))
        )));

        new OneWayLink(Bank, DukesRoom, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3205, 3210, 2)),
                new Obstacle(16673, "Climb-down", new Tile(3205, 3208, 2), new int[]{-160, 64, -64, 0, -160, 32}),
                new Step(new Tile(3206, 3210, 1)),
                new Step(new Tile(3206, 3222, 1)),
                new Obstacle(7143, "Open", new Tile(3207, 3222, 1), new int[]{96, 144, -192, 0, 0, 128}),
                new Step(new Tile(3210, 3222, 1))
        )));

        new OneWayLink(Courtyard, Bank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3215, 3218, 0)),
                new Step(new Tile(3215, 3211, 0)),
                new Step(new Tile(3208, 3210, 0)),
                new Obstacle(16671, "Climb-up", new Tile(3205, 3208, 0)),
                new Obstacle(16672, "Climb-up", new Tile(3205, 3208, 1)),
                new Step(new Tile(3205, 3210, 2))
        )));

        new OneWayLink(Courtyard, DukesRoom, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3215, 3218, 0)),
                new Step(new Tile(3215, 3211, 0)),
                new Step(new Tile(3208, 3210, 0)),
                new Obstacle(16671, "Climb-up", new Tile(3205, 3208, 0)),
                new Step(new Tile(3206, 3210, 1)),
                new Step(new Tile(3206, 3222, 1)),
                new Obstacle(7143, "Open", new Tile(3207, 3222, 1), new int[]{96, 144, -192, 0, 0, 128}),
                new Step(new Tile(3210, 3222, 1))
        )));

        new OneWayLink(Courtyard, SouthTowerUpstairs, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3222, 3218, 0)),
                new Step(new Tile(3225, 3214, 0)),
                new Obstacle(7122, "Open", new Tile(3226, 3214, 0), Obstacle.Hitbox.DOOR_EAST),
                new Step(new Tile(3228, 3213, 0)),
                new Obstacle(16683, "Climb-up", new Tile(3229, 3213, 0))
        )));

        new TwoWayLink(Courtyard, Lumbridge.Center);

        new OneWayLink(DukesRoom, BackEntrance, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3210, 3222, 1)),
                new Obstacle(7143, "Open", new Tile(3207, 3222, 1), new int[]{96, 144, -192, 0, 0, 128}),
                new Step(new Tile(3206, 3222, 1)),
                new Step(new Tile(3206, 3210, 1)),
                new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3208, 3210, 0)),
                new Step(new Tile(3203, 3214, 0)),
                new Step(new Tile(3202, 3218, 0))
        )));

        new OneWayLink(DukesRoom, Bank, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3210, 3222, 1)),
                new Obstacle(7143, "Open", new Tile(3207, 3222, 1), new int[]{96, 144, -192, 0, 0, 128}),
                new Step(new Tile(3206, 3222, 1)),
                new Step(new Tile(3206, 3210, 1)),
                new Obstacle(16672, "Climb-up", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3205, 3210, 2))
        )));

        new OneWayLink(DukesRoom, Courtyard, new ArrayList<Traversable>(Arrays.asList(
                new Step(new Tile(3210, 3222, 1)),
                new Obstacle(7143, "Open", new Tile(3207, 3222, 1), new int[]{96, 144, -192, 0, 0, 128}),
                new Step(new Tile(3206, 3222, 1)),
                new Step(new Tile(3206, 3210, 1)),
                new Obstacle(16672, "Climb-down", new Tile(3205, 3208, 1), new int[]{-64, 64, -128, 0, -64, 64}),
                new Step(new Tile(3208, 3210, 0)),
                new Step(new Tile(3215, 3211, 0)),
                new Step(new Tile(3215, 3218, 0))
        )));

        new OneWayLink(SouthTowerUpstairs, Courtyard, new ArrayList<Traversable>(Arrays.asList(
                new Obstacle(16684, "Climb-down", new Tile(3229, 3213, 1)),
                new Step(new Tile(3228, 3213, 0)),
                new Obstacle(7122, "Open", new Tile(3226, 3214, 0), Obstacle.Hitbox.DOOR_EAST),
                new Step(new Tile(3225, 3214, 0)),
                new Step(new Tile(3222, 3218, 0))
        )));
    }
}
