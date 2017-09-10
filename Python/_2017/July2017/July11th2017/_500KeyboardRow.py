class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        keyboard = ["QWERTYUIOPqwertyuiop","ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"]
        ans = []
        target = ""
        index = 0

        for x in words:
            for y in keyboard:
                for index in range(0, len(x)+1):
                    if index <= len(x) - 1:
                        z = x[index]
                   
                        if target =="":
                            if z in y:
                                target = y
                            else:
                                target=""
                                break
                        else:
                            if z not in target:
                                target=""
                                break
                    else:
                        target=""

                if index == len(x):
                    ans.append(x)
                    break
        return ans

x = Solution()
print(x.findWords(["asdfghjkl","qwertyuiop","zxcvbnm"]))
