import java.util.List;

public class Solution112 {
    class Solution {

        /**
         *
         * @param root 当前结点
         * @param sum 路径和
         */
        public boolean dfs(TreeNode root,int sum,int targetSum){
            if(root.left==null&&root.right==null){
                sum+=root.val;
                if(sum==targetSum){
                    return true;
                }else{
                    return false;
                }
            }
            return (root.left!=null&&dfs(root.left,sum+root.val,targetSum))
                    || (root.right!=null&&dfs(root.right,sum+root.val,targetSum));
        }

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null&&targetSum==0) return false;
            return dfs(root,0,targetSum);

        }
    }
}
