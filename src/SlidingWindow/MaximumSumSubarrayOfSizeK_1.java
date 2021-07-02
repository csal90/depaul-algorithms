package SlidingWindow;

import java.util.Arrays;

public class MaximumSumSubarrayOfSizeK_1 {
    public static void main(String[] args) {
        int[] nums = {100, 200, 300, 400};
        int k = 2;
        System.out.println(optimal(nums, k));
        System.out.println(bruteForce(nums, k));
        System.out.println(Arrays.toString(possibleFollowUp(nums, k)));
    }

    /*
    Optimal
    Runtime: O(n)
    Space: O(1)
    */
    public static int optimal(int[] nums, int k) {
        return -1;
    }

    /*
    Bruteforce (Generate all max windows of size k)
    Runtime: O(n * k)
    Space: O(1)
     */
    public static int bruteForce(int[] nums, int k) {
        int maxOverall = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = 0;
            for (int j = i; j < i + k; j++) {
                curr += nums[j];
            }
            maxOverall = Math.max(maxOverall, curr);
        }
        return maxOverall;
    }

    /*
    Follow up: Find the max and min window of size k and output it as = [max, min]
    */
    public static int[] possibleFollowUp(int[] nums, int k) {
        int maxOverall = Integer.MIN_VALUE, minOverall = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = 0;
            for (int j = i; j < i + k; j++) {
                curr += nums[j];
            }
            maxOverall = Math.max(maxOverall, curr);
            minOverall = Math.min(minOverall, curr);
        }
        return new int[]{maxOverall, minOverall};
    }
}
