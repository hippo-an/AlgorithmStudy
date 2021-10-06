package inflearn.recursive_tree_graph;

/**
 * 이진트리 순회(깊이우선탐색)
 * 아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
 * 1
 * 2 3
 * 4 5 6 7
 * 전위순회 출력 : 1 2 4 5 3 6 7
 * 중위순회 출력 : 4 2 5 1 6 3 7
 * 후위순회 출력 : 4 5 2 6 7 3 1
 */


public class Tree {

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;
    public void depthFirstSearch(Node root) {
        if(root == null) return;
        else {
            depthFirstSearch(root.lt);
            System.out.println(root.data);
            depthFirstSearch(root.rt);
        }
    }
    public static void main(String[] args) {
        Tree main = new Tree();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        main.root.rt.lt = new Node(6);
        main.root.rt.rt = new Node(7);

        main.depthFirstSearch(main.root);

    }
}
