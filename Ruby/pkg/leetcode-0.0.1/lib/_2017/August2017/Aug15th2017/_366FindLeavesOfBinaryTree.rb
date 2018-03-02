# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer[][]}
def find_leaves(root)
    if root == nil
      return []
    end
    if root.left == nil and root.right == nil
      return [[root.val]]
    end
    l = find_leaves(root.left)
    r = find_leaves(root.right)
    ans = []
    for i in 0..[l.length, r.length].max-1
        a = []
        b = []
        if i < l.length
            a = l[i]
        end
        if i < r.length
            b = r[i]
        end
        ans.push(a+b)
    end
    return ans+[[root.val]]
end