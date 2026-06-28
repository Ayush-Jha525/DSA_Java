//Question: Check if a given string is a binary string or not
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class CheckBinarystring {
    public static boolean isBinary(String s) {
        // code here
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "101110111";
        String s2 = "10210";
        System.out.println(isBinary(s1));
        System.out.println(isBinary(s2));
    }
}
