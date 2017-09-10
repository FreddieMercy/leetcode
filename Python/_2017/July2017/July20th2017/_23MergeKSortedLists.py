# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        total = []
        for x in lists:
            head = x
            while head:
                total.append(head.val)
                head = head.next
        length = len(total)
        if not length:
            return None
        total = sorted(total)
        root = ListNode(total[0])
        retV = root
        for i in range(1, length):
            root.next = ListNode(total[i])
            root = root.next
        return retV