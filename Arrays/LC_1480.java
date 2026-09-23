package Array;

public class LC_1480 {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[n] result = new result;

        for(int i=0 ; i<=nums.length-1 ; i++){
            sum = sum + nums[i];
            result[i] = sum;

        }
        return result ;
    }
}
