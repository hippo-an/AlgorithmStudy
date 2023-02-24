package newstep.progression.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102_Medium {

    public List<List<Integer>> tree = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return tree;
        }
        Queue<Integer> idxQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        int depth = 0;
        idxQueue.add(depth);
        nodeQueue.add(root);

        List<Integer> depthList = new ArrayList<>();
        while (!idxQueue.isEmpty() && !nodeQueue.isEmpty()) {
            Integer idx = idxQueue.remove();
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                continue;
            }

            if (idx != depth) {
                depth = idx;
                tree.add(depthList);
                depthList = new ArrayList<>();
            }

            depthList.add(node.val);

            if (node.left != null) {
                idxQueue.add(idx + 1);
                nodeQueue.add(node.left);
            }

            if (node.right != null) {
                idxQueue.add(idx + 1);
                nodeQueue.add(node.right);
            }
        }
        tree.add(depthList);

        return tree;
    }

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    private void levelHelper(List<List<Integer>> res, TreeNode root, int idx) {
        if (root == null) {
            return;
        }
        if (res.size() == idx) {
            res.add(new ArrayList<>());
        }

        res.get(idx).add(root.val);
        levelHelper(res, root.left, idx + 1);
        levelHelper(res, root.right, idx + 1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
