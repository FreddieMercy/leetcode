# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def swapPairs(self, head):
        self.next = head
        ret = self
        while self.next != None and self.next.next != None:
            tmp1 = self.next
            tmp2 = self.next.next
            tmp1.next = tmp2.next
            tmp2.next = tmp1
            self.next = tmp2
            self = self.next.next
            
        return ret.next