package org.booleanfloat.main;

import org.booleanfloat.traveler.Dijkstra;
import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.regions.Lumbridge;
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
        Lumbridge.init();

        Dijkstra.init(new Location[]{
                Lumbridge.castleBank,
                Lumbridge.castleCourtyard,
                Varrock.castleCourtyard,
                Varrock.castleEntrance,
                Varrock.castleTrainingRoom,
                Varrock.clothesStore,
                Varrock.eastBank,
                Varrock.eastGate,
                Varrock.fountain,
                Varrock.grandExchange,
                Varrock.southGate,
                Varrock.westBank
        });

        taskList.addAll(Arrays.asList(
//                new Traverse(ctx, Varrock.clothesStore, Varrock.grandExchange)
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
                Lumbridge.castleBank,
                Lumbridge.castleCourtyard,
                Varrock.castleCourtyard,
                Varrock.castleEntrance,
                Varrock.castleTrainingRoom,
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
    }
}
