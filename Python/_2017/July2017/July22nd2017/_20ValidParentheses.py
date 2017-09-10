
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s)%2:
            return False

        stack = []

        for t in s:
            if t == "(" or t=="[" or t=="{":
                stack.append(t)
            else:
                if not len(stack):
                    return False
                if t ==")" and stack[-1] == "(":
                    stack.pop()
                elif t == "]" and stack[-1] == "[":
                    stack.pop()
                elif t == "}" and stack[-1] == "{":
                    stack.pop()
                else:
                    return False

        if not len(stack):
            return True

        return False
        