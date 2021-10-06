package inflearn.recursive_tree_graph;
/**
 * 이진트리 순회(넓이우선탐색 : 레벨탐색)
 * 아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
 * 1
 * 2 3
 * 4 5 6 7
 * 레벨 탐색 순회 출력 : 1 2 3 4 5 6 7
 */

import java.util.LinkedList;
import java.util.Queue;

public class BFSBasic {

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root ;
    private void dfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int l = 0;

        while(!q.isEmpty()) {
            int len = q.size();
            System.out.print(l + " : " );

            for(int i = 0; i < len; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                if(curr.lt != null) q.offer(curr.lt);
                if(curr.rt != null) q.offer(curr.rt);
            }
            l++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BFSBasic main = new BFSBasic();

        main.root = new BFSBasic.Node(1);
        main.root.lt = new BFSBasic.Node(2);
        main.root.rt = new BFSBasic.Node(3);
        main.root.lt.lt = new BFSBasic.Node(4);
        main.root.lt.rt = new BFSBasic.Node(5);
        main.root.rt.lt = new BFSBasic.Node(6);
        main.root.rt.rt = new BFSBasic.Node(7);
        main.dfs(main.root);
    }

}
