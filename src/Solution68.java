import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/4/12  15:05
 */
public class Solution68 {
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            int n = words.length;
            int index=0;
            while(index<n){
                int len = 0;
                int start = index;
                int wordsNum = 0;
                while(index<n&&len+words[index].length()+wordsNum<=maxWidth){
                    len+=words[index++].length();
                    wordsNum++;
                }
                int end = index-1;
                //cur行的单词是[start,end]
                //下一行start = index
                int spaceNum = maxWidth-len;

                StringBuffer cur = new StringBuffer();
                if(wordsNum==1||index==n){
                    //左对齐
                    for(int i=start;i<=end;i++){
                        cur.append(words[i]);
                        if(i!=end) cur.append(" ");
                    }
                    for(int i=0;i<spaceNum-wordsNum+1;i++){
                        cur.append(" ");
                    }
                    res.add(cur.toString());
                    continue;
                }
                int perNum = spaceNum/(wordsNum-1);
                int lastNum = spaceNum%(wordsNum-1);
                for(int i=start;i<end;i++){
                    cur.append(words[i]);
                    if(i<start+lastNum){
                        for(int j=0;j<perNum+1;j++){
                            cur.append(" ");
                        }
                    }else{
                        //i==end-1最后一个单词前面的空格
                        for (int j=0;j<perNum;j++){
                            cur.append(" ");
                        }
                    }
                }
                cur.append(words[end]);
                res.add(cur.toString());


            }
            return res ;
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        List<String> list = solution.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"
        },16);
        System.out.println(list);
    }
}
