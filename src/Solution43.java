import org.junit.Test;

public class Solution43 {
    class Solution1 {
        public String multiply(String num1, String num2) {
            if(num1.equals("0")||num2.equals("0")) return "0";
            int n = num1.length();
            int m = num2.length();
            String ans = "0";
            for(int i=m-1;i>=0;i--){
                int x = (num2.charAt(i)-'0');
                int add = 0;
                StringBuilder sb = new StringBuilder();
                for(int j=i;j<m-1;j++){
                    sb.append("0");
                }
                for(int j=n-1;j>=0;j--){
                    int t = (num1.charAt(j)-'0')*x+add;
                    sb.append(t%10);
                    add = t/10;
                }
                while(add>0){
                    sb.append(add%10);
                    add/=10;
                }
                ans = addNum(ans,sb.reverse().toString());
            }
            return ans;
        }

        public String addNum(String a,String b){
            int n = a.length();
            int m = b.length();
            int i=n-1,j=m-1;
            int add = 0;
            StringBuilder ans = new StringBuilder();

            while(i>=0||j>=0||add!=0){
                int x = (i>=0)? a.charAt(i)-'0':0;
                int y = (j>=0)? b.charAt(j)-'0':0;
                int t = x + y + add;
                ans.append(t%10);
                add = t / 10;
                i--;
                j--;

            }
            return ans.reverse().toString();
        }

        class Solution {
            public String multiply(String num1, String num2) {
                if (num1.equals("0") || num2.equals("0")) {
                    return "0";
                }
                int m = num1.length(), n = num2.length();
                int[] ansArr = new int[m + n];
                for (int i = m - 1; i >= 0; i--) {
                    int x = num1.charAt(i) - '0';
                    for (int j = n - 1; j >= 0; j--) {
                        int y = num2.charAt(j) - '0';
                        ansArr[i + j + 1] += x * y;
                    }
                }
                for (int i = m + n - 1; i > 0; i--) {
                    ansArr[i - 1] += ansArr[i] / 10;
                    ansArr[i] %= 10;
                }
                int index = ansArr[0] == 0 ? 1 : 0;
                StringBuffer ans = new StringBuffer();
                while (index < m + n) {
                    ans.append(ansArr[index]);
                    index++;
                }
                return ans.toString();
            }
        }

    }

    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int m = num1.length(), n = num2.length();
            int[] ansArr = new int[m + n];
            for (int i = m - 1; i >= 0; i--) {
                int x = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int y = num2.charAt(j) - '0';
                    ansArr[i + j + 1] += x * y;
                }
            }
            for (int i = m + n - 1; i > 0; i--) {
                ansArr[i - 1] += ansArr[i] / 10;
                ansArr[i] %= 10;
            }
            int index = ansArr[0] == 0 ? 1 : 0;
            StringBuffer ans = new StringBuffer();
            while (index < m + n) {
                ans.append(ansArr[index]);
                index++;
            }
            return ans.toString();
        }
    }


    @Test
    public void test(){
        Solution solution = new Solution();
        String ans = solution.multiply("123", "456");
        System.out.println(ans);
    }
}
