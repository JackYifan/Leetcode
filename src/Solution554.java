import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Yifan Wu
 * Date on 2021/5/2  23:43
 */
public class Solution554 {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            int n = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for(Integer width : wall.get(0)){
                n+=width;
            }
            for(List<Integer> list : wall){
                int sum = 0;
                for(Integer width : list){
                    sum+=width;
                    if(sum!=n) map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
            int max = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }
            return wall.size()-max;
        }
    }

}
