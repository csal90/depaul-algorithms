package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringAtMostKDistinctCharacters_3 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(optimal(s, k));
        System.out.println(bruteForce(s, k));
    }

    /*
    Optimal:
    Time complexity: O(n) where n is the length of s
    Space complexity: O(k) where k represents a character in s
     */
    public static int optimal(String s, int k) {
        int n = s.length();
        if (n * k == 0) return 0;
        int l = 0, r = 0, res = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        while (r < n) {
            // Add right character to our map and increment it's count.
            char right = s.charAt(r);
            map.put(right, map.getOrDefault(right, 0) + 1);
            // Condition to when we move our left pointer.
            while (map.size() > k) {
                char left = s.charAt(l++);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) map.remove(left);
            }
            // Update the window size and move our right pointer.
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

    public static int bruteForce(String s, int k) {
        return -1;
    }
}
