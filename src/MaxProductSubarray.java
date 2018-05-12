/**
 * Created by bzhao on 3/22/2018.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.


 */
public class MaxProductSubarray {
    public static void main (String[] args) {

    }
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int r = nums[0];
        int imax = r;
        int imin = r;
        for(int i = 1; i < len; i++){
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            r = Math.max(r, imax);
        }
        return r;
    }
}
