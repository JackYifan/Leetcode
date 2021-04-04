import java.util.ArrayList;
import java.util.List;

public class Solution113 {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        /**
         *
         * @param root 当前结点
         * @param path 已经加入路径的结点
         * @param target 目标
         */
        public void dfs1(TreeNode root, List<Integer> path, int sum, int target) {
            if(root.left==null&&root.right==null){
                //到达叶结点
                if(sum + root.val == target){
                    path.add(root.val);
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size()-1);
                    return ;
                }

            }
            path.add(root.val);
            if(root.left!=null){
                dfs1(root.left,path,sum+root.val,target);
            }
            if(root.right!=null){
                dfs1(root.right,path,sum+root.val,target);
            }
            path.remove(path.size()-1);
        }

        public void dfs(TreeNode root, List<Integer> path,int target) {
            if(root == null ) return ;
            path.add(root.val);
            target -= root.val;
            if(root.left==null&&root.right==null&&target==0){
                ans.add(new ArrayList<>(path));
            }
            dfs(root.left,path,target);
            dfs(root.right,path,target);
            path.remove(path.size()-1);
        }



        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if(root == null) return ans;
            dfs(root,new ArrayList<Integer>(),targetSum);
            return ans;
        }
    }



}

