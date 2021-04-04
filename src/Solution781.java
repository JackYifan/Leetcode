import org.junit.Test;

import java.util.*;

/**
 * @Author Yifan Wu
 * Date on 2021/4/4  15:55
 */
public class Solution781 {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer,Integer> map = new HashMap();
            int other = 0;
            for(int i=0;i<answers.length;i++){
                map.put(answers[i],map.getOrDefault(answers[i],0)+1);
            }
            int sum = 0;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                int n = (int) Math.ceil(1.0*entry.getValue()/(entry.getKey()+1));
//                System.out.println(n);
                sum+=n*(entry.getKey()+1);
            }
            return sum;
        }
    }
    class Solution1 {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> count = new HashMap<Integer, Integer>();
            for (int y : answers) {
                count.put(y, count.getOrDefault(y, 0) + 1);
            }
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int y = entry.getKey(), x = entry.getValue();
                ans += (x + y) / (y + 1) * (y + 1); //向上取整
            }
            return ans;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int i = solution.numRabbits(new int[]{1, 0, 1, 0, 0});
        System.out.println(i);
    }
}
