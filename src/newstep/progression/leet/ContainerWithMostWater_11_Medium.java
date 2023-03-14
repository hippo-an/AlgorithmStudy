package newstep.progression.leet;

public class ContainerWithMostWater_11_Medium {
    public int maxArea(int[] height) {
        int n = height.length - 1;

        int l = 0;
        int r = n;
        int ret = 0;

        while (l < r) {
            int current = n * Math.min(height[l], height[r]);
            if (current > ret) {
                ret = current;
            }

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }

            n -= 1;
        }

        return ret;
    }
}
