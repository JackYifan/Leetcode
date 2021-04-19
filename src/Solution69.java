import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/4/8  19:43
 */
public class Solution69 {
    class Solution {
        public int mySqrt(int x) {
            //res^2<=X的最大值
            long left = 0,right = x;
            while(left<right){
                long mid = (left+right+1)>>1;
                if(mid*mid<=x) left = mid;
                else right = mid-1;
            }
            return (int)left;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.mySqrt(2147483647);

    }
}
