/*Question : Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.*/
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

import java.util.*;

public class TreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelView = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                levelView.add(current.val);
            }
            rightView.add(levelView.get(levelView.size() - 1));
        }
        return rightView;
    }

    public static void main(String[] args) {
        // Representation of the input tree:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(rightSideView(root));
    }
}
