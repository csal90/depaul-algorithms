package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class _9_FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];

        for (char c : p.toCharArray()) count[c - 'a']++;
        List<Integer> res = new ArrayList<>();

        int l = 0, r = 0, n = s.length();

        while (r < n) {
            int right = s.charAt(r++);
            count[right - 'a']--;
            while (count[right - 'a'] < 0) {
                char left = s.charAt(l++);
                count[left - 'a']++;
            }
            if (r - l == p.length()) {
                res.add(l);
            }
        }

        return res;
    }
}
