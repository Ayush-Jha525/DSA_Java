/*Question : We have two special characters:
    *   The first character can be represented by one bit 0.
    *   The second character can be represented by two bits (10 or 11).
    *   Given a binary array bits that ends with 0, 
    return true if the last character must be a one-bit character. */
//Time Complexity : O(n)      
//Space Complexity : O(1)
package Arrays;

public class OnebitAnd2bitCharacters {
    public static boolean isOneBitCharacter(int[] bits) {
        int prev = 0;
        for (int i = 0; i < bits.length - 1; i++) {
            if (prev == 1) {
                prev = 0;

            } else {
                prev = bits[i];
            }
        }
        if (prev == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] bits = { 1, 1, 1, 1, 1, 1, 0 };
        System.out.println(isOneBitCharacter(bits));
    }
}
