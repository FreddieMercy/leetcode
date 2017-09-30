# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# @param {Character[][]} picture
# @return {Integer}
def find_lonely_pixel(picture)
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
  
  ans = 0
  
  for i in 0..row.length-1
    for j in 0..col.length-1
      if row[i]==1 and col[j] == 1 and picture[i][j]=="B"
        ans+=1
      end
    end
  end
  
  return ans
end
