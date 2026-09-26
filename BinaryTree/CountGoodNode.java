/*Question : Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X. Return the number of good nodes in the binary tree.*/
//Time Complexity:  O(n)
//Space Complexity: O(h)

package BinaryTree;

public class CountGoodNode {
    // helper function
    public static void findGoodNodes(TreeNode root, int[] countNode, int greaterValue) {
        if (root == null) {
            return;
        }

        if (root.val >= greaterValue) {
            countNode[0]++;
            greaterValue = root.val;
        }
        findGoodNodes(root.left, countNode, greaterValue);
        findGoodNodes(root.right, countNode, greaterValue);
    }

    public static int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] countNode = { 0 };
        findGoodNodes(root, countNode, root.val);
        return countNode[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root));
    }
}
