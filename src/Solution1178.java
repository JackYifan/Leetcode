import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1178 {
    class Solution {
        Map<Integer,Integer> map = new HashMap<>();
        public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
            //将words全部转二进制存入map
            for(String word:words){
                int mask = 0;//一位位相与
                for(int i=0;i<word.length();i++){
                    mask|=1<<(word.charAt(i)-'a');
                }
                //剪枝
                if(Integer.bitCount(mask)<=7){
                    map.put(mask,map.getOrDefault(mask,0)+1); //用26位二进制表示集合
                }
            }

            List<Integer> ans = new ArrayList<>();
            //匹配
            for(String puzzle:puzzles){
                //获取puzzle除了首字母的其他字母的子集合
                int total = 0;
                // [000000-111111]
                for(int choose = 0;choose<(1<<6);choose++){
                    //根据选择构造子集合
                    int mask = 0;
                    for(int i=0;i<6;i++){
                        if((choose&(1<<i))!=0){
                            //第i+1位被子集合选中
                            mask|=(1<<(puzzle.charAt(i+1)-'a'));
                        }
                    }
                    //第一位一定会被子集合选中
                    mask|=(1<<(puzzle.charAt(0)-'a'));
                    //判断子集合mask在map中有多少个
                    if(map.containsKey(mask)){
                        total+=map.get(mask);
                    }
                }
                ans.add(total);
            }
            return ans;
        }
    }

    @Test
    public void test(){
        int a = 3;
        System.out.println(Integer.bitCount(a));
    }
}
