public class Solution38 {
    class Solution {
        public String countAndSay(int n) {
            String s = "1";
            for(int i=0;i<n-1;i++){
                s=nextString(s);
            }
            return s;
        }
        //1211
        public String nextString(String s){
            s+="a";
            StringBuffer sb = new StringBuffer();
            char[] str = s.toCharArray();
            int n = s.length();
            int left =0 ,right = 0;
            while(left<n&&right<n){
                while(str[right]==str[left]) right++;
                sb.append(str[left]);
                sb.append(right-left);
                left = right;
            }
            return sb.toString();
        }
    }
}
