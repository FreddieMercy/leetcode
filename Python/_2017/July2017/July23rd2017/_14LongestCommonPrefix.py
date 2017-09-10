class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        length = len(strs)
        if not length:
            return ""
        longest = len(strs[0])
        for s in strs:
            while s[:longest] != strs[0][:longest]:
                longest-=1
        return strs[0][:longest]