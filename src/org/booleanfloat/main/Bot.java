package org.booleanfloat.main;

import org.booleanfloat.traveler.Dijkstra;
import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.tasks.*;
import org.booleanfloat.traveler.regions.*;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name="Traveler", description="travels")
public class Bot extends PollingScript<ClientContext> implements PaintListener {
    private List<Task> taskList = new ArrayList<Task>();
    private ArrayList<Location> locations = new ArrayList<>();

    @Override
    public void start() {
        System.out.println("start");

        Traveler.init(ctx);

        locations.addAll(Traveler.getLocations());

        Dijkstra.init(locations.toArray(new Location[locations.size()]));

        System.out.println("Locations: ");
        for(Location loc : locations) {
            System.out.println("\t" + loc.toString());
        }
        System.out.println("\n");

        taskList.addAll(Arrays.asList(
                new Traverse(ctx, MusaPoint.PortSarimBoat, Varrock.Fountain)
        ));
    }

    @Override
    public void poll() {
        for (Task t : taskList) {
            if (t.activate()) {
                t.execute();
            }
        }

//        Scanner in = new Scanner(System.in);
//        String input = in.next();
//
//        if(input.contains("object")) {
//            String[] parts = input.split("-");
//            if(parts.length == 2) {
//                int id = Integer.parseInt(parts[1]);
//                System.out.println(ctx.objects.select().id(id).nearest().poll());
//            }
//        }
    }

    @Override
    public void repaint(Graphics g) {
        for(Location loc : locations) {
            if(loc != null) { loc.paint(ctx, g); }
        }
    }
}
