class Solution(object):
    # O(n * m) time | O(n * m) space
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        dp = {}

        def dfs(i, j):
            if j == len(p):
                return i == len(s)
            
            if (i, j) in dp:
                return dp[(i, j)]
            
            match = i < len(s) and (s[i] == p[j] or p[j] == '.')
            res = False
            if j + 1 < len(p) and p[j + 1] == '*':
                res = dfs(i, j + 2) or (match and dfs(i + 1, j))
            else:
                res = match and dfs(i + 1, j + 1)
            dp[(i, j)] = res
            return res

        return dfs(0, 0)

solution = Solution()
s = "aab"
p = "c*a*b"
print(solution.isMatch(s, p))

