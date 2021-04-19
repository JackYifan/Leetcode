import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/4/19  13:56
 */
public class Solution93 {
    class Solution {
        List<String> res = new ArrayList<>();
        String s;
        public List<String> restoreIpAddresses(String _s) {
            s = _s;
            dfs(new StringBuffer(),0,0);
            return res;
        }

        /**
         *
         * @param temp 目前已经创建的字符串
         * @param num 已经存在的个数
         * @param index 从s的index开始
         */
        public void dfs(StringBuffer temp,int num,int index){
            if(num==4){
                if(index==s.length()) res.add(temp.deleteCharAt(temp.length()-1).toString());
                else return ;
            }
            //剪枝
            int charNum = s.length()-index;
            if(charNum<4-num||charNum>3*(4-num)) return ;
            for(int i=1;i<=3;i++){
                if(index+i>s.length()) break;
                String ip = s.substring(index, index + i);
                if(ip.length()>=2&&ip.startsWith("0")) continue;
                if(Integer.parseInt(ip)>255) continue;
                StringBuffer oldTemp = new StringBuffer(temp);
                temp.append(ip+".");
                dfs(temp,num+1,index+i);
                temp = oldTemp;
            }
        }

    }

    /**
     * 官方题解
     */
    class Solution1 {
        static final int SEG_COUNT = 4;
        List<String> ans = new ArrayList<String>();
        int[] segments = new int[SEG_COUNT];

        public List<String> restoreIpAddresses(String s) {
            segments = new int[SEG_COUNT];
            dfs(s, 0, 0);
            return ans;
        }

        public void dfs(String s, int segId, int segStart) {
            // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
            if (segId == SEG_COUNT) {
                if (segStart == s.length()) {
                    StringBuffer ipAddr = new StringBuffer();
                    for (int i = 0; i < SEG_COUNT; ++i) {
                        ipAddr.append(segments[i]);
                        if (i != SEG_COUNT - 1) {
                            ipAddr.append('.');
                        }
                    }
                    ans.add(ipAddr.toString());
                }
                return;
            }

            // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
            if (segStart == s.length()) {
                return;
            }

            // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
            if (s.charAt(segStart) == '0') {
                segments[segId] = 0;
                dfs(s, segId + 1, segStart + 1);
            }

            // 一般情况，枚举每一种可能性并递归
            int addr = 0;
            for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
                addr = addr * 10 + (s.charAt(segEnd) - '0');
                if (addr > 0 && addr <= 0xFF) {
                    segments[segId] = addr;
                    dfs(s, segId + 1, segEnd + 1);
                } else {
                    break;
                }
            }
        }
    }


    @Test
    public void test(){
        Solution solution = new Solution();
        List<String> list = solution.restoreIpAddresses("25525511135");
        System.out.println(list);

    }
}
