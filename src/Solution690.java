import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Yifan Wu
 * Date on 2021/5/1  13:50
 */
public class Solution690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }


    class Solution {
        Map<Integer,Employee> map = new HashMap<>();
        int sum = 0;
        public int getImportance(List<Employee> employees, int id) {
            for(Employee employee:employees){
                map.put(employee.id,employee);
            }
            dfs(id);
            return sum;
        }
        public void dfs(int id){
            Employee e = map.get(id);
            sum+=e.importance;
            List<Integer> subordinates = e.subordinates;
            for(int subId:subordinates){
                dfs(subId);
            }
        }
    }
}
