package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthOfBinaryTree {

    // Definition for a binary tree node.
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
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var layers = new ArrayList<List<TreeNode>>(128);
        var currentLayer = new ArrayList<TreeNode>(1);
        currentLayer.add(root);
        while (!currentLayer.isEmpty()) {
            layers.add(currentLayer);
            var newLayer = new ArrayList<TreeNode>(currentLayer.size() * 2);
            for (TreeNode node : currentLayer) {
                if (node.left != null) {
                    newLayer.add(node.left);
                }
                if (node.right != null) {
                    newLayer.add(node.right);
                }
            }
            currentLayer = newLayer;
        }
        return layers.size();
    }

}
