package org.booleanfloat.traveler;

import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.Link;
import org.booleanfloat.traveler.regions.*;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;

public class Traveler {
    public static Path getPath(Tile start, Location end) {
        double minDistance = Double.MAX_VALUE;
        Location closestLocation = null;

        for(Location location : getLocations()) {
            double distance = start.distanceTo(location.area.getCentralTile());

            if(distance < minDistance) {
                minDistance = distance;
                closestLocation = location;
            }
        }

        System.out.println("ClosestLocation:" + closestLocation);

        return getPath(closestLocation, end);
    }

    public static Path getPath(Location start, Location end) {
        ArrayList<Link> links = Dijkstra.getLinks(start, end);
        ArrayList<Traversable> steps = new ArrayList<>();

        for(Link link : links) {
            System.out.println(link.toString());
            steps.addAll(link.getSteps());
        }

        return new Path(start, end, steps);
    }

    public static void init(ClientContext ctx) {
        AlKharid.initLocations();
        BarbarianVillage.initLocations();
        Draynor.initLocations();
        AlKharid.initLocations();
        Edgeville.initLocations();
        Falador.initLocations();
        Lumbridge.initLocations();
        LumbridgeCastle.initLocations();
        MusaPoint.initLocations();
        PortSarim.initLocations();
        Varrock.initLocations();
        VarrockCastle.initLocations();

        AlKharid.initLinks(ctx);
        BarbarianVillage.initLinks(ctx);
        Draynor.initLinks(ctx);
        Edgeville.initLinks(ctx);
        Falador.initLinks(ctx);
        Lumbridge.initLinks(ctx);
        LumbridgeCastle.initLinks(ctx);
        MusaPoint.initLinks(ctx);
        PortSarim.initLinks(ctx);
        Varrock.initLinks(ctx);
        VarrockCastle.initLinks(ctx);

        StringBuilder locs = new StringBuilder();
        locs.append("Locations: \n");
        for(Location loc : getLocations()) {
            locs.append("\t" + loc.toString() + "\n");
        }
        System.out.println(locs.toString());
    }

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.addAll(AlKharid.getLocations());
        locations.addAll(BarbarianVillage.getLocations());
        locations.addAll(Draynor.getLocations());
        locations.addAll(Edgeville.getLocations());
        locations.addAll(Falador.getLocations());
        locations.addAll(Lumbridge.getLocations());
        locations.addAll(LumbridgeCastle.getLocations());
        locations.addAll(MusaPoint.getLocations());
        locations.addAll(PortSarim.getLocations());
        locations.addAll(Varrock.getLocations());
        locations.addAll(VarrockCastle.getLocations());

        return locations;
    }
}
