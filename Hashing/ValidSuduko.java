//Question : Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following //       
//      rules:
//             *Each row must contain the digits 1-9 without repetition.
//             *Each column must contain the digits 1-9 without repetition.
//             *Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//  Note : 0 represents an empty block.
//Time Complexity : O(1)
//Space Complexity : O(1)

package Hashing;

import java.util.HashSet;

public class ValidSuduko {
    public static boolean isValid(int mat[][]) {
        // code here
        HashSet<Integer>[] row = new HashSet[9];
        HashSet<Integer>[] column = new HashSet[9];
        HashSet<Integer>[] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int current = mat[i][j];
                if (current == 0) {
                    continue;
                }

                if (row[i].add(current) && column[j].add(current)) {
                    int idx = (i / 3) * 3 + (j / 3);
                    if (!box[idx].add(current)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        System.out.println(isValid(mat));

    }
}
