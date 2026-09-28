/*Question : A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.*/
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

public class MaximumPathSum {
    static int max = Integer.MIN_VALUE;

    public static int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        left = (left > 0) ? left : 0;
        right = (right > 0) ? right : 0;

        int rootSum = left + right + root.val;

        if (max < rootSum) {
            max = rootSum;
        }
        return Math.max(left, right) + root.val;
    }

    public static int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(maxPathSum(root));
    }

}
