package SlidingWindow;

import java.util.HashMap;

public class _4_FruitIntoBaskets {
    public static void main(String[] args) {
        int[] tree = {1,2,1};
        System.out.println(optimal(tree));
    }
    /*
    Optimal:
    TC: O(n)
    SC: O(2)
     */
    public static int optimal(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = tree.length, res = 0;

        while (r < n) {
            int right = tree[r];
            map.put(right, map.getOrDefault(right, 0) + 1);

            while (map.size() > 2) {
                int left = tree[l++];
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) map.remove(left);
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

}
