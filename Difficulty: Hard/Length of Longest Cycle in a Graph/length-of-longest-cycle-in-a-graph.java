import java.util.Arrays;

class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] adj = new int[V];
        Arrays.fill(adj, -1);
        
        for (int[] edge : edges) {
            adj[edge[0]] = edge[1];
        }
        
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        int[] pathId = new int[V];
        int currentPathId = 0;
        int ans = -1;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                currentPathId++;
                int curr = i;
                int d = 0;
                
                while (curr != -1 && !visited[curr]) {
                    visited[curr] = true;
                    dist[curr] = d++;
                    pathId[curr] = currentPathId;
                    curr = adj[curr];
                }
                
                if (curr != -1 && pathId[curr] == currentPathId) {
                    ans = Math.max(ans, d - dist[curr]);
                }
            }
        }
        
        return ans;
    }
}