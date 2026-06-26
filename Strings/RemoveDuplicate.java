//Question : Remove all duplicate characters from the string and find the resultant string. The order of remaining characters in the output should be same as in the original string.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Strings;

import java.util.*;

public class RemoveDuplicate {
    public static String duplicateRemove(String s) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (char i : s.toCharArray()) {
            if (set.add(i)) {
                result.append(i);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "HaPpyNewYear";

        System.out.println(duplicateRemove(s));
    }
}
