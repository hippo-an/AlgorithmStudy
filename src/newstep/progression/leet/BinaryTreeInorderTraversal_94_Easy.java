package newstep.progression.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import newstep.progression.leet.BinaryTreeLevelOrderTraversal_102_Medium.TreeNode;

public class BinaryTreeInorderTraversal_94_Easy {

    private final List<Integer> ret = new ArrayList<>();

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        traversalHelper(root);
        return ret;
    }

    private void traversalHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        traversalHelper(root.left);
        ret.add(root.val);
        traversalHelper(root.right);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            ret.add(root.val);
            root = root.right;
        }

        return ret;
    }

}
