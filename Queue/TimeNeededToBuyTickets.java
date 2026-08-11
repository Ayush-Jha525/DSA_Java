/*Question : You have a queue of people buying tickets. tickets[i] represents how many tickets person i needs to buy.
    Each second:
    - The person at the front buys exactly one ticket.
    - If they still need tickets, they go to the back of the queue.
    - If they have bought all their tickets, they leave the queue.
Return the total number of seconds until person k has bought all their tickets. */
// Time Complexity : O(T), where T is the number of tickets processed
// Space Complexity : O(n)
package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        int time = 0;
        while (tickets[k] != 0) {
            int idx = queue.poll();
            time++;
            tickets[idx] -= 1;

            if (tickets[idx] > 0) {
                queue.offer(idx);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[] tickets = { 2, 3, 2 };
        int k = 2;

        System.out.println(timeRequiredToBuy(tickets, k)); // output : 6
    }
}
