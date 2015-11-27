package org.booleanfloat.traveler.regions.kandarin;

import org.booleanfloat.traveler.Location;
import org.booleanfloat.traveler.interfaces.Region;
import org.booleanfloat.traveler.links.TwoWayLink;
import org.booleanfloat.traveler.steps.Step;
import org.powerbot.script.Area;
import org.powerbot.script.ClientContext;
import org.powerbot.script.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class EastArdougne implements Region {
    public static Location EastGate;
    public static Location GeneralStore;
    public static Location Market;
    public static Location NorthBank;
    public static Location NorthGate;
    public static Location PicnicArea;
    public static Location SouthBank;
    public static Location SouthGap;
    public static Location SouthZooEntrance;

    public static ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        locations.add(EastGate);
        locations.add(GeneralStore);
        locations.add(Market);
        locations.add(NorthBank);
        locations.add(NorthGate);
        locations.add(PicnicArea);
        locations.add(SouthBank);
        locations.add(SouthGap);
        locations.add(SouthZooEntrance);

        return locations;
    }

    public static void initLocations() {
        EastGate = new Location("EastArdougne, EastGate", new Area(
                new Tile(2689, 3306, 0),
                new Tile(2686, 3302, 0)
        ));

        GeneralStore = new Location("EastArdougne, GeneralStore", new Area(
                new Tile(2617, 3294, 0),
                new Tile(2612, 3290, 0)
        ));

        Market = new Location("EastArdougne, Market", new Area(
                new Tile(2666, 3317, 0),
                new Tile(2671, 3313, 0),
                new Tile(2671, 3295, 0),
                new Tile(2667, 3294, 0),
                new Tile(2657, 3295, 0),
                new Tile(2653, 3298, 0),
                new Tile(2653, 3311, 0),
                new Tile(2653, 3315, 0),
                new Tile(2656, 3317, 0)
        ));

        NorthBank = new Location("EastArdougne, NorthBank", new Area(
                new Tile(2621, 3335, 0),
                new Tile(2613, 3329, 0)
        ));

        NorthGate = new Location("EastArdougne, NorthGate", new Area(
                new Tile(2638, 3341, 0),
                new Tile(2634, 3337, 0)
        ));

        PicnicArea = new Location("EastArdougne, PicnicArea", new Area(
                new Tile(2725, 3341, 0),
                new Tile(2718, 3335, 0)
        ));

        SouthBank = new Location("EastArdougne, SouthBank", new Area(
                new Tile(2658, 3287, 0),
                new Tile(2651, 3279, 0)
        ));

        SouthGap = new Location("EastArdougne, SouthGap", new Area(
                new Tile(2641, 3263, 0),
                new Tile(2639, 3261, 0)
        ));

        SouthZooEntrance = new Location("EastArdougne, SouthZooEntrance", new Area(
                new Tile(2603, 3263, 0),
                new Tile(2600, 3261, 0)
        ));
    }

    public static void initLinks(ClientContext ctx) {
        new TwoWayLink(EastGate, Market);

        new TwoWayLink(EastGate, PicnicArea, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2688, 3304, 0)),
                new Step(new Tile(2691, 3306, 0)),
                new Step(new Tile(2699, 3322, 0)),
                new Step(new Tile(2718, 3327, 0)),
                new Step(new Tile(2722, 3338, 0))
        )));

        new TwoWayLink(GeneralStore, Market, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3292, 0)),
                new Step(new Tile(2614, 3297, 0)),
                new Step(new Tile(2629, 3296, 0)),
                new Step(new Tile(2637, 3299, 0)),
                new Step(new Tile(2643, 3305, 0)),
                new Step(new Tile(2662, 3305, 0))
        )));

        new TwoWayLink(GeneralStore, NorthBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3292, 0)),
                new Step(new Tile(2614, 3297, 0)),
                new Step(new Tile(2607, 3297, 0)),
                new Step(new Tile(2609, 3336, 0)),
                new Step(new Tile(2611, 3339, 0)),
                new Step(new Tile(2617, 3338, 0)),
                new Step(new Tile(2617, 3333, 0))
        )));

        new TwoWayLink(GeneralStore, SouthBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2614, 3293, 0)),
                new Step(new Tile(2614, 3296, 0)),
                new Step(new Tile(2630, 3296, 0)),
                new Step(new Tile(2634, 3289, 0)),
                new Step(new Tile(2643, 3287, 0)),
                new Step(new Tile(2643, 3283, 0)),
                new Step(new Tile(2652, 3283, 0))
        )));

        new TwoWayLink(GeneralStore, SouthZooEntrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2615, 3293, 0)),
                new Step(new Tile(2614, 3297, 0)),
                new Step(new Tile(2609, 3297, 0)),
                new Step(new Tile(2608, 3291, 0)),
                new Step(new Tile(2604, 3287, 0)),
                new Step(new Tile(2604, 3285, 0)),
                new Step(new Tile(2599, 3281, 0)),
                new Step(new Tile(2597, 3277, 0)),
                new Step(new Tile(2597, 3272, 0)),
                new Step(new Tile(2600, 3269, 0)),
                new Step(new Tile(2601, 3261, 0))
        )));

        new TwoWayLink(Market, NorthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2661, 3306, 0)),
                new Step(new Tile(2652, 3317, 0)),
                new Step(new Tile(2648, 3329, 0)),
                new Step(new Tile(2639, 3334, 0))
        )));

        new TwoWayLink(Market, SouthBank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2662, 3303, 0)),
                new Step(new Tile(2663, 3289, 0)),
                new Step(new Tile(2644, 3289, 0)),
                new Step(new Tile(2644, 3283, 0)),
                new Step(new Tile(2655, 3283, 0))
        )));

        new TwoWayLink(NorthBank, NorthGate, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2617, 3332, 0)),
                new Step(new Tile(2617, 3337, 0)),
                new Step(new Tile(2632, 3337, 0))
        )));

        new TwoWayLink(NorthGate, SeersVillage.Bank, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2636, 3340, 0)),
                new Step(new Tile(2636, 3373, 0)),
                new Step(new Tile(2645, 3374, 0)),
                new Step(new Tile(2646, 3391, 0)),
                new Step(new Tile(2643, 3400, 0)),
                new Step(new Tile(2647, 3407, 0)),
                new Step(new Tile(2645, 3425, 0)),
                new Step(new Tile(2647, 3433, 0)),
                new Step(new Tile(2656, 3442, 0)),
                new Step(new Tile(2673, 3459, 0)),
                new Step(new Tile(2673, 3465, 0)),
                new Step(new Tile(2682, 3472, 0)),
                new Step(new Tile(2706, 3483, 0)),
                new Step(new Tile(2725, 3484, 0))
        )));

        new TwoWayLink(PicnicArea, Catherby.GeneralStore, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2722, 3338, 0)),
                new Step(new Tile(2726, 3344, 0)),
                new Step(new Tile(2735, 3347, 0)),
                new Step(new Tile(2740, 3363, 0)),
                new Step(new Tile(2742, 3387, 0)),
                new Step(new Tile(2749, 3401, 0)),
                new Step(new Tile(2763, 3428, 0)),
                new Step(new Tile(2777, 3434, 0)),
                new Step(new Tile(2803, 3431, 0))
        )));

        new TwoWayLink(SouthBank, SouthGap, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2652, 3283, 0)),
                new Step(new Tile(2642, 3283, 0)),
                new Step(new Tile(2641, 3266, 0)),
                new Step(new Tile(2640, 3262, 0))
        )));

        new TwoWayLink(SouthGap, PortKhazard.Entrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2640, 3263, 0)),
                new Step(new Tile(2631, 3244, 0)),
                new Step(new Tile(2624, 3171, 0))
        )));

        new TwoWayLink(SouthZooEntrance, PortKhazard.Entrance, new ArrayList<>(Arrays.asList(
                new Step(new Tile(2600, 3262, 0)),
                new Step(new Tile(2602, 3244, 0)),
                new Step(new Tile(2619, 3217, 0)),
                new Step(new Tile(2625, 3208, 0)),
                new Step(new Tile(2624, 3174, 0))
        )));
    }
}
