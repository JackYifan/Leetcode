import java.util.ArrayList;
import java.util.List;

public class T62 {
    class Solution {
        public int getUglyNumber(int n) {
            List<Integer> q = new ArrayList<>();
            q.add(1);
            int i = 0,j = 0,k = 0;
            while((--n)!=0){
                int t = Math.min(q.get(i)*2,Math.min(q.get(j)*3,q.get(k)*5));
                q.add(t);
                if(q.get(i)*2==t) i++;
                if(q.get(j)*3==t) j++;
                if(q.get(k)*5==t) k++;
            }
            return q.get(q.size()-1);
        }
    }
}
