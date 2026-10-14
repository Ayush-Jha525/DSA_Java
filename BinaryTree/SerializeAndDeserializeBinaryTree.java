/*Question : Design an algorithm to serialize a binary tree into a string and then deserialize that string back 
into the original binary tree.*/
//Time Complexity:  O(n)
//Space Complexity: O(n)
package BinaryTree;

import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {
    public static void serializeHelper(TreeNode root, ArrayList<String> list) {
        if (root == null) {
            list.add("#");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeHelper(root.left, list);
        serializeHelper(root.right, list);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        ArrayList<String> list = new ArrayList<String>();
        serializeHelper(root, list);

        return String.join(",", list);
    }

    public static TreeNode construct(String[] path, int[] idx) {
        if (idx[0] >= path.length || path[idx[0]].equals("#")) {
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(path[idx[0]++]));
        root.left = construct(path, idx);
        root.right = construct(path, idx);
        return root;
    }

    public static TreeNode deserialize(String data) {
        String[] path = data.split(",");
        return construct(path, new int[] { 0 });
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);

        String arr = serialize(root);
        TreeNode res = deserialize(arr);

        res.printPreOrderTraversal(res);
    }
}
