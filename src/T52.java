public class T52 {
    class Solution {
        public int moreThanHalfNum_Solution(int[] nums) {
            int cnt = 0,val = -1;
            for(int x:nums){
                if(cnt==0){
                    cnt=1;
                    val=x;
                }else{
                    if(x==val) cnt++;
                    else cnt--;
                }
            }
            return val;
        }
    }
}
