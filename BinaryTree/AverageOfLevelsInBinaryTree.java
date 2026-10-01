/*Question : Given the root of a binary tree, return the average value of the nodes on each level.
The answer should contain one average for every level, from the root level downward.*/
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                sum += current.val;
            }
            double avg = sum / size;
            result.add(avg);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        List<Double> result = averageOfLevels(root);
        System.out.println("Averages of levels : ");
        System.out.println(result);

    }
}
