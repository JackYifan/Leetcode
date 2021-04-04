import org.junit.Test;

public class T57 {
    class Solution {
        public int digitAtIndex(int n) {
            if(n==0) return 0 ;
            //从零开始计数
            int i = 1;//几位数
            int s = 9;
            int base = 1;
            while(n>s*i){
                n-=s*i;
                i++;
                s*=10;
                base*=10;
            }
            //i位数的第n个数字
            int num = base + (n-1)/i;
            int digit = n%i==0?i:(n%i);
            //6789 3
            for(int j =0;j<i-digit;j++){
                num/=10;
            }
            return num%10 ;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.digitAtIndex(1);
    }

}
