//Question: Given a string, find the first character that appears exactly once in the string.
//  If no such character exists, return a special value ('\0')
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class FirstNonRepeatingChar {
    public static char firstNonRepeating(String str) {
        int[] freq = new int[26];

        for (char i : str.toCharArray()) {
            freq[i - 'a'] += 1;
        }

        for (char i : str.toCharArray()) {
            if (freq[i - 'a'] == 1) {
                return i;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String str = "abacabad"; // output : c

        char result = firstNonRepeating(str);

        if (result == '\0') {
            System.out.println("No non-repeating character");
        } else {
            System.out.println(result);
        }
    }
}
