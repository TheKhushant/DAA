import java.util.ArrayList;

class Edge {
    int src, dest;

    // Constructor for the edge
    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

public class DFS2 {

    // Method to create the graph
    public static void createGraph(ArrayList<Edge>[] graph) {

        // Initializing the graph with empty lists
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // DFS function
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {  // O(V + E)
        // Visit the current node
        System.out.print(curr + " ");
        vis[curr] = true;

        // Visit all adjacent nodes (neighbors)
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis); // Recursively visit unvisited nodes
            }
        }
    }

    public static void main(String[] args) {
        int V = 7; // Number of vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Create the graph
        createGraph(graph);

        // Boolean array to keep track of visited nodes
        boolean[] vis = new boolean[V];

        // Perform DFS starting from vertex 0
        System.out.println("DFS Traversal starting from vertex 0:");
        dfs(graph, 0, vis);
    }
}
