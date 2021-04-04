import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class T58 {
    class Solution {
        public String printMinNumber(int[] _nums) {
            Integer[] nums = new Integer[_nums.length];
            for(int i=0;i<_nums.length;i++){
                nums[i]=_nums[i];
            }
            Arrays.sort(nums,new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    String a = Integer.toString(o1);
                    String b = Integer.toString(o2);
                    return (a+b).compareTo(b+a);
                }
            });

            StringBuffer sb = new StringBuffer();
            for(int i=0;i<nums.length;i++){
                sb.append(nums[i]);
            }
            return sb.toString();

        }
    }
}
