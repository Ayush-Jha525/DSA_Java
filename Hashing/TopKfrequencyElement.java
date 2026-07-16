//Question : Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order
//Time Complexity : O(n)
//Space Complexity : O(n)
package Hashing;

import java.util.*;

public class TopKfrequencyElement {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        ArrayList<Integer>[] freqIdx = new ArrayList[nums.length + 1];
        for (int i = 0; i < freqIdx.length; i++) {
            freqIdx[i] = new ArrayList();
        }

        for (int i : nums) {
            if (frequency.containsKey(i)) {
                frequency.put(i, frequency.get(i) + 1);
            } else {
                frequency.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            freqIdx[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = freqIdx.length - 1; i >= 0; i--) {
            if (!freqIdx[i].isEmpty()) {
                for (int j : freqIdx[i]) {
                    if (idx == k) {
                        return result;
                    }
                    result[idx++] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
        int k = 2;

        int[] result = topKFrequent(nums, k);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}
