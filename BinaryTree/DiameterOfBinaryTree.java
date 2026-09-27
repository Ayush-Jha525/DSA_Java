/*Question : Given the root of a binary tree, return the length of the diameter of the tree.
The diameter is the longest path between any two nodes in the tree.
The path does not necessarily have to pass through the root.
The length of a path is measured by the number of edges between the nodes.*/
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

public class DiameterOfBinaryTree {
    static int maxDiameter = 0;

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(right, left) + 1;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}
