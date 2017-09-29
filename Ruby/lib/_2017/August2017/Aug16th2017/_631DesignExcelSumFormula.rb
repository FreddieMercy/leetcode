# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Excel

=begin
    :type h: Integer
    :type w: Character
=end
    def initialize(h, w)
        @table = {}
        j = 1
        for i in "A".."Z"
            @table[i] = j
            j+=1
        end
        @board = Array.new(h+1, Array.new(@table[w]+1, 0))
    end

=begin
    :type r: Integer
    :type c: Character
    :type v: Integer
    :rtype: Void
=end
    def set(r, c, v)
        @board[r][@table[c]] = v
    end


=begin
    :type r: Integer
    :type c: Character
    :rtype: Integer
=end
    def get(r, c)
        return @board[r][@table[c]]
    end


=begin
    :type r: Integer
    :type c: Character
    :type strs: String[]
    :rtype: Integer
=end
    def sum(r, c, strs)
      i  =strs[0].split(":")
          
      @board[r][@table[c]] = ((i[1]==nil)?@board[i[0][1].to_i][@table[i[0][0]]]:Array.new(i[1][1].to_i-i[0][1].to_i+1).fill{|x| i[0][1].to_i+x}.map{|row| row = ((i[0][0]==i[1][0])?@board[row][@table[i[0][0]]]:@board[row][@table[i[0][0]]..@table[i[1][0]]].sum) }.sum)

    if strs.length > 1
      j = strs[1].split(":")
        
      @board[r][@table[c]] += ((j[1]==nil)?@board[j[0][1].to_i][@table[j[0][0]]]:Array.new(j[1][1].to_i-j[0][1].to_i+1).fill{|x| j[0][1].to_i+x}.map{|row| row = ((j[0][0]==j[1][0])?@board[row][@table[j[0][0]]]:@board[row][@table[j[0][0]]..@table[j[1][0]]].sum) }.sum)
        end
        return @board[r][@table[c]]
    end
end

# Your Excel object will be instantiated and called as such:
# obj = Excel.new(h, w)
# obj.set(r, c, v)
# param_2 = obj.get(r, c)
# param_3 = obj.sum(r, c, strs)

