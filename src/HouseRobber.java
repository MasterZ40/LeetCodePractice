/**
 * Created by bzhao on 3/22/2018.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        int maxOne = nums[0];
        int maxTwo = 0;
        for(int i = 1; i < len ; i++){
            int newMaxTwo = maxOne;
            int newMaxOne = Math.max(nums[i] + maxTwo, maxOne);
            maxOne = newMaxOne;
            maxTwo = newMaxTwo;
        }
        return maxOne;
    }
}
