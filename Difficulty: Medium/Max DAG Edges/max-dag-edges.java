import java.util.*;

class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Build adjacency list and indegree array
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[V];
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            indeg[e[1]]++;
        }
        
        // Step 1: Get topological order (Kahn’s Algorithm)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indeg[i] == 0) q.add(i);
        
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int neigh : adj.get(node)) {
                indeg[neigh]--;
                if (indeg[neigh] == 0) q.add(neigh);
            }
        }

        // Step 2: Create a map from node -> its topo index
        int[] pos = new int[V];
        for (int i = 0; i < V; i++) pos[topo.get(i)] = i;

        // Step 3: Build reachability matrix
        boolean[][] existing = new boolean[V][V];
        for (int[] e : edges)
            existing[pos[e[0]]][pos[e[1]]] = true;

        // Step 4: Count possible new edges
        int count = 0;
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (!existing[i][j]) count++;
            }
        }

        return count;
    }
}
