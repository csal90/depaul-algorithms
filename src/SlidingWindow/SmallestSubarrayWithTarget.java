package SlidingWindow;

public class SmallestSubarrayWithTarget {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(optimal(target, nums));
        System.out.println(bruteForce(target, nums));
    }

    /*
    Brute Force:
    Time complexity: O(n^3) or O(n^2)
    Space complexity: O(1)

    Optimal:
    Time complexity: O(n)
    Space complexity: O(1)
    */

    public static int optimal(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int currWindow = 0, smallestWindow = Integer.MAX_VALUE;

        while (j < n) {
            currWindow += nums[j++]; // open the window
            while (currWindow >= target) { // close the window
                smallestWindow = Math.min(smallestWindow, j - i);
                currWindow -= nums[i++];
            }
        }
        return smallestWindow == Integer.MAX_VALUE ? 0 : smallestWindow;
    }

    public static int bruteForce(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currWindow = 0;
            for (int j = i; j < n; j++) {
                currWindow += nums[j]; // current window
                if (currWindow >= target) {
                    result = Math.min(result, j - i + 1); // we can no longer extend, calculate size of window
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
