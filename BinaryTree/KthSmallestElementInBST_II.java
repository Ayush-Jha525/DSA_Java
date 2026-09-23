/*Question : Given the root of a Binary Search Tree and an integer k, return the kth smallest value in the BST.
The smallest element has k = 1*/
//Time Complexity:  O(h + k)
//Space Complexity: O(h)
package BinaryTree;

public class KthSmallestElementInBST_II {
    public static int findKthSmallest(TreeNode root, int[] count, int k) {
        if (root == null) {
            return -1;
        }

        int left = findKthSmallest(root.left, count, k);
        if (left != -1) {
            return left;
        }

        count[0]++;
        if (count[0] == k) {
            return root.val;
        }

        int right = findKthSmallest(root.right, count, k);
        return right;
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] count = { 0 };
        return findKthSmallest(root, count, k);
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
