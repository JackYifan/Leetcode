import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Yifan Wu
 * Date on 2021/4/12  12:08
 */
public class Solution179 {
    class Solution {
        public String largestNumber(int[] nums) {
            StringBuffer res = new StringBuffer();
            int n = nums.length;
            String[]arr = new String[n];
            for(int i=0;i<n;i++){
                arr[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1+o2).compareTo(o2+o1);
                }
            });
            for(int i=n-1;i>=0;i--){
                res.append(arr[i]);
            }
            String s = res.toString();
            while(s.length()>1&&s.charAt(0)=='0') s = s.substring(1);
            return s;
        }
    }
    @Test
    public void  test(){
        Solution solution = new Solution();
        String s = solution.largestNumber(new int[]{0, 0});
        System.out.println(s);

    }
}
