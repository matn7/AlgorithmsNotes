class Solution(object):
    # O(n * m) time | O(n * m) space
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        dp[m - 1][n - 1] = 1

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1]
        return dp[0][0]

solution = Solution()
print(solution.uniquePaths(3, 7))