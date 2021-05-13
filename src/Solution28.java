/**
 * @Author Yifan Wu
 * Date on 2021/4/21  21:32
 */
public class Solution28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.isEmpty()) return 0;
            int n = haystack.length();
            int m = needle.length();
            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();
            int[] next = new int[m];
            //构建next数组
            for(int i=1,j=0;i<m;i++){
                while(j>0&&p[j]!=p[i]){
                    //不匹配
                    j = next[j-1];
                }
                if(p[i]==p[j]) j++; //此时j可能为0，如果匹配j++;
                next[i]=j;
            }
            //字符串匹配 i,j双指针
            for(int i=0,j=0;i<n;i++){
                while(j>0&&s[i]!=p[j]){
                    //不匹配
                    j = next[j-1];
                }
                if(s[i]==p[j]) j++;
                if(j==m){
                    //匹配成功,i是最后一个字母的index
                    return i-m+1;
                }
            }
            return -1;
        }
    }
}
