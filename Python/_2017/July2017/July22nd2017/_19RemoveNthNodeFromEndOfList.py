# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def removeNthFromEnd(self, tmp, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        stack = []
        head = tmp
        while head!=None:
            stack.append(head)
            head = head.next

        length = len(stack)
        if not n or length < n:
            return tmp
        if n <length:
            stack[-n-1].next = stack[-n].next
            return tmp

        return stack[-n].next