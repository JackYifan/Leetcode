import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author Yifan Wu
 * Date on 2021/4/22  11:23
 */
public class Solution363 {
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int ans = Integer.MIN_VALUE;
            int m = matrix.length;int n = matrix[0].length;
            for(int i=0;i<m;i++){
                //上边界确定为i
                int[]sum = new int[n]; //sum随下边界改变而增加,是每列[i:j]的和
                for(int j=i;j<m;j++){
                    //更新sum 上下边界确定是[i,j]
                    for(int c=0;c<n;c++){
                        sum[c] += matrix[j][c];
                    }
                    TreeSet<Integer> sumSet = new TreeSet<>(); //用于存储遍历的列之前的所有前缀和信息,并能进行二分查找
                    sumSet.add(0); //前缀和定义s0=0,处理只有一列的情况
                    int s = 0; //记录前缀和
                    for(int x:sum){
                        s+=x;
                        Integer ceiling = sumSet.ceiling(s - k);
                        if(ceiling!=null){
                            ans = Math.max(ans,s-ceiling);
                        }
                        sumSet.add(s); //将当前前缀和加入set中，下一次可以查找到
                    }
                }
            }
            return ans;
        }
    }
}
