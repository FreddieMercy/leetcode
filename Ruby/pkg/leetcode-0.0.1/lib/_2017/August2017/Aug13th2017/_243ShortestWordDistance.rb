# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {String[]} words
# @param {String} word1
# @param {String} word2
# @return {Integer}
def shortest_distance(words, word1, word2)
  ans = words.length
  w1 = -1
  w2 = -1
  for x in 0..words.length
    if words[x] == word1
      w1 = x
    elsif words[x] == word2
      w2 = x
    end
    if w1 >=0 and w2 >=0
      ans = [ans, (w1-w2).abs].min
    end
  end
  return ans
end
