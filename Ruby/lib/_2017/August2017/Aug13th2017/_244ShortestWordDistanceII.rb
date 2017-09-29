# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class WordDistance

=begin
    :type words: String[]
=end
  
    def initialize(words)
      @d = {}
      @M = words.length
        for i in 0..words.length
          if @d.has_key?(words[i])
            @d[words[i]].push i
          else
            @d[words[i]] = [i]
          end
        end
    end


=begin
    :type word1: String
    :type word2: String
    :rtype: Integer
=end
    def shortest(word1, word2)
        ans = @M
        for i in @d[word1]
          for j in @d[word2]
            ans = [ans, (i-j).abs].min
          end
        end
        return ans
    end
end

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance.new(words)
# param_1 = obj.shortest(word1,word2)
