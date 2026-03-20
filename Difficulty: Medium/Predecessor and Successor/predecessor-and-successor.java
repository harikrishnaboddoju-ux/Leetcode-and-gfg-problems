/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node predecessor = null;
        Node successor = null;
        Node curr = root;

        while (curr != null) {
            if (curr.data < key) {
                predecessor = curr;
                curr = curr.right;
            } else if (curr.data > key) {
                successor = curr;
                curr = curr.left;
            } else {
                Node leftChild = curr.left;
                while (leftChild != null) {
                    predecessor = leftChild;
                    leftChild = leftChild.right;
                }

                Node rightChild = curr.right;
                while (rightChild != null) {
                    successor = rightChild;
                    rightChild = rightChild.left;
                }
                break;
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        return result;
    }
}