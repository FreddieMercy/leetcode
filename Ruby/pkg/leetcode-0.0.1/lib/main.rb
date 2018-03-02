# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
load './_2017/August2017/Aug14th2017/_254FactorCombinations.rb'
=begin
for x in 0..0
  puts x
  puts
end
puts "end"

=end
  
def threeTrakAndFiveStar()
  for i in 1..100
    
    isPrinted = false
    
    if i%3 == 0
      isPrinted = true
      print "Trak"
    end

    if i%5 == 0
      isPrinted = true
      print "Star"
    end

    if not isPrinted
      print i
    end
    
    print " "
      
  end
  
end

def isAnagram(first, second)
  return first.chars.sort.join == second.chars.sort.join
end

print isAnagram("abc", "cba")