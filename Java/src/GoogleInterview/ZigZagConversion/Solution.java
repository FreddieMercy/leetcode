package GoogleInterview.ZigZagConversion;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 0){
            return "";
        }

        if(s==null|| numRows == 1 || s.length() == 0 || s.length()<numRows){
            return s;
        }

        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans= new StringBuilder();
        for(int i = 1; i <= numRows; ++i){
            int start = i-1;
            int span1 = (numRows-i)*2;
            int span2=start*2;

            ans.append(sb.charAt(start));


            while(start <sb.length()){
                if(span1>0) {
                    start += span1;
                    if(start<sb.length())
                        ans.append(sb.charAt(start));
                }

                if(span2>0){
                    start += span2;
                    if(start<sb.length())
                        ans.append(sb.charAt(start));
                }

            }

        }

        return ans.toString();
    }
}