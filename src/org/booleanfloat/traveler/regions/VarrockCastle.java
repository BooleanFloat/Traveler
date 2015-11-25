package org.booleanfloat.traveler.regions;

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

public class VarrockCastle implements Region {
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
        Courtyard = new Location("VarrockCastle, Courtyard", new Area(
                new Tile(3214, 3449, 0),
                new Tile(3211, 3448, 0)
        ));

        Entrance = new Location("VarrockCastle, Entrance", new Area(
                new Tile(3213, 3471, 0),
                new Tile(3212, 3469, 0)
        ));

        TrainingRoom = new Location("VarrockCastle, TraningRoom", new Area(
                new Tile(3205, 3473, 1),
                new Tile(3202, 3470, 1)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(Courtyard, Entrance);
        new TwoWayLink(Courtyard, Varrock.Fountain);

        new TwoWayLink(Courtyard, Varrock.GrandExchange, new ArrayList<>(Arrays.asList(
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
