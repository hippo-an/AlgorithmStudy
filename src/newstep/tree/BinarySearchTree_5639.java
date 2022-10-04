package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree_5639 {

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
        System.out.println(sb);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val).append("\n");
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public void insert(int val) {
            if (val < this.val) {
                if (left == null) left = new Node(val);
                else left.insert(val);
            } else {
                if (right == null) right = new Node(val);
                else right.insert(val);
            }
        }
    }
}
