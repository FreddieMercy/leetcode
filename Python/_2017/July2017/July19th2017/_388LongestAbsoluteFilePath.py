class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        m = {}
        _max = [0]
        def dfs(paths = input):
            path = paths.lstrip("\t")
            length = len(path)
            current = len(paths) - length

            if not length or not "\n" in path: #end
                if "." in path:
                    _max[0] = max(_max[0], m[current - 1]+length if current else length)
                return
                
            index = path.index("\n")+1
            root = path[:index]
            length = len(root)         
            m[current] = m[current - 1]+length if current else length
            
            if "." in root:
                _max[0] = max(_max[0], m[current]-1)
            dfs(path[index:])

        dfs()
        return _max[0]
