import org.junit.Test;

public class Solution50 {

    class Solution {
        public double myPow(double x, int _n) {
            boolean isMinus = false ;
            long n =_n;
            if(n<0) {
                isMinus = true;
                n=-n;
            }
            double ans = 1;
            while(n>0){
                if(n%2==1) {
                    ans *= x;
                }
                x*=x;
                n>>=1;
            }
            if(isMinus) return 1/ans;
            return ans;
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        double v = solution.myPow(2.000, -2147483648);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);//不能用-n，需要用Long类型接收
        System.out.println(v);
    }
}
