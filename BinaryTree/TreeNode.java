package BinaryTree;

public class TreeNode {
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

    public void printPreOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print("Null ");
            return;
        }
        System.out.print(root.val + " ");
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }
}
