import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Solution896 {
    class Solution1 {
        public boolean isMonotonic(int[] A) {
//            Stack<Integer> st = new Stack<>();
            if(A==null) return true;
            if(A.length==1) return true;
            boolean flag = A[0]>A[1];
            int j = 1;
            while(j<A.length){
                if(A[j]!=A[j-1]){
                    flag = A[j]>A[j-1];
                    break;
                }
                j++;
            }

            for(int i=j;i<A.length;i++){
                if(A[i]==A[i-1]) continue;
                if(A[i]>A[i-1]!=flag) return false;
            }
            return true;

        }
    }

    class Solution {
        public boolean isMonotonic(int[] A) {
            boolean asc = false ,desc = false ;
            for(int i=1;i<A.length;i++){
                if(A[i]>A[i-1]) asc = true;
                if(A[i]<A[i-1]) desc = true;
            }
            return asc|desc;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.isMonotonic(new int[]{1,1,2});
    }
}
