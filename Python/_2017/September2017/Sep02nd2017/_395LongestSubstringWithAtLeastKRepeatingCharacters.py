import collections
class Solution(object):
    def longestSubstring(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        for key, value in collections.Counter(s).items():
            if value<k:
                return max(self.longestSubstring(t, k) for t in s.split(key))
        return len(s)