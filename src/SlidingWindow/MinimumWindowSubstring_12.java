package SlidingWindow;

public class MinimumWindowSubstring_12 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
    /*
    IMPORTANT INSIGHT!
    When a problem asks to find **maximum** substring, we should update the maximum AFTER the inner while loop.
    When a problem asks to find **minimum** substring, we should update the minimum INSIDE the inner while loop.

    Algorithm:
    1) First, we count the frequency for the characters in String t.
    2) Now, we can use sliding window. We keep track of our l and r pointers as well as a counter to let us know when we
       have a "valid" sub-string.
       - Note: We have a valid sub-string when all chars of t are within a substring in s (inc/dec the counter to help you find this).

    3) We first *OPEN* the window by moving our right pointer inward ->
        - If the count of the current character is > 0, this means we have a char that is in t. Decrement!
        - This may seem confusing, but remember. We know we have a valid string when our validString is equal to 0!
    5) Continue this until we reach a condition to when our count is 0. (meaning we have a valid substring)
    6) If the current substring we are on (r - l) is less than the smallest valid substring we've seen so far. Update it.
    7) Now, we **give back** our char by *CLOSING* our window and incrementing the chars count and validString count.

    Runtime:
    TC: O(m + n) where m is the len of s and n is the len of t
    SC: O(m + n) where m is the len of s and n is the len of t
    */
    private static String minWindow(String s, String t) {
        int[] count = new int[256]; // because we are dealing with cap & non-cap
        for (char c : t.toCharArray()) count[c]++;

        int l = 0, r = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        int validString = t.length(), m = s.length();

        while (r < m) {
            // open the window
            char right = s.charAt(r++);
            if (count[right] > 0) validString--;
            count[right]--;
            while (validString == 0) {
                // we have a valid substring, now check if it's smaller than previous ones!
                if (r - l < minLen) {
                    minStart = l;
                    minLen = r - l;
                }
                // give back
                char left = s.charAt(l++);
                count[left]++;
                if (count[left] > 0) validString++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
