package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class _6_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(optimalBetter(s, k));
    }

    public static int optimalBetter(String s, int k) {
        int[] count = new int[26];
        int l = 0, r = 0, res = 0, n = s.length();
        int maxFrequent = 0;

        while (r < n) {
            // open
            char right = s.charAt(r);
            count[right - 'A']++;
            maxFrequent = Math.max(maxFrequent, count[right - 'A']); // keep track of most freq. char in window
            // close
            while (r - l + 1 - maxFrequent > k) {
                char left = s.charAt(l++);
                count[left - 'A']--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

    public static int optimal(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0, n = s.length(), maxRepeat = 0, maxWindow = 0;

        while (r < n) {
            char right = s.charAt(r);
            map.put(right, map.getOrDefault(right, 0) + 1);
            maxRepeat = Math.max(maxRepeat, map.get(right));
            if(r - l + 1 - maxRepeat > k) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                l++;
            }
            maxWindow = Math.max(maxWindow, r - l + 1);
            r++;
        }

        return maxWindow;
    }
}
