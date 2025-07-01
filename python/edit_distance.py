class Solution(object):
    # O(n * m) time | O(n * m) space
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        dp = [ [ 0 ] * (len(word1) + 1) for _ in range(len(word2) + 1) ]

        for r in range(len(dp)):
            dp[r][0] = r
        for c in range(len(dp[0])):
            dp[0][c] = c

        for r in range(1, len(dp)):
            for c in range(1, len(dp[r])):
                if word2[r - 1] == word1[c - 1]:
                    dp[r][c] = dp[r - 1][c - 1]
                else:
                    dp[r][c] = 1 + min(dp[r - 1][c], dp[r][c - 1], dp[r - 1][c - 1])

        return dp[-1][-1]


solution = Solution()

word1 = "horse"
word2 = "ros"

print(solution.minDistance(word1, word2))