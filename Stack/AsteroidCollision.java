/*Question : We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.
* For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
* Each asteroid moves at the same speed.
* Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. 
* Two asteroids moving in the same direction will never meet. */

// Time Complexity : O(n)
// Space Complexity : O(n)

package Stack;

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];

            if (current >= 0) {
                stack.push(current);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() >= 0 && Math.abs(current) > stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(current);
            } else {
                if (Math.abs(current) == stack.peek()) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return new int[0];
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = { 3, 5, -6, 2, -1, 4 };

        int[] result = asteroidCollision(asteroids);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
