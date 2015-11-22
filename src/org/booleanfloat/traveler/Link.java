package org.booleanfloat.traveler;

import org.booleanfloat.traveler.steps.Obstacle;
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

    private ArrayList<Tile> waypoints;
    private ArrayList<Tile> path;

    private ArrayList<Obstacle> obstacles;

    private double distance;

    public Link(Location start, Location end, ArrayList<Traversable> steps) {
        this.start = start;
        this.end = end;
        this.steps = steps;

        // add start and end to the steps array
        this.steps.add(0, new Step(this.start.area.getCentralTile()));
        this.steps.add(new Step(this.end.area.getCentralTile()));

        // auto fill steps between every two Step objects
        this.steps = autofillSteps(this.steps);
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
            if(!start.getClass().toString().equals("Step") || !end.getClass().toString().equals("Step")) {
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

            for(int j = 1; j < amount; j++) {
                double x = startTile.x() + (j * dx / amount);
                double y = startTile.y() + (j * dy / amount);

                newSteps.add(new Step(new Tile((int) x, (int) y, startTile.floor())));
            }
        }

        newSteps.add(steps.get(steps.size() - 1));

        return newSteps;
    }

//    public Link(Location start, Location end, ArrayList<Tile> waypoints, ArrayList<Obstacle> obstacles) {
//        this.start = start;
//        this.end = end;
//        this.waypoints = waypoints;
//        this.obstacles = obstacles;
//
//        this.waypoints.add(0, this.start.area.getCentralTile());
//        this.waypoints.add(this.end.area.getCentralTile());
//
//        path = new ArrayList<>();
//        distance = 0;
//
//        for(int i = 0; i < waypoints.size() -1; i++) {
//            Tile start = waypoints.get(i);
//            Tile end = waypoints.get(i + 1);
//
//            if(start.floor() != end.floor()) {
//                continue;
//            }
//
//            int dx = end.x() - start.x();
//            int dy = end.y() - start.y();
//            double distance = start.distanceTo(end);
//            double steps = Math.round(distance / 3);
//
//            this.distance += distance;
//
//            path.add(start);
//
//            for(int j = 1; j < steps; j++) {
//                double x = start.x() + (j * dx / steps);
//                double y = start.y() + (j * dy / steps);
//
//                path.add(new Tile((int)x, (int)y));
//            }
//
//            path.add(end);
//        }
//
//        this.start.addLink(this.end, this);
//    }

    public Location getOtherLocation(Location location) {
        if(location == start) {
            return end;
        }

        return start;
    }

    public double getDistance() {
        return distance;
    }

    public ArrayList<Tile> getPath() {
        return path;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public void paint(ClientContext ctx, Graphics g) {
        drawWorldTiles(ctx, g);
        drawWorldPath(ctx, g);
        drawMapPath(ctx, g);
    }

    private void drawMapPath(ClientContext ctx, Graphics g) {
        int x1 = waypoints.get(0).matrix(ctx).mapPoint().x;
        int y1 = waypoints.get(0).matrix(ctx).mapPoint().y;
        int x2;
        int y2;

        g.setColor(Color.MAGENTA);

        for(Tile step : path) {
            TileMatrix matrix = step.matrix(ctx);

            x2 = matrix.mapPoint().x;
            y2 = matrix.mapPoint().y;

            if(matrix.onMap()) {
                g.drawLine(x1, y1, x2, y2);
            }

            x1 = x2;
            y1 = y2;
        }
    }

    private void drawWorldPath(ClientContext ctx, Graphics g) {
        int x1 = waypoints.get(0).matrix(ctx).centerPoint().x;
        int y1 = waypoints.get(0).matrix(ctx).centerPoint().y;
        int x2;
        int y2;

        g.setColor(Color.MAGENTA);

        for(Tile step : path) {
            TileMatrix matrix = step.matrix(ctx);

            x2 = matrix.centerPoint().x;
            y2 = matrix.centerPoint().y;

            if(x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1) {
                g.drawLine(x1, y1, x2, y2);
            }

            x1 = x2;
            y1 = y2;
        }
    }

    private void drawWorldTiles(ClientContext ctx, Graphics g) {
        for(Tile step : path) {
            TileMatrix matrix = step.matrix(ctx);

            if(matrix.inViewport()) {
                g.setColor(Color.PINK);
                g.drawPolygon(matrix.getBounds());
            }
        }
    }

    public String toString() {
        return this.start + " -> " + this.end;
    }
}
