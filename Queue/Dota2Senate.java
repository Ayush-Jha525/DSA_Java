/*Question : 
There are two parties:
R → Radiant
D → Dire
The senators sit in a circular order represented by a string senate.
Each round, senators act from left to right.
When a senator gets their turn, they can ban one senator from the opposing party. A banned senator cannot act in the future.
The process continues until only one party has active senators.
Return:
"Radiant" if Radiant wins.
"Dire" if Dire wins. */
// Time Complexity : O(n)
// Space Complexity : O(n)
package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public static String predictPartyVictory(String senate) {
        Queue<Integer> queueD = new LinkedList<>();
        Queue<Integer> queueR = new LinkedList<>();
        String result = "";
        for (int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            if (ch == 'D') {
                queueD.offer(i);
            } else {
                queueR.offer(i);
            }
        }

        if (queueR.isEmpty()) {
            return "Dire";
        } else if (queueD.isEmpty()) {
            return "Radiant";
        }

        int n = senate.length();
        while (!queueD.isEmpty() && !queueR.isEmpty()) {
            int currentR = queueR.peek();
            int currentD = queueD.peek();

            if (currentD < currentR) {
                queueD.poll();
                queueD.offer(currentD + n);
                queueR.poll();
            } else {
                queueR.poll();
                queueR.offer(currentR + n);
                queueD.poll();
            }

            if (queueR.isEmpty()) {
                result = "Dire";
                break;
            } else if (queueD.isEmpty()) {
                result = "Radiant";
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String senate = "RRRDD";
        System.out.println(predictPartyVictory(senate));
    }
}
