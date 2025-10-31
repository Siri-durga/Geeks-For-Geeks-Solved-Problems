import java.util.*;

class Solution {
    public int shortCycle(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int shortest = Integer.MAX_VALUE;

        // Step 2: Perform BFS from every vertex
        for (int src = 0; src < V; src++) {
            int[] dist = new int[V];
            int[] parent = new int[V];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            dist[src] = 0;

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        q.add(v);
                    } 
                    else if (parent[u] != v) {
                        // Found a cycle
                        int cycleLen = dist[u] + dist[v] + 1;
                        shortest = Math.min(shortest, cycleLen);
                    }
                }
            }
        }

        return (shortest == Integer.MAX_VALUE) ? -1 : shortest;
    }
}
