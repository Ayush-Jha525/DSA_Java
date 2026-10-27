/*Question : You are given an m x n grid where each cell can have one of three values:
    * 0 representing an empty cell,
    * 1 representing a fresh orange, or
    * 2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.*/
//Time Complexity : O(n*m) 
//Space Complexity : O(n)
package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
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
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting(grid));
    }
}
