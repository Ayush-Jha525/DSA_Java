/*Question : Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values equals targetSum.
Each path must start at the root and end at a leaf.*/
//Time Complexity:  O(n)
//Space Complexity: O(h)
package BinaryTree;

import java.util.*;

public class PathSum_II {
    public static void findPathSum(TreeNode root, int currentSum, int targetSum, ArrayList<Integer> path,
            List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        findPathSum(root.left, currentSum, targetSum, path, result);
        findPathSum(root.right, currentSum, targetSum, path, result);

        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        findPathSum(root, 0, targetSum, new ArrayList<Integer>(), result);

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        List<List<Integer>> result = pathSum(root, target);
        System.out.println(result);
    }
}
