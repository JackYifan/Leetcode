import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T64 {
    class Solution {
        Map<Character,Integer> count = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        //Insert one char from stringstream
        public void insert(char ch){
            count.put(ch,count.getOrDefault(ch,0)+1);
            if(count.get(ch)==1){
                q.add(ch);
            }else{
                while(!q.isEmpty()&&count.get(q.peek())>1){
                    q.poll();
                }
            }
        }
        //return the first appearence once char in current stringstream
        public char firstAppearingOnce(){
            if(q.isEmpty()){
                return '#';
            }else{
                return q.peek();
            }
        }
    }

}
