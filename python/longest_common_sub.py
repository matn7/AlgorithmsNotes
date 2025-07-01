class Solution(object):
    # O(n * m) time | O(n * m) space
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        n = len(text1)
        m = len(text2)
        dp = [[0] * (m + 1) for _ in range(n + 1)]

        print(dp)

        for r in range(1, n + 1):
            for c in range(1, m + 1):
                if text1[r - 1] == text2[c - 1]:
                    dp[r][c] = 1 + dp[r - 1][c - 1]
                else:
                    dp[r][c] = max(dp[r - 1][c], dp[r][c - 1])
        
        return dp[-1][-1]

solution = Solution()
text1 = "abcde"
text2 = "ace" 
print(solution.longestCommonSubsequence(text1, text2))
