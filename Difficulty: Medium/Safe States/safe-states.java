import java.util.*;

class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Step 1: Build reverse graph and indegree array
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) rev.add(new ArrayList<>());

        int[] indeg = new int[V];
        for (int[] e : edges) {
            rev.get(e[1]).add(e[0]); // reverse edge
            indeg[e[0]]++; // indegree in reversed graph
        }

        // Step 2: Kahn's algorithm - start from nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        // Step 3: Process nodes and reduce indegree
        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int nei : rev.get(node)) {
                indeg[nei]--;
                if (indeg[nei] == 0) q.add(nei);
            }
        }

        // Step 4: Collect all safe nodes
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) ans.add(i);
        }

        Collections.sort(ans);
        return ans;
    }
}
