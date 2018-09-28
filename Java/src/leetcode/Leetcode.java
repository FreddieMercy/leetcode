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
    public static void main(String[] args) {

        Solution x= new Solution();

        System.out.println(x.minCostII(new int[][]{{8,9},{8,9},{8,9},{8,9}}));


    }
}