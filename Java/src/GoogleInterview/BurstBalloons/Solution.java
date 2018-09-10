package GoogleInterview.BurstBalloons;

class Solution {
    private int helper(int i, int j, int[] balloons, int[][] dp){
        int v = dp[i][j];
        for(int k = i+1; k <j; ++k)
            v = Math.max(v, balloons[i]*balloons[k]*balloons[j] + dp[i][k]+dp[k][j]);

        return v;
    }
    public int maxCoins(int[] nums) {

        int tmp = nums.length;
        if(tmp==0)
            return 0;

        int[] balloons= new int[tmp+2];
        balloons[0] = 1;
        int length = 1;

        for(int i = 0; i < tmp;++i)
            if(nums[i]>0)
                balloons[length++]=nums[i];

        balloons[length++]=1;

        int[][] dp = new int[length][length];

        for(int j = 2;  j< length; ++j)
            for(int i =j-2; i >=0;--i)
                dp[i][j] = helper(i,j,balloons,dp);


        return dp[0][length-1];

    }
}