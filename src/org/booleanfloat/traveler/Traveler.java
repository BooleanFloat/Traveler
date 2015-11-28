package org.booleanfloat.traveler;

import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.Link;
import org.booleanfloat.traveler.regions.asgarnia.Burthorpe;
import org.booleanfloat.traveler.regions.asgarnia.Falador;
import org.booleanfloat.traveler.regions.asgarnia.PortSarim;
import org.booleanfloat.traveler.regions.asgarnia.Taverly;
import org.booleanfloat.traveler.regions.kandarin.*;
import org.booleanfloat.traveler.regions.karamja.MusaPoint;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.regions.misthalin.*;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import java.util.ArrayList;
import java.util.concurrent.Callable;

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


        return getPath(closestLocation, end);
    }

    public static Path getPath(Location start, Location end) {
        ArrayList<Link> links = Dijkstra.getLinks(start, end);
        ArrayList<Traversable> steps = new ArrayList<>();

        System.out.println(start.name + " -> " + end.name);
        for(Link link : links) {
            System.out.println("\t" + link.toString());
            steps.addAll(link.getSteps());
        }
        System.out.println("");

        return new Path(start, end, steps);
    }

    public static Callable<Boolean> getConditionWaiter(ClientContext ctx, Path path) {
        return new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Tile pos = ctx.players.local().tile();
                Tile dest = ctx.movement.destination();

                boolean isClose = (Math.abs(pos.x() - dest.x()) < 6 && Math.abs(pos.y() - dest.y()) < 6);
                boolean isDifferentFloor = pos.floor() != dest.floor();
                boolean isObstructing = false;

                if(path.lastTraversal != null) {
                    isObstructing = path.lastTraversal.isObstructing(ctx);
                }

                return isClose || isDifferentFloor || isObstructing;
            }
        };
    }

    public static void init(ClientContext ctx) {
        initLocations();
        initLinks(ctx);

        StringBuilder locs = new StringBuilder();
        locs.append("Locations: \n");
        for(Location loc : getLocations()) {
            locs.append("\t" + loc.toString() + "\n");
        }
        System.out.println(locs.toString());

        ArrayList<Location> locations = Traveler.getLocations();
        Dijkstra.init(locations.toArray(new Location[locations.size()]));
    }

    private static void initLocations() {
        // Asgarnia
        Burthorpe.initLocations();
        Falador.initLocations();
        PortSarim.initLocations();
        Taverly.initLocations();

        // Kandarin
        Catherby.initLocations();
        EastArdougne.initLocations();
        PortKhazard.initLocations();
        SeersVillage.initLocations();
        Yanille.initLocations();

        // Karamja
        MusaPoint.initLocations();

        // Kharidian Desert
        AlKharid.initLocations();

        // Misthalin
        BarbarianVillage.initLocations();
        Draynor.initLocations();
        Edgeville.initLocations();
        Lumbridge.initLocations();
        LumbridgeCastle.initLocations();
        Varrock.initLocations();
        VarrockCastle.initLocations();
        WizardsTower.initLocations();
    }

    private static void initLinks(ClientContext ctx) {
        // Asgarnia
        Burthorpe.initLinks(ctx);
        Falador.initLinks(ctx);
        PortSarim.initLinks(ctx);
        Taverly.initLinks(ctx);

        // Kandarin
        Catherby.initLinks(ctx);
        EastArdougne.initLinks(ctx);
        PortKhazard.initLinks(ctx);
        SeersVillage.initLinks(ctx);
        Yanille.initLinks(ctx);

        // Karamja
        MusaPoint.initLinks(ctx);

        // Kharidian Desert
        AlKharid.initLinks(ctx);

        // Misthalin
        BarbarianVillage.initLinks(ctx);
        Draynor.initLinks(ctx);
        Edgeville.initLinks(ctx);
        Lumbridge.initLinks(ctx);
        LumbridgeCastle.initLinks(ctx);
        Varrock.initLinks(ctx);
        VarrockCastle.initLinks(ctx);
        WizardsTower.initLinks(ctx);
    }

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        // Asgarnia
        locations.addAll(Burthorpe.getLocations());
        locations.addAll(Falador.getLocations());
        locations.addAll(PortSarim.getLocations());
        locations.addAll(Taverly.getLocations());

        // Kandarin
        locations.addAll(Catherby.getLocations());
        locations.addAll(EastArdougne.getLocations());
        locations.addAll(PortKhazard.getLocations());
        locations.addAll(SeersVillage.getLocations());
        locations.addAll(Yanille.getLocations());

        // Karamja
        locations.addAll(MusaPoint.getLocations());

        // Kharidian Desert
        locations.addAll(AlKharid.getLocations());

        // Misthalin
        locations.addAll(BarbarianVillage.getLocations());
        locations.addAll(Draynor.getLocations());
        locations.addAll(Edgeville.getLocations());
        locations.addAll(Lumbridge.getLocations());
        locations.addAll(LumbridgeCastle.getLocations());
        locations.addAll(Varrock.getLocations());
        locations.addAll(VarrockCastle.getLocations());
        locations.addAll(WizardsTower.getLocations());

        return locations;
    }
}
