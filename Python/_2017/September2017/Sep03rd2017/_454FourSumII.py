from collections import Counter

class Solution(object):
    def fourSumCount(self, A, B, C, D):
        AB = Counter(a + b for a in A for b in B)
        return sum(AB[-c - d] for c in C for d in D)
'''
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        a = Counter(A)
        b = Counter(B)
        c = Counter(C)
        d = Counter(D)

        def NewSum(k):
            ans = 0
            for j in k:
                ans+=j
            return ans

        def helper(X, Y, Z, M):
            ans = []
            for x in X:
                for y in Y:
                    for z in Z:
                        m = 0-(x+y+z)
                        if m in M:
                            ans.append((x, y, z, m))
            return ans

        return NewSum([a[t[0]]*b[t[1]]*c[t[2]]*d[t[3]] for t in helper(sorted(set(A)), sorted(set(B)), sorted(set(C)), sorted(set(D)))])          #lambda (x, y, z, -sum(x, y, z)) : if -sum(x, y, z) in sortedSetD (x, y, z) for z in sorted(set(C)) for y in sorted(set(B)) for x in sorted(set(A))       ]])
'''