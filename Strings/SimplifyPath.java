/*Question : You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:
    * A single period '.' represents the current directory.
    * A double period '..' represents the previous/parent directory.
    * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
    * Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.

The simplified canonical path should follow these rules:
    * The path must start with a single slash '/'.
    * Directories within the path must be separated by exactly one slash '/'.
    * The path must not end with a slash '/', unless it is the root directory.
    * The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
Return the simplified canonical path.*/
//Time Complexity : O(n) 
//Space Complexity : O(n)
package Strings;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");

        for (String s : arr) {
            if (!s.equals(".") && !s.equals("")) {
                if (!s.equals("..")) {
                    stack.push(s);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder newPath = new StringBuilder();
        for (String str : stack) {
            newPath.append("/").append(str);
        }

        return newPath.length() == 0 ? "/" : newPath.toString();
    }

    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";

        System.out.println(simplifyPath(path));
    }
}
