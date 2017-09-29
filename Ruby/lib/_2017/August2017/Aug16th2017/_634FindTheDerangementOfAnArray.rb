# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {Integer} n
# @return {Integer}
def find_derangement(n)
      mul = 1
      sum = 0
      m = 1000000007
      i = n
        while i >=0
            sum = (sum + m + mul * (i % 2 == 0 ? 1 : -1)) % m
            mul = (mul * i) % m
            i-=1
        end
        
        return sum
end

