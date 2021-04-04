import java.util.Map;

public class T61 {
    class Solution {
        public int longestSubstringWithoutDuplication(String s) {
            int n = s.length();
            int left = 0,right = 0;
            int res = 0;
            int[]map = new int[26];
            while(right<n){
                int r = s.charAt(right) - 'a';
                map[r]++;
                while(map[r]>1){
                    map[s.charAt(left)-'a']--;
                    left++;
                }
                res = Math.max(res,right-left+1);

            }
            return res;
        }
    }
}
