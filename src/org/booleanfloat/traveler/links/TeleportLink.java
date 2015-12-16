package org.booleanfloat.traveler.links;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.Resources;
import org.booleanfloat.traveler.Traveler;
import org.booleanfloat.traveler.interfaces.Traversable;
import org.booleanfloat.traveler.steps.Spell;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Magic;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TeleportLink extends Link {
    private Magic.Spell spell;

    public TeleportLink(Location end, Magic.Spell spell, Callable<Boolean> requirement) {
        this.start = new Location("Teleport", new Area(new Tile(0,0,0), new Tile(0,0,0)));
        this.end = end;
        this.spell = spell;
        this.requirement = requirement;

        steps = new ArrayList<Traversable>();
        steps.add(new Spell(spell));

        Tile tile = end.area.getCentralTile();

        for(Location location: Traveler.getLocations()) {
            if(location.area.getCentralTile().distanceTo(tile) > Resources.teleportThreshold) {
                location.addLink(end, this);
            }
        }
    }

    @Override
    public Location getOtherLocation(Location location) {
        return end;
    }

    @Override
    public double getWeight() {
        return 50;
    }

    @Override
    public String toString() {
        return "Teleport -> " + this.end;
    }
}
