//Question : Given an array of characters, compress it in-place using the following rules:
//      Consecutive repeating characters are replaced by:
//          * the character itself
//          * followed by the count if the count is greater than 1
//      Return the length of the compressed array.
//      Do not use extra arrays proportional to the input size.
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class StringCompression {
    public static int compress(char[] chars) {
        int validIdx = 0;
        int right = 1;
        int count = 1;
        while (right < chars.length) {
            if (chars[right] == chars[right - 1]) {
                count++;
                right++;
            } else {
                chars[validIdx++] = chars[right - 1];
                if (count != 1) {
                    String num = String.valueOf(count);

                    for (int i = 0; i < num.length(); i++) {
                        chars[validIdx++] = num.charAt(i);
                    }
                }
                right++;
                count = 1;
            }
        }
        chars[validIdx++] = chars[right - 1];
        if (count != 1) {
            String num = String.valueOf(count);

            for (int i = 0; i < num.length(); i++) {
                chars[validIdx++] = num.charAt(i);
            }
        }

        return validIdx;
    }

    public static void main(String[] args) {
        char[] arr = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        int idx = compress(arr);

        for (int i = 0; i < idx; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
