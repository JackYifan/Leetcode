import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/4/4  14:09
 */
public class Solution90 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        int n;
        int[] nums ;
        public List<List<Integer>> subsetsWithDup(int[] _nums) {
            nums = _nums;
            n = nums.length;
            Arrays.sort(nums);
            dfs(false,0,new ArrayList<>());
            return ans;
        }
        public void dfs(boolean choosePre,int index,List<Integer> temp){
            if(index==n){
                ans.add(new ArrayList<>(temp));
                return ;
            }
            if(index!=0&&(!choosePre&&nums[index-1]==nums[index])) {
                dfs(false,index+1,temp);
                return ;
            }
            temp.add(nums[index]);
            dfs(true,index+1,temp);
            temp.remove(temp.size()-1);
            dfs(false,index+1,temp);
        }
    }
}
