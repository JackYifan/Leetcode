import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/5/12  18:48
 */
public class Solution78 {
    /**
     * dfs
     */
    class Solution1 {
        List<List<Integer>> ans = new ArrayList<>();
        int[]nums ;
        public List<List<Integer>> subsets(int[] _nums) {
            nums = _nums;
            dfs(0,new ArrayList<>());
            return ans;
        }
        public void dfs(int cur,List<Integer> path){
            if(cur==nums.length){
                //加入的是空集合
                ans.add(new ArrayList<>(path));
                return;
            }
            //加入cur
            path.add(nums[cur]);
            dfs(cur+1,path);
            //不加入cur
            path.remove(path.size()-1);
            dfs(cur+1,path);

        }
    }

    /**
     * 使用位运算
     */
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            int mask = 0;
            int n = nums.length;
            // 000-111
            for(mask = 0;mask<(1<<n);mask++){
                //利用二进制判断每一位是否加入到答案中
                List<Integer> sub = new ArrayList<>();
                for(int i=0;i<n;i++){
                    if((mask&(1<<i))!=0){
                        //改位入选
                        sub.add(nums[i]);
                    }
                }
                ans.add(sub);
            }
            return ans;
        }
    }


    @Test
    public void test(){
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
