class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        tel = {"0":" ", "1":"", "2":"abc", "3":"def", "4":"ghi", "5":"jkl", "6":"mno","7":"pqrs", "8":"tuv", "9":"wxyz"}
        ret=[]
        if len(digits):
            for d in tel[digits[0]]:
                tmp = self.letterCombinations(digits[1:])
                if not len(tmp):
                    ret.append(d)
                else:
                    for e in tmp:
                        ret.append(d+e)
        return ret