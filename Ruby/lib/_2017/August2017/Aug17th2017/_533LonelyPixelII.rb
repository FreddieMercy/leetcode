# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {Character[][]} picture
# @param {Integer} n
# @return {Integer}

#Solution in Java... Knocked. Too hard TT
def find_black_pixel(picture, n)

  row = Array.new(picture.length, 0)
  col = Array.new(picture[0].length,0)
  for i in 0..picture.length-1
    for j in 0..picture[0].length-1
      if picture[i][j] == "B"
        row[i]+=1
        col[j]+=1
      end
    end
  end

  ans = {}
  d = {}
  for i in 0..row.length-1
    for j in 0..col.length-1
        if picture[i][j]=="B"
            if row[i] == n and col[j] ==n
              if not d.key?(j)
                 d[j] = i 
              end
              if d[j] >=0
                  if picture[i] == picture[d[j]]
                      if not ans.key?(d[j])
                         ans[d[j]] = 0 
                      end
                      ans[d[j]]+=1
                  else
                      ans.delete(d[j])
                      d[j] = -1
                  end
              end

            end
            
              if d.key?(j) and d[j]>=0
                  if picture[i] != picture[d[j]]
                      ans.delete(d[j])
                      d[j] = -1
                  end
              end
            
        end
    end
  end

  a = 0
  for i in ans.keys
     a += ans[i] 
  end
    puts ans
  return a
end


