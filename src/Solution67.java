/**
 * @Author Yifan Wu
 * Date on 2021/4/4  22:09
 */
public class Solution67 {
    class Solution {
        public String addBinary(String a, String b) {
            int n = a.length();
            int m = b.length();
            StringBuffer ans = new StringBuffer();
            int ci = 0;
            for(int i=n-1,j=m-1;i>=0||j>=0;i--,j--){
                int aa = (i>=0?a.charAt(i)-'0':0);
                int bb = (j>=0?b.charAt(j)-'0':0);
                int sum = aa+bb+ci;
                ans.append(sum%2);
                ci = sum/2;
            }
            if(ci==1) ans.append(1);
            return ans.reverse().toString();
        }
    }

}
