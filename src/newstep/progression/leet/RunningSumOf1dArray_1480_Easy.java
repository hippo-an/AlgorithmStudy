package newstep.progression.leet;

public class RunningSumOf1dArray_1480_Easy {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
