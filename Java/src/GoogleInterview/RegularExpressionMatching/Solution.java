package GoogleInterview.RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {

        char[] string = s.toCharArray();

        //Assume: *abc is not allowed

        char[] pattern = p.toCharArray();
        boolean[][] dp = new boolean[string.length + 1][pattern.length + 1];

        dp[0][0] = true;
        for (int j = 0; j < pattern.length; ++j) {
            if (pattern[j] == '*') {
                dp[0][j + 1] = dp[0][j] || dp[0][j - 1];
            }
        }
        for (int i = 0; i < string.length; ++i) {
            for (int j = 0; j < pattern.length; ++j) {
                if (pattern[j] == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pattern[j] == '*') {
                    dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i + 1][j - 1]) || ((pattern[j - 1] == string[i] || pattern[j - 1] == '.') && dp[i][j + 1]);
                } else {
                    dp[i + 1][j + 1] = dp[i][j] && pattern[j] == string[i];
                }
            }
        }

        return dp[string.length][pattern.length];
    }
}