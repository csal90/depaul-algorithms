package SlidingWindow;

public class MaxConsecutiveOnesIII_7 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, onesCount = 0, n = nums.length;
        int res = Integer.MIN_VALUE;

        while (r < n) {
            int right = nums[r];
            if (right == 1) {
                onesCount++;
            }
            if (r - l + 1 - onesCount > k) {
                int left = nums[l++];
                if (left == 1) {
                    onesCount--;
                }
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}
