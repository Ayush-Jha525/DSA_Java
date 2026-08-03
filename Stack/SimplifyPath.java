/*Question : You are given an absolute Unix-style file path.

    Simplify it according to these rules:

        * "." means current directory → ignore it.
        * ".." means go to the parent directory.
        * Multiple slashes ("//") should be treated as a single slash ("/").
        * Any other name represents a valid directory.

    Return the canonical simplified path.
*/
// Time Complexity : O(n)
// Space Complexity : O(n)

package Stack;

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
        String str = "/a/./b/../../c/";
        System.out.println(simplifyPath(str)); // Output : /c

        str = "/../";
        System.out.println(simplifyPath(str)); // Output : /

        str = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(str)); // Output : /.../b/d
    }
}
