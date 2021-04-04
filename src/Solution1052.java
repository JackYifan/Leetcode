public class Solution1052 {
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            //不使用技能计算初始值
            int n = customers.length;
            int sum = 0 ;
            for(int i=0;i<n;i++){
                if(grumpy[i]==0) sum+=customers[i];
            }
            //滑动窗口的大小为X
            //[right-X+1,right]\\
            int buff = 0;
            for(int i=0;i<X;i++){
                if(grumpy[i]==0) buff+=customers[i];
            }
            int maxBuff = buff;
            for(int i=X;i<n;i++){
                if(grumpy[i-X]==0) buff-=customers[i-X];
                if(grumpy[i]==1) buff+=customers[i];
                maxBuff = Math.max(maxBuff,buff);
            }
            return sum+maxBuff;

        }
    }
}
