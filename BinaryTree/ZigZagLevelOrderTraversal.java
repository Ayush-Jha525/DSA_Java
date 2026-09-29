/*Question : Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).*/
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

import java.util.*;

public class ZigZagLevelOrderTraversal {
    public static ArrayList<Integer> zigzagLevelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean startLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                list.add(current.val);
            }

            if (!startLeft) {
                Collections.reverse(list);
                startLeft = true;
            } else {
                startLeft = false;
            }
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        ArrayList<Integer> res = zigzagLevelOrder(root);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
