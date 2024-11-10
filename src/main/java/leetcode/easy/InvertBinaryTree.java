package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTree {

    // Definition for a binary tree node.
    // given by task - cant change!
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
     * https://leetcode.com/problems/invert-binary-tree/
     */
    public TreeNode invertTree(TreeNode root) {
        List<TreeNode> currentLayer = new ArrayList<>(1);
        List<TreeNode> nextLayer;

        currentLayer.add(root);
        do {
            invertLayer(currentLayer);
            nextLayer = new ArrayList<>(currentLayer.size() * 2);
            for (TreeNode currentNode : currentLayer) {
                if (currentNode != null) {
                    nextLayer.add(currentNode.left);
                    nextLayer.add(currentNode.right);
                }
            }
            currentLayer = nextLayer;
        } while (!currentLayer.isEmpty());

        return root;
    }

    private void invertLayer(List<TreeNode> layer) {
        for (TreeNode node : layer) {
            if (node != null) {
                invertNode(node);
            }
        }
    }

    private void invertNode(TreeNode node) {
        TreeNode nodeLeft = node.left;
        node.left = node.right;
        node.right = nodeLeft;
    }

}
