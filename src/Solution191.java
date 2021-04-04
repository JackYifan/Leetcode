/**
 * @Author Yifan Wu
 * Date on 2021/3/22  19:59
 */
public class Solution191 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while(n!=0){
                n = n&(n-1); //将最后一位的1变成0
                res++;
            }
            return res;
        }
    }

    public class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            for(int i=0;i<32;i++){
                if((n&(1<<i))!=0) res++;
            }
            return res;
        }
    }
}
