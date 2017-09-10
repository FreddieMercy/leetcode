# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1:
            return l2
        if not l2:
            return l1

        first = l1
        second = l2
        retV = None
        if first.val > second.val:
            retV = second
            second = second.next
        else:
            retV = first
            first = first.next
        head = retV
        while first != None and second!=None:
            if first.val > second.val:
                retV.next = second
                second = second.next
            else:
                retV.next = first
                first = first.next
            retV = retV.next

        if first:
            retV.next = first
        elif second:
            retV.next = second

        return head