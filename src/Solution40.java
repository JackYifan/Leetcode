import org.junit.Test;

import java.util.*;

public class Solution40 {
    /**
     * 时间复杂度高
     */
    class Solution1 {
        Set<List<Integer>> res = new HashSet<>();
        int[] nums;
        int n ;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            nums = candidates;
            n = candidates.length;
            findPath(new ArrayList<Integer>(),0,target);
            return new ArrayList<>(res);
        }

        public void findPath(List<Integer> path,int index,int remain){
            // System.out.println(path);
            // System.out.println(index);
            // System.out.println(remain);
            if(remain==0){
                res.add(new ArrayList<>(path));
            }
            if(index==n) return;
            if(nums[index]>remain){
                return;
            }
            path.add(nums[index]);
            findPath(path,index+1,remain-nums[index]);
            path.remove(path.size()-1);
            findPath(path,index+1,remain);
        }
    }


    /**
     * 建立fre,表示数字和该数字出现的频率
     */
    class Solution2 {
        List<int[]>fre = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            int n = candidates.length;
            for(int i=0;i<n;i++){
                if(fre.isEmpty()||fre.get(fre.size()-1)[0]!=candidates[i]){
                    fre.add(new int[]{candidates[i],1});
                }else{
                    fre.get(fre.size()-1)[1]++;
                }
            }
            dfs(0,target);
            return ans;

        }
        /**
         *
         * @param index 当前在fre中的index
         * @param rest 剩余的数字
         */
        void dfs(int index,int rest){
            //判断退出条件和剪枝
            if(rest==0){
                ans.add(new ArrayList<Integer>(path));
                return ;
            }
            if(index==fre.size()||fre.get(index)[0]>rest){
                return ;
            }
            //不选
            dfs(index+1,rest);

            int most = Math.min(rest/fre.get(index)[0],fre.get(index)[1]);//最多可以放几个fre[index]
            //遍历尝试防止fre[index]
            for(int i=1;i<=most;i++){
                //一个一个放
                //放完dfs
                path.add(fre.get(index)[0]);
                //已经放置了i个
                dfs(index+1,rest-i*fre.get(index)[0]);
            }

            //将放置的所有数字移除
            for(int i=1;i<=most;i++){
                path.remove(path.size()-1);
            }
        }

    }



    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums;
        int n ;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            nums = candidates;
            n = candidates.length;
            findPath(new ArrayList<Integer>(),0,target);
            return res;
        }

        public void findPath(List<Integer> path,int index,int remain){

            if(remain==0){
                res.add(new ArrayList<>(path));
                return ;
            }
            for(int i=index;i<n;i++){
                if(nums[i]>remain) break;
                if(i>index&&nums[i-1]==nums[i]) continue;
                path.add(nums[index]);
                System.out.println(path);
                findPath(path,index+1,remain-nums[index]);
                path.remove(path.size()-1);
            }
        }
    }





    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        v.add(1);
        res.add(v);
        v.add(2);

    }
}
