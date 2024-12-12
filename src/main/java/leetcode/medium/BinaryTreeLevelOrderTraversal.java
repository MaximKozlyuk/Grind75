package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    // can't change
    public class TreeNode {
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

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        var currentLayer = new ArrayList<TreeNode>(1);
        currentLayer.add(root);
        while (!currentLayer.isEmpty()) {
            var newLayer = new ArrayList<TreeNode>(currentLayer.size() * 2);
            var currentResult = new ArrayList<Integer>(currentLayer.size());
            for (TreeNode node : currentLayer) {
                currentResult.add(node.val);
                if (node.left != null) {
                    newLayer.add(node.left);
                }
                if (node.right != null) {
                    newLayer.add(node.right);
                }
            }
            result.add(currentResult);
            currentLayer = newLayer;
        }

        return result;
    }

}
