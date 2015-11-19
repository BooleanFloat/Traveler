package org.booleanfloat.traveler;

import org.powerbot.script.Area;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TileMatrix;

import java.awt.*;
import java.util.HashMap;

public class Location {
    public String name;
    public Area area;
    public HashMap<Location, Link> links;

    public Location(String name, Area area) {
        this.name = name;
        this.area = area;
        this.links = new HashMap<>();
    }

    public void addLink(Location other, Link link) {
        links.put(other, link);
    }

    public void paint(ClientContext ctx, Graphics g) {
        if(this.area.getCentralTile().floor() != ctx.players.local().tile().floor()) {
            return;
        }

        g.setColor(Color.GREEN);
        TileMatrix matrix = this.area.getCentralTile().matrix(ctx);

        if(matrix.inViewport()) {
            g.drawPolygon(matrix.getBounds());
            g.drawString(this.name, matrix.centerPoint().x, matrix.centerPoint().y);
        }

        if(matrix.onMap()) {
            g.fillRect(matrix.mapPoint().x - 2, matrix.mapPoint().y - 2, 4, 4);
            g.drawString(this.name, matrix.mapPoint().x, matrix.mapPoint().y);
        }

//        for(Link link : links.values()) {
//            link.paint(ctx, g);
//        }
    }

    public String toString() {
        return name;
    }
}
