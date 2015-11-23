package org.booleanfloat.traveler;

import org.booleanfloat.traveler.steps.Step;
import org.booleanfloat.traveler.steps.Traversable;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

import java.awt.*;
import java.util.ArrayList;

public class Link {
    private Location start;
    private Location end;
    private ArrayList<Traversable> steps;

    private double weight;

    public Link(Location start, Location end, ArrayList<Traversable> steps) {
        this.start = start;
        this.end = end;

        // add start and end to the steps array
        steps.add(0, new Step(this.start.area.getCentralTile()));
        steps.add(new Step(this.end.area.getCentralTile()));

        // auto fill steps between every two Step objects
        this.steps = autofillSteps(steps);

        this.start.addLink(end, this);
    }

    private ArrayList<Traversable> autofillSteps(ArrayList<Traversable> steps) {
        ArrayList<Traversable> newSteps = new ArrayList<>();

        for(int i = 0; i < steps.size() -1; i++) {
            Traversable start = steps.get(i);
            Traversable end = steps.get(i + 1);
            Tile startTile = start.getTile();
            Tile endTile = end.getTile();

            // always add the current step to the new steps array
            newSteps.add(start);

            // only fill path between two Step objects
            if(!(start instanceof Step) || !(end instanceof Step)) {
                continue;
            }

            // only fill path between two Steps that are on the same floor
            if(startTile.floor() != endTile.floor()) {
                continue;
            }

            int dx = endTile.x() - startTile.x();
            int dy = endTile.y() - startTile.y();
            double distance = startTile.distanceTo(endTile);
            double amount = Math.round(distance / 3);

            weight += distance;

            for(int j = 1; j < amount; j++) {
                double x = startTile.x() + (j * dx / amount);
                double y = startTile.y() + (j * dy / amount);

                newSteps.add(new Step(new Tile((int) x, (int) y, startTile.floor())));
            }
        }

        newSteps.add(steps.get(steps.size() - 1));

        return newSteps;
    }

    public Location getOtherLocation(Location location) {
        if(location == start) {
            return end;
        }

        return start;
    }

    public double getWeight() {
        return weight;
    }

    public ArrayList<Traversable> getSteps() {
        return steps;
    }

    public void paint(ClientContext ctx, Graphics g) {
        drawWorldTiles(ctx, g);
        drawWorldPath(ctx, g);
        drawMapPath(ctx, g);
    }

    private void drawMapPath(ClientContext ctx, Graphics g) {
        TileMatrix start = steps.get(0).getTile().matrix(ctx);
        int x1 = start.mapPoint().x;
        int y1 = start.mapPoint().y;
        int x2;
        int y2;

        int playerFloor = ctx.players.local().tile().floor();

        g.setColor(Color.MAGENTA);

        for(Traversable step : steps) {
            TileMatrix matrix = step.getTile().matrix(ctx);

            x2 = matrix.mapPoint().x;
            y2 = matrix.mapPoint().y;

            if(matrix.onMap() && step.getTile().floor() == playerFloor) {
                g.drawLine(x1, y1, x2, y2);
            }

            x1 = x2;
            y1 = y2;
        }
    }

    private void drawWorldPath(ClientContext ctx, Graphics g) {
        TileMatrix start = steps.get(0).getTile().matrix(ctx);
        int x1 = start.centerPoint().x;
        int y1 = start.centerPoint().y;
        int x2;
        int y2;

        int playerFloor = ctx.players.local().tile().floor();

        g.setColor(Color.MAGENTA);

        for(Traversable step : steps) {
            TileMatrix matrix = step.getTile().matrix(ctx);

            x2 = matrix.centerPoint().x;
            y2 = matrix.centerPoint().y;

            if(x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1 && step.getTile().floor() == playerFloor) {
                g.drawLine(x1, y1, x2, y2);
            }

            x1 = x2;
            y1 = y2;
        }
    }

    private void drawWorldTiles(ClientContext ctx, Graphics g) {
        int playerFloor = ctx.players.local().tile().floor();

        for(Traversable step : steps) {
            TileMatrix matrix = step.getTile().matrix(ctx);

            g.setColor(Color.PINK);
            if(step.isObstructing(ctx)) {
                g.setColor(Color.RED);
            }

            if(matrix.inViewport() && step.getTile().floor() == playerFloor) {
                g.drawPolygon(matrix.getBounds());
            }
        }
    }

    public String toString() {
        return this.start + " -> " + this.end;
    }
}
