package SlidingWindow;

public class _2_SmallestSubarrayWithTarget {
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
    This sol uses two pointers:
    1) We first move r until we get a sum >= target
    2) Then, we move l to the RIGHT until sum < target
    3) During this, we store the min length between l and r

    Time complexity explained:
    Our main while loop (r < n) takes O(n) time since r will visit each element in our array once.
    The inner while loop is not dependent on our input size n therefore it does not create a quadratic solution.
    It is simply checking a condition and updating our variables.
    */

    public static int optimal(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int sum = 0, res = Integer.MAX_VALUE;

        while (r < n) {
            sum += nums[r++];
            while (sum >= target) {
                res = Math.min(res, r - l);
                sum -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
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
