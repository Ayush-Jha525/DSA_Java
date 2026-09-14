/*Question : Given the root of a binary tree, invert the tree and return its root.
Inverting means swapping the left and right child of every node. */
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                System.out.print(current.val + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Original tree:
        //
        // 4
        // / \
        // 2 7
        // / \ / \
        // 1 3 6 9

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // original tree :
        printLevelOrder(root);

        invertTree(root);
        // inverted tree :
        printLevelOrder(root);
    }
}
