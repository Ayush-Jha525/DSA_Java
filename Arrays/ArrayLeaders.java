//Question: You are given an array arr of positive integers find all the leaders present in the array. 
//  An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

import java.util.*;

public class ArrayLeaders {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int leader = arr[arr.length - 1];
        list.add(leader);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= leader) {
                list.add(arr[i]);
                leader = arr[i];
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        ArrayList<Integer> list = leaders(arr);

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
