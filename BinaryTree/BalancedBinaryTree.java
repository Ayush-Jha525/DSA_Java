/*Question : Given the root of a binary tree, determine whether the tree is height-balanced.
A binary tree is height-balanced if, for every node, the difference between the heights of its left and right subtrees is at most 1.*/
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

public class BalancedBinaryTree {
    static boolean isBalanced = true;

    public static int balanced(TreeNode root) {
        if (!isBalanced) {
            return -1;
        }
        if (root == null) {
            return 0;
        }
        int left = balanced(root.left);
        int right = balanced(root.right);

        if (Math.abs(left - right) != 1 && left - right != 0) {
            isBalanced = false;
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static boolean isBalancedTree(TreeNode root) {
        balanced(root);
        return isBalanced;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(5);

        System.out.println(isBalancedTree(root)); // Output : false

    }
}
