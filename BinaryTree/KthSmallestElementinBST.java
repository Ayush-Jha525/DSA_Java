/*Question : Given the root of a Binary Search Tree and an integer k, return the kth smallest value in the BST.
The smallest element has k = 1*/
//Time Complexity:  O(n)
//Space Complexity: O(n)

package BinaryTree;

import java.util.ArrayList;

public class KthSmallestElementinBST {
    public static void inorder(TreeNode root, ArrayList<Integer> traversal) {
        if (root == null) {
            return;
        }

        inorder(root.left, traversal);
        traversal.add(root.val);
        inorder(root.right, traversal);
    }

    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> traversal = new ArrayList<>();
        inorder(root, traversal);

        if (k > traversal.size()) {
            return -1;
        }
        int result = -1;
        for (int i = 0; i < traversal.size(); i++) {
            if (i == k - 1) {
                result = traversal.get(i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(25);

        System.out.println(kthSmallest(root, 4));
    }
}
