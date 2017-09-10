class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        d = {}
        e={}
        array = str.split(' ')
        if len(pattern) != len(array):
            return False
        for i in range(0, len(pattern)):
            if pattern[i] not in d.keys() and array[i] not in e.keys():
                d[pattern[i]] = array[i]
                e[array[i]] = pattern[i]
            else:
                if (pattern[i] in d.keys() and d[pattern[i]] != array[i]) or (array[i] in e.keys() and e[array[i]] != pattern[i]):
                    return False
        return True

x = Solution()
print(x.wordPattern())