import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/5/10  23:49
 */
public class Solution872 {
    class Solution {
        List<Integer> list1 = new ArrayList<>();
        List<Integer>list2 = new ArrayList<>();
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            dfs1(root1);
            dfs2(root2);
            int len1 = list1.size();
            int len2 = list2.size();
            if(len1!=len2) return false;
            for(int i=0;i<len1;i++){
                if(list1.get(i)!=list2.get(i)) return false;
            }
            return true;
        }
        public void dfs1(TreeNode root){
            if(root.left==null&&root.right==null) {
                list1.add(root.val);
            }
            if(root.left!=null) dfs1(root.left);
            if(root.right!=null) dfs1(root.right);
        }
        public void dfs2(TreeNode root){
            if(root.left==null&&root.right==null) {
                list2.add(root.val);
            }
            if(root.left!=null) dfs2(root.left);
            if(root.right!=null) dfs2(root.right);
        }
    }
}
