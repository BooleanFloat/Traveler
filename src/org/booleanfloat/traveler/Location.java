package org.booleanfloat.traveler;

import org.booleanfloat.traveler.links.Link;
import org.booleanfloat.traveler.links.OneWayLink;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

import java.awt.*;
import java.util.HashMap;

public class Location {
    public String name;
    public Area area;
    public HashMap<Location, Link> links;
    private Tile center;

    public Location(String name, Area area) {
        this.name = name;
        this.area = area;
        this.links = new HashMap<>();
        this.center = area.getCentralTile();

        new OneWayLink(this, this);
    }

    public void addLink(Location other, Link link) {
        links.put(other, link);
    }

    public void paint(ClientContext ctx, Graphics g) {
        Tile pos = ctx.players.local().tile();

        if(Math.abs(center.x() - pos.x()) < 30 && Math.abs(center.y() - pos.y()) < 30) {
            g.setColor(Color.GREEN);

            if(this.area.getCentralTile().floor() == ctx.players.local().tile().floor()) {
                TileMatrix matrix = center.matrix(ctx);

                if(matrix.inViewport()) {
                    g.drawPolygon(matrix.getBounds());
                    g.drawString(this.name, matrix.centerPoint().x, matrix.centerPoint().y);
                }

                if(matrix.onMap()) {
                    g.fillRect(matrix.mapPoint().x - 2, matrix.mapPoint().y - 2, 4, 4);
                    g.drawString(this.name, matrix.mapPoint().x, matrix.mapPoint().y);
                }
            }

        }

//        for(Link link : links.values()) {
//            link.paint(ctx, g);
//        }
    }

    public String toString() {
        return name;
    }
}
