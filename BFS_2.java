import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_2 {

    // Edge class to represent a connection between two vertices
    static class Edge {
        int src;  // Source vertex
        int dest; // Destination vertex

        // Constructor to initialize the edge
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Method to create a graph by adding edges
    public static void createGraph(ArrayList<ArrayList<Edge>> graph, int V, Scanner sc) {
        // Initialize each element in the list with an empty ArrayList
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Edge>());
        }

        // Prompt user to input the number of edges
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (source and destination):");
        // Loop to input each edge
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt(); // Input source vertex
            int dest = sc.nextInt(); // Input destination vertex
            graph.get(src).add(new Edge(src, dest)); // Add edge to source's adjacency list
            graph.get(dest).add(new Edge(dest, src)); // Add edge to destination's adjacency list (undirected graph)
        }
    }

    // Method to perform Breadth-First Search (BFS) traversal
    public static void bfs(ArrayList<ArrayList<Edge>> graph, int V, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>(); // Queue to manage BFS traversal
        q.add(start); // Add the starting vertex to the queue

        while (!q.isEmpty()) { // Continue until the queue is empty
            int cur = q.remove(); // Remove and get the front element from the queue

            // Process the current vertex if not visited
            if (!visited[cur]) {
                System.out.print(cur + " "); // Print the current vertex
                visited[cur] = true; // Mark it as visited

                // Iterate through all adjacent vertices of the current vertex
                for (int i = 0; i < graph.get(cur).size(); i++) {
                    Edge e = graph.get(cur).get(i); // Get the adjacent edge
                    q.add(e.dest); // Add the destination vertex to the queue
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner to take user input

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt(); // Input the number of vertices

        // Using ArrayList of ArrayLists instead of array of ArrayLists
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        createGraph(graph, V, sc); // Call method to create the graph

        boolean[] visited = new boolean[V]; // Boolean array to track visited vertices
        System.out.println("BFS traversal:");

        // Traverse each vertex to handle disconnected graphs
        for (int i = 0; i < V; i++) {
            if (!visited[i]) { // Perform BFS if the vertex is not visited
                bfs(graph, V, visited, i);
            }
        }

        sc.close(); // Close the scanner
    }
}
