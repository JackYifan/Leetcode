import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/4/13  15:30
 */
public class Solution783 {
    class Solution1 {
        List<Integer> list = new ArrayList<>();
        public void dfs(TreeNode root){
            if(root==null) return ;
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
        public int minDiffInBST(TreeNode root) {
            dfs(root);
            int res = Integer.MAX_VALUE;
            for(int i=0;i<list.size()-1;i++){
                res=Math.min(res,list.get(i+1)-list.get(i));
            }
            return res;
        }
    }
    class Solution {
        int pre;
        int min;
        public int minDiffInBST(TreeNode root) {
            pre = -1;
            min = Integer.MAX_VALUE;
            dfs(root);
            return min ;
        }
        public void dfs(TreeNode root){

            if(root==null) return ;
            dfs(root.left);
            if(pre==-1){
                //根结点
                pre = root.val;
            }else{
                min = Math.min(min,root.val-pre);
                pre = root.val;
            }
            dfs(root.right);
        }
    }
}
