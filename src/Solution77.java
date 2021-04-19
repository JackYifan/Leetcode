import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/4/19  13:26
 */
public class Solution77 {
    class Solution1 {
        public List<List<Integer>> res;
        public List<Integer> path = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            dfs(0,0,n,k);
            return res ;
        }
        public void dfs(int depth,int pre,int n,int k){
            if(depth==k){
                res.add(new ArrayList<>(path));
                return ;
            }
            for(int i=pre+1;i<=n;i++){
                path.add(i);
                dfs(depth+1,i,n,k);
                path.remove(path.size()-1);
            }
        }
    }

    //剪枝优化
    class Solution {
        public List<List<Integer>> res;
        public List<Integer> path = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            dfs(0,0,n,k);
            return res ;
        }
        public void dfs(int depth,int pre,int n,int k){
            if(depth==k){
                res.add(new ArrayList<>(path));
                return ;
            }
            for(int i=pre+1;i<=n-(k-path.size())+1;i++){
                path.add(i);
                dfs(depth+1,i,n,k);
                path.remove(path.size()-1);
            }
        }
    }
}
