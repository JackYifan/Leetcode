import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/5/9  22:29
 */
public class Solution1482 {
    class Solution {
        /**
         * 随着天数增加，花束从不可能变成可能
         */
        public int minDays(int[] bloomDay, int m, int k) {
            if(m>bloomDay.length/k) return -1; //防止溢出
            int high = Integer.MIN_VALUE;
            int low = Integer.MAX_VALUE;
            for(int i=0;i<bloomDay.length;i++){
                low = Math.min(bloomDay[i],low);
                high = Math.max(bloomDay[i],high);
            }
            //二分查找
            while(low<high){
                int mid = (low+high)>>1;
                if(canMake(bloomDay,m,k,mid)){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }
            return low;
        }

        /**
         * 判断第i天是否能做成花束
         * @param bloomDay
         * @param m
         * @param k
         * @param days
         * @return
         */
        public boolean canMake(int[] bloomDay,int m,int k,int days){
            int flowers = 0; //连续开放的花数
            int bunches = 0; //花的捆数
            for(int i=0;i<bloomDay.length;i++){
                //遍历每一朵花
                if(bloomDay[i]<=days){
                    //已经开放
                    flowers++;
                    if(flowers==k){
                        flowers = 0;
                        bunches++;
                        if(bunches==m) return true;
                    }
                }else{
                    flowers = 0;
                }
            }
            return bunches>=m;
        }

    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int ans = solution.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1);
        System.out.println(ans);
        List<Integer> list = new ArrayList<>();
    }
}
