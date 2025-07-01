class Solution(object):
    # O(n * m) time | O(n * m) space
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        if len(s) < len(t):
            return 0
        
        dp = [ [-1] * (len(s) + 1) for _ in range(len(t) + 1) ]

        def dfs(i, j):
            if j == len(t):
                return 1
            
            if i == len(s):
                return 0
            
            if dp[i][j] != -1:
                return dp[i][j]
            
            res = 0
            if s[i] == t[j]:
                res += dfs(i + 1, j + 1)
                res += dfs(i + 1, j)
            else:
                res += dfs(i + 1, j)
            dp[i][j] = res
            return res

        return dfs(0, 0)
    
solution = Solution()
s = "rabbbit"
t = "rabbit"
print(solution.numDistinct(s, t))