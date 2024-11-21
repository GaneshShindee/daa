import java.util.*; // Importing the required package for Scanner and List

class KruskalSimple {
    int vertices; // Number of vertices in the graph
    int[] parent; // Array to represent the parent of each node for union-find

    // Class to represent an edge with source, destination, and weight
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src; // Source vertex
            this.dest = dest; // Destination vertex
            this.weight = weight; // Weight of the edge
        }
    }

    // Constructor to initialize the graph with the number of vertices
    public KruskalSimple(int vertices) {
        this.vertices = vertices; // Set the number of vertices
        parent = new int[vertices]; // Initialize the parent array
        for (int i = 0; i < vertices; i++) parent[i] = i; // Each vertex is its own parent initially
    }

    // Function to find the representative of a set with path compression
    int find(int i) {
        if (parent[i] != i) // If i is not its own parent
            parent[i] = find(parent[i]); // Recursively find and compress the path
        return parent[i]; // Return the representative
    }

    // Function to union two sets
    void union(int u, int v) {
        parent[find(u)] = find(v); // Attach the set of u to the set of v
    }

    // Function to perform Kruskal's algorithm and find the MST
    void kruskalMST(List<Edge> edges) {
        // Sort the edges by weight in ascending order
        edges.sort(Comparator.comparingInt(e -> e.weight));

        int mstWeight = 0; // Initialize the total weight of the MST
        System.out.println("Edges in MST:"); // Output header for MST edges

        // Iterate through all edges
        for (Edge edge : edges) {
            int u = find(edge.src); // Find the representative of the source vertex
            int v = find(edge.dest); // Find the representative of the destination vertex

            // If the source and destination are in different sets (no cycle)
            if (u != v) {
                System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight); // Print the edge
                mstWeight += edge.weight; // Add the weight to the total MST weight
                union(u, v); // Union the sets of the source and destination
            }
        }

        // Output the total weight of the MST
        System.out.println("Total weight of MST: " + mstWeight);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input

        System.out.print("Enter the number of vertices: "); // Prompt for number of vertices
        int vertices = scanner.nextInt(); // Read the number of vertices

        System.out.print("Enter the number of edges: "); // Prompt for number of edges
        int edgeCount = scanner.nextInt(); // Read the number of edges

        KruskalSimple graph = new KruskalSimple(vertices); // Create a KruskalSimple object with the given vertices
        List<Edge> edges = new ArrayList<>(); // Create a list to store edges

        System.out.println("Enter the edges (source, destination, weight):"); // Prompt for edge input
        for (int i = 0; i < edgeCount; i++) { // Loop to read all edges
            int src = scanner.nextInt(); // Read source vertex
            int dest = scanner.nextInt(); // Read destination vertex
            int weight = scanner.nextInt(); // Read weight of the edge
            edges.add(new Edge(src, dest, weight)); // Add the edge to the list
        }

        graph.kruskalMST(edges); // Run Kruskal's algorithm to find the MST
    }
}
