/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;




class Solution {

    private void helper(int[][] costs, int house, int color,int soFar, int[] ans) {

        for (int c = 0; c < costs[0].length; ++c) {
            if (c != color) {
                if (house==costs.length-1) {
                    ans[0] = Math.min(ans[0], costs[house][c]+soFar);
                } else {
                    soFar += costs[house][c];
                    helper(costs, house + 1, c, soFar, ans);
                    soFar-=costs[house][c];
                }
            }
        }
    }
    public int minCostII(int[][] costs) {
        // Write your solution here
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        for (int c = 0; c < costs[0].length; ++c)
            if(costs.length!=1)
                helper(costs, 1, c, costs[0][c], ans);
            else
                ans[0] = Math.min(ans[0], costs[0][c]);
        return ans[0];
    }
}


public class Leetcode {
    /**
     * @param args the command line arguments
     */
    // Complete the substrCount function below.
    private static boolean isValid(String s, int left, int right, boolean[][] dp){

        if(left==right){
            dp[left][right] = true;
            return true;
        }
        if(s.charAt(left)==s.charAt(right)){
            int mid = (right-left)/2+left;
            if((right-left)%2==1){//even
                dp[left][right] = (dp[left][mid]&&dp[mid+1][right]);
                return dp[left][right];
            }
            else{
                if(dp[left][mid-1]&&dp[mid+1][right]){
                    dp[left][right] = (s.charAt(mid) == s.charAt(left));
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    static long substrCount(int n, String s) {

        if(s==null||n<0){
            return 0;
        }

        boolean[][] dp = new boolean[n][n];
        long ans = 0;
        for(int len = 0; len<n;++len){
            for(int i = 0; i < n - len;++i){
                if(isValid(s, i, i+len, dp)){
                    ans++;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {


        System.out.println(substrCount(727310,
                "ccacacabccacabaaaabbcbccbabcbbcaccabaababcbcacabcabacbbbccccabcbcabbaaaaabacbcbbbcababaabcbbaaababababbabcaabcaacacbbaccbbabbcbbcbacbacabaaaaccacbaabccabbacabaabaaaabbccbaaaabacabcacbbabbacbcbccbbbaaabaaacaabacccaacbcccaacbbcaabcbbccbccacbbcbcaaabbaababacccbacacbcbcbbccaacbbacbcbaaaacaccbcaaacbbcbbabaaacbaccaccbbabbcccbcbcbcbcabbccbacccbacabcaacbcaccabbacbbccccaabbacccaacbbbacbccbcaaaaaabaacaaabccbbcccaacbacbccaaacaacaaaacbbaaccacbcbaaaccaabcbccacaaccccacaacbcacccbcababcabacaabbcacccbacbbaaaccabbabaaccabbcbbcaabbcabaacabacbcabbaaabccabcacbcbabcbccbabcabbbcbacaaacaabbbabbaacbbacaccccabbabcbcabababbcbaaacbaacbacacbabbcacccbccbbbcbcabcabbbcaabbaccccabaabbcbcccabaacccccaaacbbbcbcacacbabaccccbcbabacaaaabcccaaccacbcbbcccaacccbbcaaaccccaabacabcabbccaababbcabccbcaccccbaaabbbcbabaccacaabcabcbacaccbaccbbaabccbbbccaccabccbabbbccbaabcaabcabcbbabccbaaccabaacbbaaaabcbcabaacacbcaabbaaabaaccacbaacababcbacbaacacccacaacbacbbaacbcbbbabccbababcbcccbccbcacccbababbcacaaaaacbabcabcacaccabaabcaaaacacbcc"));


    }
}