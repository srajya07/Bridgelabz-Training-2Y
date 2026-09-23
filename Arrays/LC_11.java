public class LC_11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            if(height[left]>height[right]){
                int t = height[right]*(right-left);
                if(t>max){
                    max=t;
                }
                right--;
            }else{
                int t = height[left]*(right-left);
                if(t>max){
                    max=t;
                }
                left++;
            }
        }
        return max;
    }
}
