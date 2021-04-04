import java.util.Comparator;
import java.util.PriorityQueue;

public class T54 {
    class Solution {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });


        //minHeap的元素和maxHeap相等或者多一个
        public void insert(Integer num) {
            minHeap.add(num);
            if(maxHeap.size()>=1&&minHeap.peek()>maxHeap.peek()){
                Integer minTop = minHeap.poll();
                Integer maxTop = maxHeap.poll();
                maxHeap.add(minTop);
                minHeap.add(maxTop);
            }
            if(minHeap.size()-maxHeap.size()>=2){
                Integer minTop = minHeap.poll();
                maxHeap.add(minTop);
            }
        }

        public Double getMedian() {
            if((minHeap.size()+maxHeap.size()&1)==1){
                //数量总和是奇数
                Integer peek = minHeap.peek();
                return peek*1.0;
            }else{
                return (minHeap.peek()+maxHeap.peek())/2.0;
            }
        }

    }
}
