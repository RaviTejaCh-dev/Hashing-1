// Time Complexity : O(N * K) where N is the number of strings and K is the maximum length of a string
// Space Complexity: O(N * K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap<>();

        for (String str : strs) {
            double hash = getHash(str);

            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }

            map.get(hash).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private double getHash(String str) {
        int[] primes = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        };

        double hash = 1;

        for (char c : str.toCharArray()) {
            hash *= primes[c - 'a'];
        }

        return hash;
    }
}
