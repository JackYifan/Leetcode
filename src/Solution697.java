import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution697 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer,int[]> map = new HashMap<>();
            //{num,firstIndex,LastIndex}
            int n = nums.length;
            for(int i=0;i<n;i++){
                if(map.containsKey(nums[i])){
                    map.get(nums[i])[0]++;
                    map.get(nums[i])[2]=i;
                }else{
                    map.put(nums[i],new int[]{1,i,i});
                }
            }

            // Set<Integer>st = map.keySet();
            // for(Integer key : st){
            //     System.out.println(Arrays.toString(map.get(key)));
            // }

            int maxNum = 0,minLen = Integer.MAX_VALUE;

            Set<Map.Entry<Integer, int[]>> entrySet = map.entrySet();
            for(Map.Entry<Integer,int[]> entry:entrySet){
                int[] arr = entry.getValue();
                if(arr[0]>maxNum){
                    maxNum = arr[0] ;
                    minLen = arr[2]-arr[1]+1;
                }else if(arr[0] == maxNum){
                    minLen = Math.min(minLen,arr[2]-arr[1]+1);
                }

            }

            return minLen;
        }
    }
}
