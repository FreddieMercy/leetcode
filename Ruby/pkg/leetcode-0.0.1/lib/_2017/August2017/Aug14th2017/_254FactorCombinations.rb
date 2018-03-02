# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {Integer} n
# @return {Integer[][]}
def get_factors(n)
    upper = n
    lower = 2
    ans = []
    
    while lower < upper
      if n % lower == 0
        upper = n / lower
        ans.push([lower,upper])
        for x in get_factors(upper)
          if x[0] >=lower
            ans.push [lower]+x
          end
        end
      end
      lower += 1
    end

    return ans
end
