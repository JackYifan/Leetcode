import org.junit.Test;

public class Solution995 {
    class Solution {
        public int minKBitFlips(int[] A, int K) {
            int n = A.length;
            int[]dif = new int[n+1];//差分数组
            int res = 0 , cnt = 0;//当前已经翻转的次数
            for(int i=0;i<n;i++){
                cnt+=dif[i];
                if((A[i]+cnt)%2==0){
                    //需要翻转但不能翻转返回-1
                    if(i+K>n){
                        return -1;
                    }
                    //翻转[i,i+k-1]
                    res++;
                    cnt++;
                    dif[i+K]--;//最大为dif[n]
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[]A = new int[]{0,1,0};
        int K = 2;
        Solution solution = new Solution();
        int res = solution.minKBitFlips(A, K);
        System.out.println(res);
    }
}
