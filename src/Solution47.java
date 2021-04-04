import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    //本题的重点在于排序去重
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] nums;
        int n;
        boolean[] visit;

        /**
         *
         * @param index 选择数字填写到path的index位置
         */
        public void backTrack(int index){
            if(index==n){
                ans.add(new ArrayList<>(path));
            }
            for(int i=0;i<n;i++){
                if(!visit[i]){
                    //如果前面的相同数字没有选说明排列的这个位置不能放置这个数字，所以这个数也不能够选
                    //此方法可以去重，否则同一个位置会填上两个相同的数字
                    if(i>=1&&!visit[i-1]&&nums[i]==nums[i-1]) continue;
                    path.add(nums[i]);
                    visit[i]=true;
                    backTrack(index+1);
                    visit[i]=false;
                    path.remove(path.size()-1);

                }
            }
        }

        public List<List<Integer>> permuteUnique(int[] _nums) {
            Arrays.sort(_nums);
            nums = _nums;
            n =nums.length;
            visit = new boolean[n];
            backTrack(0);
            return ans;

        }


    }

    @Test
    public void test(){
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}
