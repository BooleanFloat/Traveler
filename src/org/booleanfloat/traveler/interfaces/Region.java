package org.booleanfloat.traveler.interfaces;

import org.booleanfloat.traveler.Location;
import org.powerbot.script.ClientContext;

import java.util.ArrayList;

public interface Region {
    static ArrayList<Location> getLocations() { return null; }
    static void initLocations() {}
    static void initLinks(ClientContext ctx) {}
}
