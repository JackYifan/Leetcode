import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            boolean place = false ;//newInterval是否已经插入
            int n = intervals.length;
            int left = newInterval[0];
            int right = newInterval[1];
            List<int[]> ans = new ArrayList<>();
            int mostLeft = left;
            int mostRight = right;
            for(int i=0;i<n;i++){
                int L = intervals[i][0];
                int R = intervals[i][1];
                if(R<left){
                    ans.add(intervals[i]);
                }else if(L>right){
                    if(!place){
                        ans.add(new int[]{mostLeft,mostRight});
                    }
                    ans.add(intervals[i]);
                }else{
                    //区间有重合
                    mostLeft = Math.min(mostLeft,intervals[i][0]);
                    mostRight = Math.max(mostRight,intervals[i][1]);
                }

            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
}
