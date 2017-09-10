#I really think my answer is correct
'''
class Solution(object):
    def isValidSudoku(self, board):
        
        r = []*9
        cl = []*9
        rowNum = 0
        colNum = 0
        m = []

        for i in range(9):
            r.append([])
            cl.append([])

        try:
            for j in range(9):
                m = []
                for i in range(9):
                    c = board[j][i]
                    if c == ".":
                        continue
                    row = j//3
                    col = j%3
                    rowNum = row*3+i//3
                    colNum = col*3+i%3
                    if not c in r[rowNum] and not c in m and not c in cl[colNum]:
                        r[rowNum].append(c)
                        cl[colNum].append(c)
                        m.append(c)
                    else:
                        return False  
                
        except:
            return False
        return True

'''
class Solution(object):
    def isValidSudoku(self, board):
        return 1 == max(collections.Counter(
            x
            for i, row in enumerate(board)
            for j, c in enumerate(row)
            if c != '.'
            for x in ((c, i), (j, c), (i/3, j/3, c))
        ).values() + [1])
