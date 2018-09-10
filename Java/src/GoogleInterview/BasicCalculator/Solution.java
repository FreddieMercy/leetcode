package GoogleInterview.BasicCalculator;

public class Solution {

    private int stringToInt(StringBuilder SB){
        int ans = 0;

        for(int i = 0; i < SB.length(); ++i){
            ans*=10;
            ans+=SB.charAt(i)-'0';
        }
        return ans;
    }

    private int cal_Helper(int[] i, char[] str){
        int ans = 0;
        StringBuilder value = new StringBuilder();
        char op = '\0';

        while ( i[0] < str.length){
            char c = str[i[0]];

            if(c=='('){

                i[0]++;

                if (op == '-') {
                    ans-=cal_Helper(i, str);
                } else {
                    ans+=cal_Helper(i, str);
                }

                continue;

            }
            else if(c==')'){

                i[0]++;

                break;

            }

            else if(0<=c-'0' && 9 >= c-'0'){
                value.append(c);
            }
            else if(c=='+'||c=='-') {

                //calculate
                if (op == '-') {
                    ans -= stringToInt(value);
                } else {
                    ans += stringToInt(value);
                }

                value = new StringBuilder();

                op = c;
            }


            i[0]++;
        }

        if(op=='-'){
            ans-=stringToInt(value);
        }
        else{
            ans+=stringToInt(value);
        }

        return ans;
    }

    public int calculate(String s) {

        return cal_Helper(new int[]{0}, s.toCharArray());

    }
}