public class Solution395 {
    class Solution {
        public int longestSubstring(String s, int k) {
            int ret = 0;
            int n = s.length();
            //出现字母的种类是[1,26]
            for(int kind = 1;kind<=26;kind++){
                //出现的字母种类数为kind
                int l = 0,r = 0;
                int[]cnt = new int[26];
                int tot = 0 ;//当前字母种类数
                int less = 0;
                //r从[0,n-1]遍历
                while(r<n){
                    //滑动窗口[l,r]
                    char right = s.charAt(r);
                    cnt[right -'a']++;
                    if(cnt[right -'a']==1){
                        //如果是新出现的字符
                        tot++;
                        less++;
                    }
                    if(cnt[right-'a']==k){
                        //right这种字符数目达标
                        less--;
                    }

                    while(tot>kind){
                        //种类数过多，收缩窗口 先将变量都改变后l++
                        char left = s.charAt(l);
                        cnt[left-'a']--;
                        if(cnt[left-'a']==k-1){
                            //恰好没有达标
                            less++;
                        }
                        if(cnt[left-'a']==0){
                            tot--;
                            less--;
                        }
                        l++;
                    }

                    if(less==0){
                        //以r结尾的滑动窗口满足要求
                        ret = Math.max(ret,r-l+1);
                    }
                    r++;
                }
            }
            return ret ;
        }
    }
}
