public class Solution48 {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            for(int i=0;i<n/2;i++){
                for(int j=0;j<(m+1)/2;j++){
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                    matrix[j][n-1-i]=t;
                }
            }
        }
    }
}
