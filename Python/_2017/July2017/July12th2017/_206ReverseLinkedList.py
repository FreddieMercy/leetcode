# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        stack = []
        last = None

        if head == None:
            return None

        while head!=None:
            stack.append(head)
            last = head
            head = head.next

        while len(stack)!=1:
            top = stack.pop()
            bot = stack.pop()
            top.next = bot
            stack.append(bot)

        tmp = stack.pop()
        tmp.next=None
        return last