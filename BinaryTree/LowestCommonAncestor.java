/*Question : Given the root of a binary tree and two nodes p and q, return their lowest common ancestor (LCA).
The lowest common ancestor is the deepest node that has both p and q as descendants. A node can be considered a descendant of itself. */
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

import java.util.ArrayList;

public class LowestCommonAncestor {
    public static boolean findPath(TreeNode root, TreeNode target, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = new ArrayList<>();
        ArrayList<TreeNode> pathQ = new ArrayList<>();

        if (!findPath(root, p, pathP) || !findPath(root, q, pathQ)) {
            return null;
        }

        int i = 0;
        for (i = 0; i < Math.min(pathP.size(), pathQ.size()); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }
        return pathP.get(i - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);

        TreeNode p = root.right.right; // 7
        TreeNode q = root.right.left.left; // 8

        TreeNode ans = lowestCommonAncestor(root, p, q);

        System.out.println(ans.val);
    }
}
