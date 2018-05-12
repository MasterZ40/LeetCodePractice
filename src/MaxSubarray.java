/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubarray {

    public static void main (String[] args) {

    }
    public static int maxSubarray(int[] nums) {
        int len = nums.length;
        int r = nums[0];
        int currentMax = r;
        for(int i = 1; i < len; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            r = Math.max(currentMax, r);
        }
        return r;
    }
}
