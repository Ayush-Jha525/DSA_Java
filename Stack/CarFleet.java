/*Question: There are n cars traveling towards the same destination.
        You are given:
            target → the destination position.
            position[i] → the starting position of the ith car.
            speed[i] → the speed of the ith car.

        A car can never pass another car ahead of it.
        If a faster car catches a slower car, they become one fleet and travel together at the slower car's speed.
        Return the number of car fleets that arrive at the destination. */
// Time Complexity : O(n log n)
// Space Complexity : O(n)
package Stack;

import java.util.Arrays;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        int carFleets = 0;
        double fleetTime = 0;
        for (int idx = n - 1; idx >= 0; idx--) {
            double time = (double) (target - cars[idx][0]) / cars[idx][1];

            if (time > fleetTime) {
                carFleets++;
                fleetTime = time;
            }
        }

        return carFleets;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        System.out.println(carFleet(target, position, speed)); // Output : 3
    }
}
