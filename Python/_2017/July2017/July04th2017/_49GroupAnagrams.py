class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        mem = {}

        for i in strs:
            tmp = ''.join(sorted(i))
            mem[tmp] = mem.get(tmp, [])+[i]

        return list(mem.values())