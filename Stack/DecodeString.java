/*Question : Given an encoded string s, decode it.
        The encoding rule is:
            k[encoded_string]
        where:
        *   k is a positive integer.
        *   The string inside the brackets should be repeated exactly k times.
        *   The input is always valid.
        *   Digits are only used for repetition counts.
        *   The encoded string may contain nested brackets.

    Example : Input:    "3[a]2[bc]"
              Output:   "aaabcbc"
*/
// Time Complexity : O(n²) in the worst case
// Space Complexity : O(n)

/*Approach: Use a StringBuilder as a working stack. Whenever a closing bracket ] is encountered, extract the innermost encoded substring, determine its repeat count, decode it, and append it back. This naturally resolves nested encodings from the inside out. */

package Stack;

public class DecodeString {
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ']') {
                result.append(current);
                continue;
            }

            StringBuilder decoded = new StringBuilder();
            int end = result.length() - 1;
            while (result.charAt(end) != '[') {
                decoded.insert(0, result.charAt(end));
                result.deleteCharAt(end);
                end--;
            }
            result.deleteCharAt(end--);

            int num = 0;
            int tens = 1;
            while (end >= 0 && Character.isDigit(result.charAt(end))) {
                num = num + (result.charAt(end) - '0') * tens;
                tens *= 10;
                result.deleteCharAt(end);
                end--;
            }

            String repeatedStr = decoded.toString().repeat(num);

            result.append(repeatedStr);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s)); // Output: "aaabcbc"

        s = "3[a2[c]]";
        System.out.println(decodeString(s)); // Output: "accaccacc"
    }
}

/*
 * Approach: Use a StringBuilder as a working stack. Whenever a closing bracket
 * ] is encountered, extract the innermost encoded substring, determine its
 * repeat count, decode it, and append it back. This naturally resolves nested
 * encodings from the inside out.
 */
