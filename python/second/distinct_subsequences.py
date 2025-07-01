class Solution(object):
    # O(n * m) time | O(n * m) space
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        dp = {}

        def dfs(i, j):
            if j == len(t):
                return 1
            if i == len(s):
                return 0
            if (i, j) in dp:
                return dp[(i, j)]
            res = 0
            if s[i] == t[j]:
                res += dfs(i + 1, j + 1)
                res += dfs(i + 1, j)
            else:
                res += dfs(i + 1, j)
            dp[(i, j)] = res
            return res

        return dfs(0, 0)

solution = Solution()
s = "rabbbit"
t = "rabbit"
print(solution.numDistinct(s, t))    
