import java.util.*;

// Class to represent a graph
class Graph {

	// No. of vertices
	private int V;

	// Pointer to an array containing
	// adjacency lists
	private List<Integer>[] adj;

	// A function used by NumOfNodes
	private void DFS(boolean[] visited, int src, int[] currLevel, int level, int[] numOfNodes) {
		// Mark the current vertex as visited
		visited[src] = true;

		// If current level is equal
		// to the given level, increment
		// the no. of nodes
		if (level == currLevel[0]) {
			numOfNodes[0]++;
		} else if (level < currLevel[0]) {
			return;
		} else {
			// Recur for the vertices
			// adjacent to the current vertex
			for (int neighbor : adj[src]) {
				if (!visited[neighbor]) {
					currLevel[0]++;
					DFS(visited, neighbor, currLevel, level, numOfNodes);
				}
			}
		}
		currLevel[0]--;
	}

	// Constructor
	public Graph(int V) {
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
	}

	// Function to add an edge to the graph
	public void addEdge(int src, int des) {
		adj[src].add(des);
		adj[des].add(src);
	}

	// Function to return the number of nodes at a given level
	public int numOfNodes(int level) {
		// To keep track of the current level
		int[] currLevel = { 0 };

		// For keeping track of visited
		// nodes in DFS
		boolean[] visited = new boolean[V];

		// To store count of nodes at a
		// given level
		int[] numOfNodes = { 0 };

		DFS(visited, 0, currLevel, level, numOfNodes);

		return numOfNodes[0];
	}
}



