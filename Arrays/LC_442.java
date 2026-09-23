package Array;

import java.util.ArrayList;
import java.util.HashSet;

public class LC_442 {
    public List<Integer> findDuplicates(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums)
        {
            if(set.contains(num))
            {
                ans.add(num);
            }
            set.add(num);
        }
        return ans;
    }
}
