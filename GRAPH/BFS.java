import java.util.*;
class Graph {
    private int V; 
    private LinkedList<Integer>[] adjList; 
    public Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];  
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>(); 
        }
    }
    public void addEdge(int v, int w) {
        adjList[v].add(w); 
        adjList[w].add(v); 
    }
    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        System.out.println("Breadth First Search starting from vertex " + s + ":");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            Iterator<Integer> it = adjList[vertex].listIterator();
            while (it.hasNext()) {
                int adjVertex = it.next();
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
        System.out.println(); 
    }
}
public class BFSGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(6); 
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.BFS(0);
    }
}
