package Array;

public class LC_1295 {
    public int findNumbers(int[] nums) {

        int ans=0;
        for(int i=0;i<nums.length;i++){
            int c=0;
            int temp = nums[i];
            while(temp!=0){
                temp/=10;
                c++;
            }
            if(c%2==0){
                ans++;
            }
        }

        return ans;
    }
}
