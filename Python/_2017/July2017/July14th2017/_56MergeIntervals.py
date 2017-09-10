# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        ret = []
        for x in sorted(intervals, key = lambda i:i.start):
            if len(ret) > 0 and ret[-1].end >= x.start:
                ret[-1].end = max(x.end, ret[-1].end)
            else:
                ret.append(x)

        return ret