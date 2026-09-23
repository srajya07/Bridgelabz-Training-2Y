import java.util.Arrays;

public class LC_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closum = nums[0]+nums[1]+nums[2];
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return sum;
                }
                if(Math.abs(sum-target)<Math.abs(closum-target)){
                    closum = sum;
                }
                if(sum<target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return closum;
    }
}

