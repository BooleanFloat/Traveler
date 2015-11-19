package org.booleanfloat.traveler;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

import java.awt.*;
import java.util.ArrayList;

public class Link {
    private Location location1;
    private Location location2;

    private ArrayList<Tile> waypoints;
    private ArrayList<Tile> path;

    private double distance;

    public Link(Location location1, Location location2, ArrayList<Tile> waypoints) {
        this.location1 = location1;
        this.location2 = location2;
        this.waypoints = waypoints;

        this.waypoints.add(0, this.location1.area.getCentralTile());
        this.waypoints.add(this.location2.area.getCentralTile());

        path = new ArrayList<>();
        distance = 0;

        for(int i = 0; i < waypoints.size() -1; i++) {
            Tile start = waypoints.get(i);
            Tile end = waypoints.get(i + 1);

            int dx = end.x() - start.x();
            int dy = end.y() - start.y();
            double distance = start.distanceTo(end);
            double steps = Math.round(distance / 6);

            this.distance += distance;

            path.add(start);

            for(int j = 1; j < steps; j++) {
                double x = start.x() + (j * dx / steps);
                double y = start.y() + (j * dy / steps);

                path.add(new Tile((int)x, (int)y));
            }

            path.add(end);
        }

        this.location1.addLink(this.location2, this);
    }

    public Location getOtherLocation(Location location) {
        if(location == location1) {
            return location2;
        }

        return location1;
    }

    public double getDistance() {
        return distance;
    }

    public ArrayList<Tile> getPath() {
        return path;
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
        return this.location1 + " -> " + this.location2;
    }
}
