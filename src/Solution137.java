import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yifan Wu
 * Date on 2021/4/30  11:32
 */
public class Solution137 {
    class Solution1 {
        public int singleNumber(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                if(entry.getValue()==1){
                    return entry.getKey();
                }
            }
            return 0;
        }
    }

    /**
     * 位运算解法
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0 ;
            for(int i=0;i<32;i++){
                //第i位
                int sum = 0;
                for(int num:nums){
                    sum+=(num>>i)&1;
                }
                ans|=(sum%3)<<i;

            }
            return ans;
        }
    }
}
