import java.util.Arrays;

/**
 * @Author Yifan Wu
 * Date on 2021/4/4  21:18
 */
public class Solution66 {
    class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            int index = n-1;
            digits[n-1]++;
            while(index>=0&&digits[index]==9){
                digits[--index]++;
            }
            if(index!=-1){
                return digits;
            }else{
                int[]ans = new int[n+1];
                ans[0]=1;
                for(int i=0;i<n;i++){
                    ans[i+1]=digits[i];
                }
                return ans;
            }

        }
    }
}
