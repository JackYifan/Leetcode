import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    class Solution1 {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int pos = i-j;
                    int x = map.getOrDefault(pos,-1);
                    if(x ==-1){
                        map.put(pos,matrix[i][j]);
                    }else{
                        if(x!=matrix[i][j]) return false ;
                    }
                }
            }
            return true;
        }
    }

    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    if(matrix[i][j]!=matrix[i-1][j-1]) return false ;
                }
            }
            return true;
        }
    }

    @Test
    public void test(){

    }
}
