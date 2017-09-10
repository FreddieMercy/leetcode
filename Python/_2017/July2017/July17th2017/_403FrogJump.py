class Solution(object):
    def canCross(self, stones):
        length = len(stones)-1
        deadEnd = {}
        def dfs(k=0, index=0):
            if index >= length:
                return True    
            if index in deadEnd.keys() and k in deadEnd[index]:
                return False
   
            index1 = index+1
            s = stones[index1:]
            cur = stones[index] + k
            if cur + 1 in s:
                end = s.index(cur+1)
                if dfs(k+1, index1 + end):
                    return True
                elif not end:
                    if not index in deadEnd.keys():
                        deadEnd[index] = [k]
                    else:
                        deadEnd[index].append(k)
                    return False
                else:
                    s = s[:end]
            if cur in s:
                end = s.index(cur)
                if dfs(k, index1 + end):
                    return True
                elif not end:
                    if not index in deadEnd.keys():
                        deadEnd[index] = [k]
                    else:
                        deadEnd[index].append(k)
                    return False
                else:
                    s = s[:end]
            if cur - 1 in s:
                if dfs(k-1, index1 + s.index(cur-1)):
                    return True
            if not index in deadEnd.keys():
                deadEnd[index] = [k]
            else:
                deadEnd[index].append(k)
            return False

        return dfs()