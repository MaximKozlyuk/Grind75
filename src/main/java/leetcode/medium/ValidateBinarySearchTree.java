package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/validate-binary-search-tree
 */
public final class ValidateBinarySearchTree {

    // Definition for a binary tree node.
    public static final class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        var resultArray = new ArrayList<TreeNode>(3);
        resultArray.add(root);
        var currentLayer = new ArrayList<TreeNode>(1);
        currentLayer.add(root);
        while (!currentLayer.isEmpty()) {
            var nextLayer = new ArrayList<TreeNode>(currentLayer.size() * 2);
            for (TreeNode treeNode : currentLayer) {
                if (treeNode.left != null) {
                    resultArray.add(treeNode.left);
                    nextLayer.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    resultArray.add(treeNode.right);
                    nextLayer.add(treeNode.right);
                }
            }
            currentLayer = nextLayer;
        }
        var sortedNodes = resultArray.stream()
                .sorted(Comparator.comparingInt(n -> n.val))
                .toList();
        return resultArrayValid(sortedNodes, root);
    }

    private boolean resultArrayValid(List<TreeNode> sortedNodes, TreeNode root) {
        if (sortedNodes.size() == 2) {
            var first = sortedNodes.getFirst();
            var last = sortedNodes.getLast();
            return (last.left == first || first.right == last)
                    && last.val > first.val;
        }

        var uniqueValues = new HashSet<>(sortedNodes.stream().map(n -> n.val).toList());
        if (uniqueValues.size() != sortedNodes.size()) {
            return false;
        }

        for (int i = 0; i < sortedNodes.size(); i++) {
            if (!findNodeByValFrom(sortedNodes.get(i).val, root)) {
                return false;
            }
        }
        return true;
    }

    private boolean findNodeByValFrom(int valToFind, TreeNode searchRoot) {
        var currentNode = searchRoot;
        while (currentNode.val != valToFind) {
            currentNode = valToFind < currentNode.val
                    ? currentNode.left : currentNode.right;
            if (currentNode == null) {
                break;
            }
        }
        return currentNode != null;
    }

    // bfs attempt, does not respecting above nodes, failing on case [32,26,47,19,null,null,56,null,27] -> false
//    public boolean isValidBST(TreeNode root) {
//        if (root.left == null && root.right == null) {
//            return true;
//        }
//        if (root.left != null) {
//            if (!(root.left.val < root.val)) {
//                return false;
//            }
//        }
//        if (root.right != null) {
//            if (!(root.right.val > root.val)) {
//                return false;
//            }
//        }
//        var isLeftValid = root.left == null || validSubtree(root.val, root.left, true);
//        var isRightValid = root.right == null || validSubtree(root.val, root.right, false);
//        return isLeftValid && isRightValid;
//    }
//
//    private boolean validSubtree(int theRootVal, TreeNode sideRoot, boolean isLeft) {
//        var currentLayer = new ArrayList<TreeNode>(1);
//        currentLayer.add(sideRoot);
//
//        while (!currentLayer.isEmpty()) {
//            var nextLayer = new ArrayList<TreeNode>(currentLayer.size() * 2);
//            for (TreeNode treeNode : currentLayer) {
//                var nodeVal = treeNode.val;
//                if (treeNode.left != null) {
//                    nextLayer.add(treeNode.left);
//                    var left = treeNode.left.val;
//                    if (!(left < nodeVal
//                            && isLeft ? left < theRootVal : left > theRootVal)) {
//                        return false;
//                    }
//                }
//                if (treeNode.right != null) {
//                    nextLayer.add(treeNode.right);
//                    var right = treeNode.right.val;
//                    if (!(right > nodeVal
//                            && isLeft ? right < theRootVal : right > theRootVal)) {
//                        return false;
//                    }
//                }
//            }
//            currentLayer = nextLayer;
//
//        }
//        return true;
//    }

}
