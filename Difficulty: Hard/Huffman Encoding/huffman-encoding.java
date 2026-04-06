import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    class Node implements Comparable<Node> {
        int data;
        int minIdx;
        Node left, right;

        Node(int data, int minIdx) {
            this.data = data;
            this.minIdx = minIdx;
        }

        public int compareTo(Node other) {
            if (this.data == other.data) {
                return Integer.compare(this.minIdx, other.minIdx);
            }
            return Integer.compare(this.data, other.data);
        }
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        return buildCodes(f);
    }

    public ArrayList<String> huffmanCodes(String S, int f[]) {
        return buildCodes(f);
    }

    private ArrayList<String> buildCodes(int[] f) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < f.length; i++) {
            pq.add(new Node(f[i], i));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.data + right.data, Math.min(left.minIdx, right.minIdx));
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        ArrayList<String> res = new ArrayList<>();
        if (!pq.isEmpty()) {
            preorder(pq.poll(), "", res);
        }

        return res;
    }

    private void preorder(Node root, String code, ArrayList<String> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(code.isEmpty() ? "0" : code);
            return;
        }
        preorder(root.left, code + "0", res);
        preorder(root.right, code + "1", res);
    }
}