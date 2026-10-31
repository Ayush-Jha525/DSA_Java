/*Question : Given two binary strings a and b, return their sum as a binary string.*/
//Time Complexity : O(max length(a,b)) 
//Space Complexity : O(n)
package Strings;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder("");
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        char sum = '0';

        while (i >= 0 || j >= 0) {
            char aCurrent = (i >= 0) ? a.charAt(i) : '0';
            char bCurrent = (j >= 0) ? b.charAt(j) : '0';

            if (aCurrent == '1' && bCurrent == '1') {
                if (carry == 1) {
                    sum = '1';
                    carry = 1;
                } else {
                    sum = '0';
                    carry = 1;
                }
            } else if (aCurrent == '1' || bCurrent == '1') {
                if (carry == 1) {
                    sum = '0';
                    carry = 1;
                } else {
                    sum = '1';
                    carry = 0;
                }
            } else {
                if (carry == 1) {
                    sum = '1';
                    carry = 0;
                } else {
                    sum = '0';
                    carry = 0;
                }
            }

            result.append(sum);
            i--;
            j--;
        }

        if (carry == 1) {
            result.append(carry);
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));
    }
}
