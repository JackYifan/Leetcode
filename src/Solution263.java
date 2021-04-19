import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/4/12  14:27
 */
public class Solution263 {
    class Solution {
        public boolean isUgly(int n) {
            int[] nums = new int[]{2,3,5};
            for(int x:nums){
                while(n%x==0){
                    n/=x;
                }
            }
            return n==1;
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        boolean ugly = solution.isUgly(8);
        System.out.println(ugly);
    }

}
