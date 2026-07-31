/*Question : Given an encoded string s, decode it.
        The encoding rule is:
            k[encoded_string]
        where:
        *   k is a positive integer.
        *   The string inside the brackets should be repeated exactly k times.
        *   The input is always valid.
        *   Digits are only used for repetition counts.

    Example : Input:    "3[a]2[bc]"
              Output:   "aaabcbc"
*/
// Time Complexity : O(n)
// Space Complexity : O(n)

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
