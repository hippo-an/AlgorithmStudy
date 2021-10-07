package inflearn.ch07_recursive_tree_graph;
/**
 * Tree 말단 노드까지의 가장 짧은 경로
 * 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를
 * 구하는 프로그램을 작성하세요.
 * 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를
 * 길이로 하겠습니다.
 * 1
 * 2 3
 * 4 5
 * 가장 짧은 길이는 3번 노느까지의 길이인 1이다.
 */

import java.util.*;

public class TreeLeafNodeShortest_BFS {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            this.data = val;
            lt = rt = null;
        }
    }

    Node root;

    public static void main(String[] args) {
        TreeLeafNodeShortest_BFS main = new TreeLeafNodeShortest_BFS();
        main.root = new Node(1);
        main.root.lt = new Node(2);
        main.root.rt = new Node(3);
        main.root.lt.lt = new Node(4);
        main.root.lt.rt = new Node(5);
        System.out.println(main.bfs(main.root));

    }

    private int bfs(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int l = 0;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                Node curr = q.poll();

                if(curr.lt == null && curr.rt == null) return l;

                if(curr.lt != null) q.offer(curr.lt);
                if(curr.rt != null) q.offer(curr.rt);
            }
            l++;
        }
        return -1;
    }
}
