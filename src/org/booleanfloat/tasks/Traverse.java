//package org.booleanfloat.tasks;
//
//import org.booleanfloat.traveler.Dijkstra;
//import org.booleanfloat.traveler.Link;
//import org.booleanfloat.traveler.Location;
//import org.booleanfloat.traveler.steps.Obstacle;
//import org.powerbot.script.Condition;
//import org.powerbot.script.Tile;
//import org.powerbot.script.rt4.ClientContext;
//import org.powerbot.script.rt4.Path;
//import org.powerbot.script.rt4.TilePath;
//
//import java.util.ArrayList;
//import java.util.EnumSet;
//import java.util.concurrent.Callable;
//
//public class Traverse extends Task<ClientContext> {
//    private Location start;
//    private Location end;
//    private ArrayList<Link> path;
//    private ArrayList<Obstacle> obstacles;
//    private Tile[] tilePath;
//
//    public Traverse(ClientContext ctx, Location start, Location end) {
//        super(ctx);
//
//        this.start = start;
//        this.end = end;
//
//        path = Dijkstra.getPath(start, end);
//        ArrayList<Tile> tiles = new ArrayList<>();
//        obstacles = new ArrayList<>();
//
//        for(Link link : path) {
//            tiles.addAll(link.getPath());
//            obstacles.addAll(link.getObstacles());
//        }
//
//        tilePath = tiles.toArray(new Tile[tiles.size()]);
//    }
//
//    @Override
//    public boolean activate() {
//        return !end.area.contains(ctx.players.local());
//    }
//
//    @Override
//    public void execute() {
//        boolean obstructingObstacle = false;
//
//        for(Obstacle obstacle : obstacles) {
//            if(obstacle.isObstructing(ctx)) {
//                obstructingObstacle = true;
//                System.out.println("traversing obstacle: " + obstacle);
//
//                if(obstacle.traverse(ctx)) {
//                    Condition.wait(new Callable<Boolean>() {
//                        @Override
//                        public Boolean call() throws Exception {
//                            return !obstacle.isObstructing(ctx);
//                        }
//                    }, 250, 4);
//                }
//
//                break;
//            }
//        }
//
//        TilePath path = ctx.movement.newTilePath(tilePath).randomize(2, 2);
//        System.out.println(path.next());
//
//        if(!obstructingObstacle && path.traverse(EnumSet.of(Path.TraversalOption.SPACE_ACTIONS))) {
//            System.out.println("following path");
//
//            Condition.wait(new Callable<Boolean>() {
//                @Override
//                public Boolean call() throws Exception {
//                    int dx = ctx.players.local().tile().x() - ctx.movement.destination().x();
//                    int dy = ctx.players.local().tile().y() - ctx.movement.destination().y();
//
//                    return Math.abs(dx) < 2 && Math.abs(dy) < 5;
//                }
//            }, 250, 5);
//        }
//    }
//
//}
