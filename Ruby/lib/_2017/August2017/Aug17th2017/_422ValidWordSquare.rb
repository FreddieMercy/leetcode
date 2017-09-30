# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {String[]} words
# @return {Boolean}
def valid_word_square(words)
  w = []
  l = words.length
  
  for i in 0..words.length-1
    tmp = []
    l = [l, words[i].length].max
    for j in 0..words[i].length-1
        tmp.push(words[i][j])  
    end
    w.push(tmp)
  end
    
  for i in 0..w.length-1
    for j in w[i].length..l-1
        w[i].push(nil)
    end
  end
    puts w
  return w==w.transpose
end

# @param {String[]} words
# @return {Boolean}
=begin

def valid_word_square(words)
    (0...words.size).each do |i|
        (0...words[i].size).each do |j|
            return false if j >= words.size || i >= words[j].size || words[i][j] != words[j][i]
        end
    end
    return true
end

=end