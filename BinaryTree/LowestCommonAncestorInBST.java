/*Question : Given the root of a Binary Search Tree (BST) and two nodes p and q, return their lowest common ancestor (LCA).
The lowest common ancestor is the lowest node in the tree that has both p and q as descendants. A node can be considered a descendant of itself.*/
//Time Complexity:  O(h)
//Space Complexity: O(h)
package BinaryTree;

public class LowestCommonAncestorInBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (Math.min(p.val, q.val) <= root.val && Math.max(p.val, q.val) >= root.val) {
            return root;
        } else if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
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

        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(7);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }
}
