import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Solution {
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();

        q.add(root);
        hdQueue.add(0);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int hd = hdQueue.poll();

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(curr.data);

            if (curr.left != null) {
                q.add(curr.left);
                hdQueue.add(hd - 1);
            }

            if (curr.right != null) {
                q.add(curr.right);
                hdQueue.add(hd + 1);
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}