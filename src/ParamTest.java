import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParamTest {
    public static void change(List<Integer> list){
        for(int i=0;i<5;i++){
            list.add(i);
        }
        LinkedList<Integer> integers = new LinkedList<>();
        for(int i=5;i<10;i++){
            integers.add(i);
        }
        list = integers;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list);
        change(list);
        System.out.println(list);
    }
}
