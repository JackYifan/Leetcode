import java.util.ArrayList;
import java.util.List;

public class Solution39 {

    //candidates = [2,3,6,7], target = 7,
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path;
        int[] nums;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            nums=candidates;
            dfs(0,target);
            return ans;
        }
        public void dfs(int index,int rest){
            if(rest == 0){
                ans.add(new ArrayList<>(path));
                return;
            }
            if(index==nums.length) return;
            if(rest<0) return;
            path.add(nums[index]);
            dfs(index,rest-nums[index]);
            path.remove(path.size()-1);
            dfs(rest+1,rest);
        }
    }
}
