package newstep.progression.leet;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal_589_Easy {

    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for(Node node: root.children)
            preorder(node);

        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            val = val;
        }

        public Node(int val, List<Node> children) {
            val = val;
            children = children;
        }
    };
}
