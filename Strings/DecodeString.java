/*Question : Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.*/
//Time Complexity :  O(N * M) (where N is the input length and M is the maximum length of the generated output) 
//Space Complexity : O(M)
package Strings;

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
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
}
