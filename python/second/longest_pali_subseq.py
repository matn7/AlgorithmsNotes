class Solution(object):
    # O(n^2) time | O(n^2) space
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        s2 = s[::-1]
        n = len(s)

        dp = [ [0] * (n + 1) for i in range(n + 1) ]

        print(dp)

        for i in range(1, len(dp)):
            for j in range(1, len(dp[i])):
                if s[i - 1] == s2[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
        return dp[n][n]

solution = Solution()
print(solution.longestPalindromeSubseq("bbbab"))
