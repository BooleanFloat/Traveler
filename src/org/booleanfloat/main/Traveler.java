package org.booleanfloat.main;

import org.booleanfloat.traveler.Dijkstra;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.regions.Varrock;
import org.booleanfloat.tasks.*;
import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name="Traveler", description="travels")
public class Traveler extends PollingScript<ClientContext> implements PaintListener {
    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        System.out.println("start");
        Varrock.init();

        Dijkstra.init(new Location[]{
                Varrock.castleCourtyard,
                Varrock.clothesStore,
                Varrock.eastBank,
                Varrock.eastGate,
                Varrock.fountain,
                Varrock.grandExchange,
                Varrock.southGate,
                Varrock.westBank
        });

        taskList.addAll(Arrays.asList(
                new Traverse(ctx, Varrock.fountain, Varrock.clothesStore)
        ));
    }

    @Override
    public void poll() {
        for (Task t : taskList) {
            if (t.activate()) {
                t.execute();
            }
        }
    }

    @Override
    public void repaint(Graphics g) {
        Location[] locations = new Location[] {
                Varrock.castleCourtyard,
                Varrock.clothesStore,
                Varrock.eastBank,
                Varrock.eastGate,
                Varrock.fountain,
                Varrock.grandExchange,
                Varrock.southGate,
                Varrock.westBank
        };

        for(Location loc : locations) {
            if(loc != null) { loc.paint(ctx, g); }
        }

//        if(mausoleum == null) {
//            return;
//        }
//
//        if(link != null) {
//            link.paint(ctx, g);
//        }
//
//        if(churchLink != null) {
//            churchLink.paint(ctx, g);
//        }

//        TileMatrix center = mausoleum.area.getCentralTile().matrix(ctx);
//
//        if(center.inViewport()) {
//            if(center.reachable()) {
//                g.setColor(Color.GREEN);
//            }
//            else {
//                g.setColor(Color.RED);
//            }
//
//            g.drawPolygon(center.getBounds());
//        }
    }
}
