/**
 * @Author Yifan Wu
 * Date on 2021/3/30  18:42
 */
public class Solution74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // i -> (i/m,i%m)
            int n = matrix.length;
            int m = matrix[0].length;
            int left = 0,right = n*m-1;
            while(left<right){
                int mid = (left+right+1)>>1;
                if(matrix[mid/m][mid%m]>target){
                    right = mid-1;
                }else{
                    left = mid;
                }
            }
            if(matrix[left/m][left%m]==target) return true;
            else return false ;
        }
    }
}
