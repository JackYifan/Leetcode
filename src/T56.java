import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T56 {
    class Solution {
        public int numberOf1Between1AndN_Solution(int n) {
            List<Integer> list = new ArrayList<>();
            //从低位存到高位
            while(n!=0){
                list.add(n%10);
                n/=10;
            }
            System.out.println(list);//54321
            int res = 0;
            for(int i=list.size()-1;i>=0;i--){
                int left = 0,right = 0;
                int t= 1;
                for(int j=list.size()-1;j>i;j--) left = left*10+list.get(j);
                for(int j=i-1;j>=0;j--) {
                    right = right*10+list.get(j);
                    t*=10;
                }
                //000-999
                res+=left*t;
                if(list.get(i)==1) res+=right+1;//000-345
                else if(list.get(i)>1) res+=t; //000-999
            }

            return res ;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.numberOf1Between1AndN_Solution(12345);
    }

}
