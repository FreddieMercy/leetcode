package GoogleInterview.NQueensII;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private void helper(int r, int n,
                        boolean[] col,
                        int[] ans,
                        Map<Integer, Boolean> left2right,
                        Map<Integer, Boolean> right2left){

        for(int c = 0; c < n; ++c){

            int x1= c-r;
            int x2= r- (n-1-c);

            Boolean oldL = left2right.get(x1);
            Boolean oldR = right2left.get(x2);

            if(oldL == null){
                left2right.put(x1,false);
            }

            if(oldR == null){
                right2left.put(x2,false);
            }

            if(!col[c]&&!left2right.get(x1)&&!right2left.get(x2)){
                if(r==n-1){
                    ans[0]++;
                }
                else{
                    col[c] = true;
                    left2right.put(x1,true);
                    right2left.put(x2,true);
                    helper(r+1, n, col, ans, left2right, right2left);
                    col[c] = false;
                    left2right.put(x1,false);
                    right2left.put(x2,false);
                }
            }
        }

    }

    public int totalNQueens(int n) {
        Map<Integer, Boolean> left2right = new HashMap<>();
        Map<Integer, Boolean> right2left = new HashMap<>();

        boolean[] col = new boolean[n];

        int[] ans = new int[1];

        helper(0, n, col, ans, left2right, right2left);

        return ans[0];

    }
}


