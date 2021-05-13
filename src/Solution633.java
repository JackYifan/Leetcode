/**
 * @Author Yifan Wu
 * Date on 2021/4/30  12:58
 */
public class Solution633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0;
            int right = (int)Math.sqrt((double)c);
            while(left<=right){
                long t = left*left+right*right;
                if(t==c){
                    return true;
                }else if(t<c){
                    left++;
                }else{
                    right--;
                }
            }
            return false ;
        }
    }
}
