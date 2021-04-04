import javafx.scene.layout.Priority;
import org.junit.Test;

import java.util.*;

public class T53 {
    class Solution {
        public List<Integer> getLeastNumbers_Solution(int [] input, int k) {
            //大顶堆当存入一个数字比堆中的所有元素都大的时候会成为堆顶，此时弹出即可
            PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for(int x:input){
                heap.add(x);
                if(heap.size()>k){
                    heap.poll();
                }
            }
            List<Integer> ans = new LinkedList<>();
            while(!heap.isEmpty()){
                ans.add(0,heap.poll());
            }
            return ans;
        }
    }

    @Test
    public void test(){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(9);
        heap.add(8);
        heap.add(7);
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(5);
        for(int x:heap){
            System.out.println(x);
        }
    }

}
