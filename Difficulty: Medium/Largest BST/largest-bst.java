class Solution {
    static class Info {
        int min;
        int max;
        int size;
        boolean isBST;
        
        Info(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }
    
    static int largestBst(Node root) {
        return postOrder(root).size;
    }
    
    static Info postOrder(Node node) {
        if (node == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        
        Info left = postOrder(node.left);
        Info right = postOrder(node.right);
        
        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int min = Math.min(node.data, left.min);
            int max = Math.max(node.data, right.max);
            return new Info(min, max, left.size + right.size + 1, true);
        }
        
        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size), false);
    }
}