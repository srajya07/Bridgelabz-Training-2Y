package Array;

public class LC_1394 {
    public int findLucky(int[] arr) {
        int luckyinteger = -1;
        for(int i=0; i<arr.length; i++){
            int temp=arr[i];
            int count = 0;
            for(int j=0; j<arr.length; j++){
                if(temp==arr[j]){
                    count ++;
                }
            }
            if(count == temp){
                if(temp>luckyinteger){
                    luckyinteger = temp;
                }
            }
        }
        return luckyinteger;
    }
}
