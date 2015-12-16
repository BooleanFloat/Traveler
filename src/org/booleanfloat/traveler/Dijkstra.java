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
        edges = new ArrayList<Edge>();
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge {
    public final Vertex target;
    public final Link link;

    public Edge(Vertex target, Link link) {
        this.target = target;
        this.link = link;
    }
}

public class Dijkstra {
    private static HashMap<Location, Vertex> vertices;

    public static void init(Location[] locations) {
        vertices = new HashMap<Location, Vertex>();

        for(Location location : locations) {
            vertices.put(location, new Vertex(location));
        }

        for(Vertex vertex : vertices.values()) {
            for (Link link : vertex.location.links.values()) {
                Vertex target = vertices.get(link.getOtherLocation(vertex.location));
                vertex.edges.add(new Edge(target, link));
            }
        }
    }

    public static ArrayList<Link> getLinks(Location start, Location end) {
        ArrayList<Link> path = new ArrayList<Link>();

        reset();
        computePaths(vertices.get(start));
        ArrayList<Vertex> locations = getShortestPathTo(vertices.get(end));

        for(int i = 0; i < locations.size() - 1; i++) {
            Vertex vertex = locations.get(i);
            Vertex next = locations.get(i + 1);

            path.add(vertex.location.links.get(next.location));
        }

        return path;
    }

    private static void reset() {
        for(Vertex vertex : vertices.values()) {
            vertex.minDistance = Double.POSITIVE_INFINITY;
            vertex.previous = null;
        }
    }

    private static void computePaths(Vertex source) {
        source.minDistance = 0.0;

        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex vertex = vertexQueue.poll();

            for (Edge edge : vertex.edges) {
                Vertex target = edge.target;

                if(target == null) {
                    continue;
                }

                double weight = edge.link.getWeight();
                double distance = vertex.minDistance + weight;

                if (edge.link.hasRequirements() && distance < target.minDistance) {
                    vertexQueue.remove(target);
                    target.minDistance = distance;
                    target.previous = vertex;
                    vertexQueue.add(target);
                }
            }
        }
    }

    private static ArrayList<Vertex> getShortestPathTo(Vertex target) {
        ArrayList<Vertex> path = new ArrayList<Vertex>();
        double weight = 0;

        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
            weight += vertex.minDistance;
        }

        Collections.reverse(path);
        return path;
    }
}
