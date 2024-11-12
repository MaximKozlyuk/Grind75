package leetcode.easy;


public class DiameterOfBinaryTree {

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

    private int maxI = 0;

    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = diameterOfSubtree(root.left) + diameterOfSubtree(root.right);
        return Math.max(ans, maxI);
    }

    private int diameterOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfSubtree(root.left);
        int right = diameterOfSubtree(root.right);
        maxI = Math.max(maxI, left + right);
        return 1 + Math.max(left, right);
    }

}
