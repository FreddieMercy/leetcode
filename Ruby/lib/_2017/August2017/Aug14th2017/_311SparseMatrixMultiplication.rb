# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {Integer[][]} a
# @param {Integer[][]} b
# @return {Integer[][]}
def multiply(a, b)
    return a.map { |row| row = (row.sum==0)?Array.new(a[0].length, 0): b.transpose.map { |col|  col = (col.sum==0)?0:[row, col].transpose.map {|x| x.reduce(:*)}.sum    }  }
end





