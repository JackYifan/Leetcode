import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T51 {
    class Solution1 {
        List<List<Integer>> ans = new ArrayList<>();
        int n;
        boolean[]visit;

        /**
         *
         * @param nums
         * @param path
         * @param index 正在填写的path路径的index
         */
        public void dfs(int[]nums,List<Integer> path,int index){
            if(index==n){
                ans.add(new ArrayList<Integer>(path));
            }
            for(int i=0;i<n;i++){
                if(!visit[i]){
                    if(i>0&&!visit[i-1]&&nums[i]==nums[i-1]) continue;
                    path.add(nums[i]);
                    visit[i]=true;
                    dfs(nums,path,index+1);
                    path.remove(path.size()-1);
                    visit[i]=false ;
                }

            }
        }

        public List<List<Integer>> permutation(int[] nums) {
            Arrays.sort(nums);
            n = nums.length;
            visit = new boolean[n];
            dfs(nums,new ArrayList<>(),0);
            return ans;
        }
    }

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path ;

        /**
         *
         * @param nums
         * @param index nums[index]选择填写的位置
         * @param begin path可选位置的起始位置
         * @param state 二进制表示的状态
         */
        public void dfs(int[] nums,int index,int begin,int state){
            if(index==nums.length){
                ans.add(new ArrayList<Integer>(path));
                return ;
            }
            if(index==0||nums[index]!=nums[index-1]){
                begin = 0; //从0开始的位置都能选择
            }
            for(int i=begin;i<nums.length;i++){
                if((state>>i&1)==0){
                    //path的第i位没有放置元素
                    path.set(i,nums[index]);
                    dfs(nums,index+1,i+1,state+(1<<i));
                }
            }

        }

        public List<List<Integer>> permutation(int[] nums) {
            Arrays.sort(nums);
            path = new ArrayList<Integer>(Collections.nCopies(nums.length,0));
            dfs(nums,0,0,0);
            return ans;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        List<List<Integer>> permutation = solution.permutation(new int[]{1, 2, 3});
        System.out.println(permutation);
    }


}
