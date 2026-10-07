/*Question : Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree. */
//Time Complexity:  O(n)
//Space Complexity: O(h)

package BinaryTree;

public class FlattenBinaryTreetoLinkedList {
    public static TreeNode findRightMost(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findRightMost(root.right);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode rightMost = findRightMost(root.left);

            rightMost.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);

        System.out.print("Flattened Binary Tree: ");

        while (root != null) {
            System.out.print(root.val + "->");
            root = root.right;
        }
        System.out.println("Null");

    }
}
