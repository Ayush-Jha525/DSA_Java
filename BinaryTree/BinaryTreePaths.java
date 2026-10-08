/*Question : Given the root of a binary tree, return all root-to-leaf paths in any order.
A root-to-leaf path is a sequence of nodes starting at the root and ending at a leaf.
A leaf is a node with no left or right child.*/
//Time Complexity:  O(n) traversal + cost of constructing output paths
//Space Complexity: O(h) auxiliary + output
package BinaryTree;

import java.util.*;

public class BinaryTreePaths {
    // helper method
    public static String pathToString(ArrayList<Integer> path) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            result.append(path.get(i));
            result.append("->");
        }
        result.append(path.get(path.size() - 1));
        return result.toString();
    }

    // helper method
    public static void allPaths(TreeNode root, ArrayList<Integer> path, List<String> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        if (root.left == null && root.right == null) {
            result.add(pathToString(path));
        } else {
            allPaths(root.left, path, result);
            allPaths(root.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        allPaths(root, new ArrayList<Integer>(), result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        List<String> result = binaryTreePaths(root);
        System.out.println(result);
    }
}
