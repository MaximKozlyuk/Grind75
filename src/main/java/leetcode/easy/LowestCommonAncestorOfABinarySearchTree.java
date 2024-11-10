package leetcode.easy;

import java.util.Stack;

public class LowestCommonAncestorOfABinarySearchTree {

    // Definition for a binary tree node.
    // can't be changed.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
     * All Node.val are unique.
     * p != q; p and q will exist in the BST.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var pPath = findNode(root, p);
        var qPath = findNode(root, q);
        makePathsLengthEqual(pPath, qPath);
        while (pPath.peek().val != qPath.peek().val) {
            pPath.pop();
            qPath.pop();
        }
        return pPath.peek();
    }

    private void makePathsLengthEqual(Stack<TreeNode> pPath, Stack<TreeNode> qPath) {
        Stack<TreeNode> longerPath;
        Stack<TreeNode> shorterPath;
        if (pPath.size() > qPath.size()) {
            longerPath = pPath;
            shorterPath = qPath;
        } else if (pPath.size() < qPath.size()) {
            longerPath = qPath;
            shorterPath = pPath;
        } else {
            return;
        }
        while (longerPath.size() != shorterPath.size()) {
            longerPath.pop();
        }
    }

    private Stack<TreeNode> findNode(TreeNode root, TreeNode toSearch) {
        var path = new Stack<TreeNode>();
        path.add(root);
        var currentNode = root;
        for (; ; ) {
            if (currentNode.val == toSearch.val) {
                path.add(currentNode);
                return path;
            }
            path.add(currentNode);
            if (toSearch.val < currentNode.val) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
    }

}
