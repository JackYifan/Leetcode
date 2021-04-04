import java.util.*;

public class Solution49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
//            List<List<String>> ans = new ArrayList<>();
            Map<String,List<String>> map = new HashMap<>();
            for(String s:strs){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(s);
                map.put(key,list);
            }
            return new ArrayList<List<String>>(map.values()) ; //注意不能强转，需要使用构造函数
        }
    }
}
