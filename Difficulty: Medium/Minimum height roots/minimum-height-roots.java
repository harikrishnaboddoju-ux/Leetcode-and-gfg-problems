import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] degree = new int[V];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        
        int remainingNodes = V;
        while (remainingNodes > 2) {
            int size = q.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = q.poll();
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }
        
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        
        Collections.sort(result);
        return result;
    }
}