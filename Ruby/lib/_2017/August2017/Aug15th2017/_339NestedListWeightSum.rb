# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
#
#class NestedInteger
#    def is_integer()
#        """
#        Return true if this NestedInteger holds a single integer, rather than a nested list.
#        @return {Boolean}
#        """
#
#    def get_integer()
#        """
#        Return the single integer that this NestedInteger holds, if it holds a single integer
#        Return nil if this NestedInteger holds a nested list
#        @return {Integer}
#        """
#
#    def get_list()
#        """
#        Return the nested list that this NestedInteger holds, if it holds a nested list
#        Return nil if this NestedInteger holds a single integer
#        @return {NestedInteger[]}
#        """

# @param {NestedInteger[]} nested_list
# @return {Integer}
def depth_sum(nested_list)
  def sth(n, depth=1)
    ans = 0
    for x in n
      if x.is_integer()
        ans+=x.get_integer()*depth
      else
        ans += sth(x.get_list(), depth+1)
      end
    end
    return ans
  end
  
  return sth(nested_list)
end