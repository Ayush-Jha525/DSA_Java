/*Question : Given the root of a binary tree, return its level order traversal of node values.
Nodes should be returned level by level, from left to right.*/
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

import java.util.*;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                temp.add(current.val);
            }
            levelOrder.add(temp);
        }
        return levelOrder;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(14);

        root.right.right = new TreeNode(2);

        root.left.left.left = new TreeNode(17);
        root.left.left.right = new TreeNode(23);

        root.left.right.left = new TreeNode(27);
        root.left.right.right = new TreeNode(3);

        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(11);

        List<List<Integer>> res = levelOrder(root);

        for (List<Integer> i : res) {
            System.out.println(i);
        }
    }
}
