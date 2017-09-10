class Solution(object):
    def searchRange(self, num, target):

        finish = len(num)-1
        left = [-1]
        right = [-1]

        def bs(start = 0, end = finish):

            if start > end or start < 0 or end > finish or num[start] > target or num[end] < target:
                return

            length= (end-start)//2
            if num[start+length] == target:
                if left[0] == -1 or length+start < left[0]:
                    left[0] = start+length
                if start+length > right[0]:
                    right[0] = start+length
                bs(start, start+length-1)
                bs(start+length+1, end)

                return

            if num[start+length] > target:
                bs(start, start+length-1)
            else:
                bs(start+length+1, end)


        bs()

        return [left[0], right[0]]