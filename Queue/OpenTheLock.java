/*Question : You have a lock with 4 wheels. Each wheel contains digits from 0 to 9.
    Initially, the lock is: 0000
    You need to reach a target combination.
    However, some combinations are deadends. If the lock reaches a deadend, you cannot use that combination or continue from it.
    Return the minimum number of turns needed to reach the target.
    If the target cannot be reached, return -1. */
// Time Complexity : O(10^4)
// Space Complexity : O(10^4)
package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OpenTheLock {
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
        String[] barriers = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";

        System.out.println(openLock(barriers, target));
    }
}
