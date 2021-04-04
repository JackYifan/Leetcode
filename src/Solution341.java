import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/3/23  23:04
 */
public class Solution341 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

      public interface NestedInteger {

            // @return true if this NestedInteger holds a single integer, rather than a nested list.
            public boolean isInteger();

            // @return the single integer that this NestedInteger holds, if it holds a single integer
            // Return null if this NestedInteger holds a nested list
            public Integer getInteger();

            // @return the nested list that this NestedInteger holds, if it holds a nested list
            // Return null if this NestedInteger holds a single integer
            public List<NestedInteger> getList();
      }


    public class NestedIterator implements Iterator<Integer> {

        List<Integer> list = new ArrayList<>();
        int index = 0;
        public void dfs(List<NestedInteger> nestedIntegerList){
            for(NestedInteger nestedInteger:nestedIntegerList){
                if(nestedInteger.isInteger()){
                    list.add(nestedInteger.getInteger());
                }else{
                    dfs(nestedInteger.getList());
                }
            }


        }

        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        @Override
        public Integer next() {
            int res = list.get(index);
            index++;
            return res;
        }

        @Override
        public boolean hasNext() {
            return index<list.size();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
