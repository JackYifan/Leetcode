import java.util.TreeSet;

/**
 * @Author Yifan Wu
 * Date on 2021/4/17  23:26
 */
public class Solution220 {
    class Solution {
        // [i-k,i+k] contains[nums[i]-t,num[i]+t]
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> set = new TreeSet<>();
            for(int i=0;i<n;i++){
                Long ceiling = set.ceiling((long) nums[i] - (long) t); //等价于C++中的lower_bound
                if(ceiling!=null && ceiling <= (long)nums[i] + (long)t){
                    return true;
                }
                //移到下一个窗口
                set.add((long)nums[i]);
                if(i>=k){
                    set.remove((long)nums[i-k]);
                }
            }
            return false ;
        }
    }
}
