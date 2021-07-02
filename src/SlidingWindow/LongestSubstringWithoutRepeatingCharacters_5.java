package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_5 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(optimal(s));
    }

    /*
    Optimal:
    TC: O(n)
    SC: O(n)
     */
    public static int optimal(String s) {
        Set<Character> set = new HashSet<>();
        int r = 0, l = 0, res = 0, n = s.length();
        if (n == 0) return res;

        while (r < n) {
            char right = s.charAt(r++);
            while (set.contains(right)) {
                char left = s.charAt(l++);
                set.remove(left);
            }
            set.add(right);
            res = Math.max(res, r - l);
        }

        return res;
    }
}
