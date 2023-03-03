package newstep.progression.leet;

import java.util.ArrayList;
import java.util.List;
import newstep.progression.leet.BinaryTreeLevelOrderTraversal_102_Medium.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree_235_Medium {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);

        while (root != null) {
            if (root.val > large) {
                root = root.left;
            } else if (root.val < small) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }
}
