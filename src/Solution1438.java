import org.junit.Test;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution1438 {
    class Solution1 {
        public int longestSubarray(int[] nums, int limit) {
            int n = nums.length;
            int left = 0,right = 0 ;
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)->{return o2-o1;});
            int res = 0;
            //滑动窗口[left,right]
            while(left<n&&right<n){
                max.add(nums[right]);
                min.add(nums[right]);
                while(left<=right&&max.peek()-min.peek()>limit){
                    max.remove(nums[left]);
                    min.remove(nums[left]);
                    left++;
                }
                res = Math.max(res,right-left+1);
                right++;
            }
            return res;
        }
    }

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int n = nums.length;
            int left = 0,right = 0 ;
            TreeMap<Integer,Integer> map = new TreeMap<>();
            int res = 0;
            //滑动窗口[left,right]
            while(left<n&&right<n){
                map.put(nums[right],map.getOrDefault(nums[right],0)+1);
                while(map.lastKey()-map.firstKey()>limit){
                    map.put(nums[left],map.get(nums[left])-1);
                    if(map.get(nums[left])==0) {
                        map.remove(nums[left]);
                    }
                    left++;
                }
                res = Math.max(res,right-left+1);
                right++;
            }
            return res;
        }
    }



    @Test
    public void mainTest(){
        Solution solution = new Solution();
        int res = solution.longestSubarray(new int[]{8, 2, 4, 7}, 4);
        System.out.println(res);
    }



    @Test
    public void test(){
        PriorityQueue<Integer> max = new PriorityQueue<>();
        for(int i=0;i<10;i++){
            max.add(1);
        }
        max.remove(1);
        while(max.size()>0){
            System.out.println(max.poll());
        }
    }
}
