//Question : Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//Time Complexity : O(n^2)
//Space Complexity : O(n^2)
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_II {
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>(rowIndex);

        rows.add(new ArrayList<>(List.of(1)));

        for (int i = 1; i <= rowIndex; i++) {
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
        return rows.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> pascalsTriangle = getRow(3);
        System.out.println(pascalsTriangle);
    }
}
