import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //按照left排序
            Arrays.sort(intervals,new Comparator<int[]>(){
                @Override
                public int compare(int[]a,int[]b){
                    return a[0]-b[0];
                }
            });
            List<int[]> merge = new ArrayList<>();
            int n = intervals.length;
            for(int i=0;i<n;i++){
                int left = intervals[i][0],right = intervals[i][1];
                if(merge.size()==0||merge.get(merge.size()-1)[1]<left){
                    merge.add(new int[]{left,right});
                }else{
                    merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1],right);
                }
            }
            return merge.toArray(new int[merge.size()][]); //list转Array的方法
        }
    }
}
