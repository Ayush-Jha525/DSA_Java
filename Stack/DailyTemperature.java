//Question : Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
// Time Complexity : O(n)
//Space complexity : O(n) 

package Stack;

import java.util.Stack;

public class DailyTemperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> index = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currentEle = temperatures[i];
            while (!index.isEmpty() && temperatures[index.peek()] <= currentEle) {
                index.pop();
            }
            result[i] = (index.isEmpty()) ? 0 : index.peek() - i;
            index.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        int[] result = dailyTemperatures(temperatures);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
