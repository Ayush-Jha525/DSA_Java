/*Question : You are given a grid where:
            0 = empty cell
            1 = fresh orange
            2 = rotten orange

Every minute, a rotten orange makes any fresh orange directly adjacent to it rotten.
Adjacent means:
    * Up
    * Down
    * Left
    * Right

Return the minimum number of minutes until no fresh oranges remain.
If some fresh oranges can never become rotten, return -1 */
// Time Complexity : O(n)
// Space Complexity : O(n)
package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        int[][] position = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int timeCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                for (int[] dir : position) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (isValid(nx, ny, n, m) && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new int[] { nx, ny });
                        flag = true;
                    }
                }
            }

            if (flag) {
                timeCount++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return timeCount;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };

        System.out.println(orangesRotting(grid));
    }
}
