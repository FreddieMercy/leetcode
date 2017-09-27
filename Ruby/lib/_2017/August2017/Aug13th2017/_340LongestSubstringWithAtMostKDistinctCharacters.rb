# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {String} s
# @param {Integer} k
# @return {Integer}
def length_of_longest_substring_k_distinct(s, k)
    l = 0
    c = {}
    for i in 0...s.length-1
      
      if c.length < k or not c.has_key?(s[i])
        
        c[s[i]] = i
        l+=1
      else
        
      end
    
    end
    
  
    return l
end