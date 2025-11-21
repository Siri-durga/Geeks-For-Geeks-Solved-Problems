class Solution {
    static class Pair {
        int node, wt;
        Pair(int n, int w) { node = n; wt = w; }
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Build graph using only straight edges (w1)
        for (int[] e : edges) {
            int x = e[0], y = e[1], w1 = e[2];
            adj.get(x).add(new Pair(y, w1));
            adj.get(y).add(new Pair(x, w1));
        }

        // Dijkstra from a and from b
        int[] distA = dijkstra(V, a, adj);
        int[] distB = dijkstra(V, b, adj);

        long ans = distA[b];  // straight-only path

        // Try using exactly ONE curved edge
        long best = Long.MAX_VALUE;

        for (int[] e : edges) {
            int x = e[0], y = e[1], w2 = e[3];

            if (distA[x] != Integer.MAX_VALUE && distB[y] != Integer.MAX_VALUE)
                best = Math.min(best, (long) distA[x] + w2 + distB[y]);

            if (distA[y] != Integer.MAX_VALUE && distB[x] != Integer.MAX_VALUE)
                best = Math.min(best, (long) distA[y] + w2 + distB[x]);
        }

        ans = Math.min(ans, best);

        return ans >= Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private int[] dijkstra(int V, int src, List<List<Pair>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int d = cur.wt;

            if (d > dist[node]) continue;

            for (Pair p : adj.get(node)) {
                int nxt = p.node;
                int w = p.wt;

                if (dist[node] + w < dist[nxt]) {
                    dist[nxt] = dist[node] + w;
                    pq.add(new Pair(nxt, dist[nxt]));
                }
            }
        }
        return dist;
    }
}
