package leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateBinarySearchTreeTest {

    @Test
    public void dummy() {
        new ValidateBinarySearchTree().isValidBST(new ValidateBinarySearchTree.TreeNode());
    }

    @Test
    public void case4() {
        var root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(2);
        root.right = new ValidateBinarySearchTree.TreeNode(2);
        Assertions.assertFalse(new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void case45() {
        var root = new ValidateBinarySearchTree.TreeNode(1);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        Assertions.assertFalse(new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void case47() {
        var root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(3);
        Assertions.assertTrue(new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void cas54() {
        var root = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(1);
        Assertions.assertFalse(new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void case57() {
        var root = new ValidateBinarySearchTree.TreeNode(3);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(5);
        root.left.left = new ValidateBinarySearchTree.TreeNode(0);
        root.left.right = new ValidateBinarySearchTree.TreeNode(2);
        root.right.left = new ValidateBinarySearchTree.TreeNode(4);
        root.right.right = new ValidateBinarySearchTree.TreeNode(6);
        Assertions.assertTrue(new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void case60() {
        var root = new ValidateBinarySearchTree.TreeNode(0);
        root.left = new ValidateBinarySearchTree.TreeNode(-1);
        Assertions.assertTrue(new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void case77() {
        var root = new ValidateBinarySearchTree.TreeNode(5);
        root.left = new ValidateBinarySearchTree.TreeNode(4);
        root.right = new ValidateBinarySearchTree.TreeNode(6);
        var nodeSix = root.right;
        nodeSix.left = new ValidateBinarySearchTree.TreeNode(3);
        nodeSix.right = new ValidateBinarySearchTree.TreeNode(7);
        Assertions.assertFalse(new ValidateBinarySearchTree().isValidBST(root));
    }

    @Test
    public void case81() {
        var root = new ValidateBinarySearchTree.TreeNode(32);
        root.left = new ValidateBinarySearchTree.TreeNode(26);
        root.left.left = new ValidateBinarySearchTree.TreeNode(19);
        root.left.left.right = new ValidateBinarySearchTree.TreeNode(27);
        root.right = new ValidateBinarySearchTree.TreeNode(47);
        root.right.right = new ValidateBinarySearchTree.TreeNode(56);
        Assertions.assertFalse(new ValidateBinarySearchTree().isValidBST(root));
    }

}
