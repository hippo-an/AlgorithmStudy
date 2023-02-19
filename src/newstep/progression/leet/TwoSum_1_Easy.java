package newstep.progression.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1_Easy {
    public int[] twoSumOwn(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (num + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(target - nums[i])) {
                return new int[]{indices.get(target - nums[i]), i};
            }

            indices.put(nums[i], i);
        }
        return new int[]{};
    }
}
