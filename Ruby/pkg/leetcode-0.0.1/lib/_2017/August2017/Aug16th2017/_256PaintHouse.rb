# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {Integer[][]} costs
# @return {Integer}
def min_cost(costs)
  costs.reduce([0]*3) { |prev, now| now.map { |n| n + prev.rotate![0,2].min } }.min
end