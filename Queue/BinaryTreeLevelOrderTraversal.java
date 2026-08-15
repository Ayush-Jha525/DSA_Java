//Question : Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Time Complexity : O(n)
// Space Complexity : O(n)
package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current != null) {
                TreeNode left = current.left;
                TreeNode right = current.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                list.add(current.val);
            } else {
                result.add(list);
                list = new ArrayList<>();
                if (queue.isEmpty()) {
                    break;
                }
                queue.offer(null);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)));

        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();

        List<List<Integer>> result = obj.levelOrder(root);

        System.out.println(result);
    }

}
