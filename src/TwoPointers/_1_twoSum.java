package TwoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class _1_twoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(optimal(nums, target)));
        System.out.println(Arrays.toString(bruteForce(nums, target)));
        System.out.println(Arrays.toString(nlognSol(nums, target)));
    }

    /*
    TC: O(n) where n is the number of elements in nums
    SC: O(n) where n is the number of elements in numns
     */
    public static int[] optimal(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (map.containsKey(delta)) {
                return new int[]{i, map.get(delta)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /*
    TC: O(n log n) we sort the elements which takes n log n time
    SC: O(1) we are not allocating any additional space
    */
    public static int[] nlognSol(int[] nums, int target) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int temp = nums[lo] + nums[hi];
            if (temp == target) return new int[] {lo, hi};
            else if (temp < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[] {-1, -1};
    }

    /*
    TC: O(n^2) where n is the number of elements in nums
    SC: O(1) we are not allocating any additional space
    */
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
