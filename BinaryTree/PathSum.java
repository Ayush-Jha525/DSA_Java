/*Question : Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.*/
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

public class PathSum {

    public static boolean sumPath(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            return true;
        }

        return sumPath(root.left, sum, target) || sumPath(root.right, sum, target);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return sumPath(root, 0, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(8);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(2);

        int target = 21;

        System.out.println(hasPathSum(root, target));

    }
}
