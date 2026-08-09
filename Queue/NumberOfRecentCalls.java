/*Write a class RecentCounter that counts the number of requests received in the last 3000 milliseconds.
    Implement:
        RecentCounter()
        int ping(int t)

    Each call to ping(t) represents a request at time t (in milliseconds).
    Return the number of requests that occurred in the inclusive time range: [t - 3000, t]

    It is guaranteed that:
        * Every t is strictly increasing.
        * Each call to ping() has a larger timestamp than the previous one. */
// Time Complexity : O(1)
// Space Complexity : O(n)
package Queue;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        int startRange = t - 3000;

        while (!queue.isEmpty() && queue.peek() < startRange) {
            queue.poll();
        }

        return queue.size();
    }
}

public class NumberOfRecentCalls {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1)); // return 1
        System.out.println(recentCounter.ping(100)); // return 2
        System.out.println(recentCounter.ping(3001)); // return 3
        System.out.println(recentCounter.ping(3002)); // return 3
    }
}
