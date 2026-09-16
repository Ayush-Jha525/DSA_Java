/*Question : Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of TreeNodes along the longest path from the root TreeNode down to the farthest leaf TreeNode. */
//Time Complexity:  O(n)
//Space Complexity: O(h), where h is the height of the tree
package BinaryTree;

public class MaxDepth {
    public static int maximumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maximumDepth(root.left);
        int right = maximumDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // input tree:
        // 12
        // / \
        // 8 18
        // / \
        // 5 11
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(8);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(11);

        System.out.println(maximumDepth(root));
    }
}
