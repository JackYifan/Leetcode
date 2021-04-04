import org.junit.Test;

import java.util.Arrays;

public class Solution58 {
    //使用split函数，效率低
    class Solution1 {
        public int lengthOfLastWord(String s) {
            int n = s.length();
            String[] split = s.split(" ");
            if(split.length>=1){

                return split[split.length-1].length();
            }
//            System.out.println(Arrays.toString(split));
            return 0;
        }
    }

    class Solution {
        public int lengthOfLastWord(String s) {
            int n = s.length();
            int cnt = 0;
            int right = n-1;
            while(s.charAt(right)==' '){
                right--;
            }
            while(s.charAt(right)!=' '){
                right--;
                cnt++;
            }
            return cnt;
        }
    }



    @Test
    public void test(){
        Solution solution = new Solution();
        solution.lengthOfLastWord("    hello  word     ");
    }
}
