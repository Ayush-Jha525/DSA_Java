/*Question : Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.*/
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

public class ConvertSortedArraytoBST {
    public static TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 9, 14, 23, 27 };
        TreeNode root = sortedArrayToBST(arr);

        System.out.println(LevelOrderTraversal.levelOrder(root));
    }
}
