import java.util.TreeMap;

/**
 * @Author Yifan Wu
 * Date on 2021/3/24  22:10
 */
public class Solution456 {
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            TreeMap<Integer,Integer> right = new TreeMap<>(); //记录右侧的所有元素,从1右边开始
            int min = nums[0];
            for(int i=2;i<n;i++) right.put(nums[i],right.getOrDefault(nums[i],0)+1);
            //遍历所有3
            for(int i=1;i<n-1;i++){
                if(min<nums[i]){
                    //二分查找右边的元素
                    Integer rightMin = right.ceilingKey(min + 1);
                    if(rightMin!=null&&rightMin<nums[i]){
                        return true;
                    }
                }
                //无论是否满足条件都需要更新Min
                min = Math.min(min,nums[i]);
                //将nums[i+1]从TreeMap中删除
                right.put(nums[i+1],right.get(nums[i+1])-1);
                if(right.get(nums[i+1])==0){
                    right.remove(nums[i+1]);
                }
            }
            return false ;

        }
    }
}
