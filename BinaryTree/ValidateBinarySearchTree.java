/*Question : Given the root of a binary tree, determine whether it is a valid Binary Search Tree (BST).
    A valid BST must satisfy:
      *  Every node in the left subtree has a value strictly less than the node's value.
      *  Every node in the right subtree has a value strictly greater than the node's value.
      *  Both left and right subtrees must themselves be valid BSTs. */
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

import java.util.ArrayList;

public class ValidateBinarySearchTree {
    public static void inorder(TreeNode root, ArrayList<Integer> nodeValues) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodeValues);
        nodeValues.add(root.val);
        inorder(root.right, nodeValues);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> nodeValues = new ArrayList<>();
        inorder(root, nodeValues);

        for (int i = 0; i < nodeValues.size() - 1; i++) {
            if (nodeValues.get(i) >= nodeValues.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(25);

        System.out.println(isValidBST(root));
    }
}
