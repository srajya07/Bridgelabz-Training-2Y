package Array;

import java.util.ArrayList;

public class LC_2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) r.add(i);
        }
        return r;
    }
}

