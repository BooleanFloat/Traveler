package org.booleanfloat.traveler;

import org.booleanfloat.traveler.links.Link;

import java.util.*;

class Vertex implements Comparable<Vertex> {

    public double minDistance = Double.POSITIVE_INFINITY;
    public ArrayList<Edge> edges;
    public Location location;
    public Vertex previous;

    public Vertex(Location location) {
        this.location = location;
        edges = new ArrayList<>();
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Dijkstra {
    private static HashMap<Location, Vertex> vertices;
    private static HashMap<String, ArrayList<Link>> paths;

    public static void init(Location[] locations) {
        vertices = new HashMap<>();
        paths = new HashMap<>();

        for(Location location : locations) {
            vertices.put(location, new Vertex(location));
        }

        for(Vertex vertex : vertices.values()) {
            for (Link link : vertex.location.links.values()) {
                Vertex target = vertices.get(link.getOtherLocation(vertex.location));
                vertex.edges.add(new Edge(target, link.getWeight()));
            }
        }
    }

    public static ArrayList<Link> getLinks(Location start, Location end) {
        String name = start.name + " - " + end.name;

        ArrayList<Link> path = paths.get(name);

        if(path != null) {
            return path;
        }
        else {
            path = new ArrayList<>();

            reset();
            computePaths(vertices.get(start));
            ArrayList<Vertex> locations = getShortestPathTo(vertices.get(end));

            for(int i = 0; i < locations.size() - 1; i++) {
                Vertex vertex = locations.get(i);
                Vertex next = locations.get(i + 1);

                path.add(vertex.location.links.get(next.location));
            }

            paths.put(name, path);

            return path;
        }
    }

    private static void reset() {
        for(Vertex vertex : vertices.values()) {
            vertex.minDistance = Double.POSITIVE_INFINITY;
            vertex.previous = null;
        }
    }

    private static void computePaths(Vertex source) {
        source.minDistance = 0.0;

        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex vertex = vertexQueue.poll();

            for (Edge edge : vertex.edges) {
                Vertex target = edge.target;

                if(target == null) {
                    continue;
//                    System.out.println(source.location);
                }

                double weight = edge.weight;
                double distance = vertex.minDistance + weight;

                if (distance < target.minDistance) {
                    vertexQueue.remove(target);
                    target.minDistance = distance;
                    target.previous = vertex;
                    vertexQueue.add(target);
                }
            }
        }
    }

    private static ArrayList<Vertex> getShortestPathTo(Vertex target) {
        ArrayList<Vertex> path = new ArrayList<>();

        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}
