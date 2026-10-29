/*Question : You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
The lock initially starts at '0000', a string representing the state of the 4 wheels.
You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.*/
//Time Complexity : O() 
//Space Complexity : O()
package Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OpentheLock {
    public static int toInt(String str) {
        int num = 0;
        for (int i : str.toCharArray()) {
            num = num * 10 + (i - '0');
        }
        return num;
    }

    public static List<String> neighbour(String str) {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] a = str.toCharArray();
            char[] b = str.toCharArray();

            a[i] = (a[i] == '9') ? '0' : (char) (a[i] + 1);
            b[i] = (b[i] == '0') ? '9' : (char) (b[i] - 1);

            values.add(new String(a));
            values.add(new String(b));
        }
        return values;
    }

    public static int openLock(String[] deadends, String target) {
        String start = "0000";

        if (start.equals(target)) {
            return 0;
        }

        boolean[] barriers = new boolean[10000];
        for (String s : deadends) {
            barriers[toInt(s)] = true;
        }

        if (barriers[toInt(start)]) {
            return -1;
        }

        boolean[] visited = new boolean[10000];
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited[toInt(start)] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String current = queue.poll();

                for (String s : neighbour(current)) {
                    int id = toInt(s);
                    if (barriers[id] || visited[id]) {
                        continue;
                    }

                    if (s.equals(target)) {
                        return steps + 1;
                    }

                    visited[id] = true;
                    queue.offer(s);
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends1 = { "0201", "0101", "0102", "1212", "2002" };
        String target1 = "0202";

        System.out.println(openLock(deadends1, target1)); // Output : 6

        String[] deadends2 = { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
        String target2 = "8888";

        System.out.println(openLock(deadends2, target2)); // Output : -1
    }
}
