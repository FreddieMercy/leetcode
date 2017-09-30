# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class StringIterator

=begin
    :type compressedString: String
=end
    def initialize(compressedString)
        table = ["0","1", "2", "3", "4", "5", "6", "7", "8", "9"]
        @strings = []
        current = ""
        num = ""
        for i in 0..compressedString.length
          if table.include?(compressedString[i])
            num << compressedString[i]
          else
            @strings.push([current, num.to_i])
            num = ""
            current = compressedString[i]
          end
        end
        @strings.shift
        while has_next() and @strings[0][1] == 0
          @strings.shift
        end
        
    end


=begin
    :rtype: Character
=end
    def next()
      if has_next()
        @strings[0][1]-=1
        c = @strings[0][0]
        while has_next() and @strings[0][1] == 0
          @strings.shift
        end
        return c
      end
      return " "
    end


=begin
    :rtype: Boolean
=end
    def has_next()
      return @strings.length > 0  
    end


end

# Your StringIterator object will be instantiated and called as such:
# obj = StringIterator.new(compressedString)
# param_1 = obj.next()
# param_2 = obj.has_next()