package SlidingWindow;

import java.util.HashMap;

public class _8_PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        //int[] count = new int[26];
        //for (char c : s1.toCharArray()) count[c - 'a']++;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int l = 0, r = 0, n = s2.length();
        while (r < n) {
            char right = s2.charAt(r++);
            //count[right - 'a']--;
            map.put(right, map.getOrDefault(right, 0) - 1);
            while (map.get(right) < 0) {
                char left = s2.charAt(l++);
                map.put(left, map.getOrDefault(left, 0) + 1);
                //count[left - 'a']++;
            }
            if (r - l == s1.length()) return true;
        }

        return false;
    }
}
