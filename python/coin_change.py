class Solution(object):
    # O(n * m) time | O(n) space
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [float("infinity")] * (amount + 1)
        dp[0] = 0

        for c in coins:
            for i in range(1, len(dp)):
                if i >= c and dp[i - c] != float("infinity"):
                    dp[i] = min(dp[i], 1 + dp[i - c])
        return dp[-1] if dp[-1] != float("infinity") else -1


solution = Solution()
# print(solution.coinChange([1, 2, 5], 11))
print(solution.coinChange([2], 3))

