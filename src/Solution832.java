import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class Solution832 {
    class Solution1 {
        public int[][] flipAndInvertImage(int[][] A) {
            int n = A.length;
            int m = A[0].length;
            for(int i=0;i<n;i++){
                for(int j=0;j<m/2;j++){
                    int t = A[i][j];
                    A[i][j] = A[i][m-1-j];
                    A[i][m-1-j] = t;
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    A[i][j] = 1-A[i][j];
                }
            }

//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(A[i]));
//            }
            return A;
        }
    }
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int n = A.length;
            int m = A[0].length;
            for(int i=0;i<n;i++){
                int left = 0,right = m-1;
                while(left<right){
                    if(A[i][left]==A[i][right]){
                        //如果两数相等，不用交换
                        A[i][left]^=1;//1^1=0 0^1=1
                        A[i][right]^=1;
                    }
                    //两数不等，交换后^1相当于没变
                }
                if(left==right){
                    //数组长度为奇数
                    A[i][left]^=1;
                }
            }
            return A;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }

}
