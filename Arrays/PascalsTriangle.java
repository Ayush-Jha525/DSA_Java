/*Question : Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it */
//Time Complexity : O(n^2)
//Space Complexity : O(n^2)
package Arrays;

import java.util.*;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>(numRows);

        rows.add(new ArrayList<>(List.of(1)));

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>(i + 1);

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
                }

            }
            rows.add(list);
        }
        return rows;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascalsTriangle = generate(5);
        System.out.println(pascalsTriangle);
    }

}