# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {Integer} n
# @return {Integer}
def max_a(n)
  dp = [0,1,2,3,4,5,6]

  for i in 7..n
    dp.push([dp[i-4]*3, dp[i-5]*4].max)
  end
  return dp[n]
end

