/*Question : Given the root of a binary tree, determine whether the tree is symmetric around its center.*/
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

public class SymmetricTree {
    public static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {
        // symmetric binary tree
        // 10
        // / \
        // 5 5
        // / \
        // 2 2
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);

        System.out.println(isSymmetric(root));
    }
}
