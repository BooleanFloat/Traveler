package org.booleanfloat.traveler;

import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.links.Link;
import org.booleanfloat.traveler.regions.asgarnia.*;
import org.booleanfloat.traveler.regions.kandarin.*;
import org.booleanfloat.traveler.regions.karamja.Brimhaven;
import org.booleanfloat.traveler.regions.karamja.MusaPoint;
import org.booleanfloat.traveler.regions.kharidiandesert.AlKharid;
import org.booleanfloat.traveler.regions.misthalin.*;
import org.booleanfloat.traveler.steps.ImportantStep;
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

            if(location == end) {
                continue;
            }

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

                boolean isClose = (Math.abs(pos.x() - dest.x()) < 8 && Math.abs(pos.y() - dest.y()) < 8);
                boolean isDifferentFloor = pos.floor() != dest.floor();
                boolean isObstructing = false;

                if(path.lastTraversal != null) {
                    isObstructing = path.lastTraversal.isObstructing(ctx);
                }

                if(path.lastTraversal instanceof ImportantStep) {
                    isClose = (Math.abs(pos.x() - dest.x()) < 3 && Math.abs(pos.y() - dest.y()) < 3);
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
        DwarvenMine.initLocations();
        PortSarim.initLocations();
        Rimmington.initLocations();
        Taverly.initLocations();

        // Kandarin
        Catherby.initLocations();
        EastArdougne.initLocations();
        PortKhazard.initLocations();
        SeersVillage.initLocations();
        TreeGnomeStronghold.initLocations();
        Yanille.initLocations();

        // Karamja
        Brimhaven.initLocations();
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
        DwarvenMine.initLinks(ctx);
        PortSarim.initLinks(ctx);
        Rimmington.initLinks(ctx);
        Taverly.initLinks(ctx);

        // Kandarin
        Catherby.initLinks(ctx);
        EastArdougne.initLinks(ctx);
        PortKhazard.initLinks(ctx);
        SeersVillage.initLinks(ctx);
        TreeGnomeStronghold.initLinks(ctx);
        Yanille.initLinks(ctx);

        // Karamja
        Brimhaven.initLinks(ctx);
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
        locations.addAll(DwarvenMine.getLocations());
        locations.addAll(Falador.getLocations());
        locations.addAll(PortSarim.getLocations());
        locations.addAll(Rimmington.getLocations());
        locations.addAll(Taverly.getLocations());

        // Kandarin
        locations.addAll(Catherby.getLocations());
        locations.addAll(EastArdougne.getLocations());
        locations.addAll(PortKhazard.getLocations());
        locations.addAll(SeersVillage.getLocations());
        locations.addAll(TreeGnomeStronghold.getLocations());
        locations.addAll(Yanille.getLocations());

        // Karamja
        locations.addAll(Brimhaven.getLocations());
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
