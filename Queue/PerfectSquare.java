/*Question : Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. 
For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not. */
// Time Complexity : O(n√n)
// Space Complexity : O(n)

package Queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PerfectSquare {
    public static int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 0; i * i <= n; i++) {
            squares.add(i * i);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int steps = 0;

        queue.offer(n);
        visited.add(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            while (size-- > 0) {
                int current = queue.poll();

                for (int i : squares) {
                    int remainder = current - i;

                    if (remainder == 0) {
                        return steps;
                    } else if (remainder < 0) {
                        break;
                    }

                    if (visited.add(remainder)) {
                        queue.offer(remainder);
                    }
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
}
