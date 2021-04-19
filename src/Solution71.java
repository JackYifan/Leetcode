import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/4/4  22:21
 */
public class Solution71 {
    class Solution {
        public String simplifyPath(String path) {
            List<String> pathList = new LinkedList<>();
            int n = path.length();
            int left = 0 ,right = 0;
            while(left<n&&right<n){
                left=right;
                while(left<n&&path.charAt(left)=='/') left++;
                right = left;
                while(right<n&&path.charAt(right)!='/') right++;
                String s = path.substring(left,right);
                if(s.equals(".")) continue;
                else if (s.equals("..")){
                    if(pathList.size()!=0) pathList.remove(pathList.size()-1);
                }else{
                    if(s.length()>0) pathList.add(s);
                }
            }
            StringBuffer ans = new StringBuffer();
            ans.append("/");
            for(int i=0;i<pathList.size();i++){
                ans.append(pathList.get(i));
                if(i!=pathList.size()-1) ans.append("/");
            }
            return ans.toString();

        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.simplifyPath("/a//b////c/d//././/..");
    }
}
