# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {String} s
# @param {Integer} k
# @return {Integer}
def length_of_longest_substring_k_distinct(s, k)
  if k <=0 
    return 0
  end
  if s.length <= k
    return s.length
  end
    ans = 0
    l = 0
    c = {}
    q = []
    for i in 0...s.length
      if q.include?(s[i])
        q.delete(s[i])
      elsif q.length >= k
        
        ans = [ans,l].max
        l = i-c[q.shift]-1
      end
      c[s[i]] = i
      q.push(s[i])
      l+=1
    end
    return [ans,l].max
end