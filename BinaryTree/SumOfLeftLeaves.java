/*Question : Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node*/
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

public class SumOfLeftLeaves {
    public static int leftLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += leftLeavesSum(root.left);
            }
        }
        sum += leftLeavesSum(root.right);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(8);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(2);

        System.out.println(leftLeavesSum(root));
    }
}
