/*Question : There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
You are given two integer arrays position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
A car fleet is a single car or a group of cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
Return the number of car fleets that will arrive at the destination.*/
//Time Complexity : O() 
//Space Complexity : O()
package Arrays;

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

        System.out.println(carFleet(target, position, speed));
    }
}
