import java.util.*;

public class BF5 {

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] bellmanFord(int vertices, List<Edge> edges, int source) {
        // Step 1: Initialize distances
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Step 2: Relax edges repeatedly
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.w < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.w;
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.w < dist[edge.v]) {
                System.out.println("Graph contains a negative weight cycle!");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>(Arrays.asList(
            new Edge(0, 1, 1),
            new Edge(0, 2, 4),
            new Edge(1, 2, -3),
            new Edge(1, 3, 2),
            new Edge(2, 3, 3)
        ));

        int vertices = 4, source = 0;
        int[] distances = bellmanFord(vertices, edges, source);

        if (distances != null) {
            System.out.println("Shortest distances from source: " + Arrays.toString(distances));
        }
    }
}