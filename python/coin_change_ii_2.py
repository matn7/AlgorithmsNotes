class Solution(object):
    # O(n * m) time | O(n * m) space
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        coins.sort()
        dp = [ [0] * (amount + 1) for _ in range(len(coins) + 1) ]

        for r in range(len(dp)):
            dp[r][0] = 1

        for i in range(len(coins) - 1, -1, -1):
            for a in range(amount + 1):
                if a >= coins[i]:
                    dp[i][a] = dp[i + 1][a]
                    dp[i][a] += dp[i][a - coins[i]]
        
        return dp[0][amount]

solution = Solution()
print(solution.change(5, [1, 2, 5]))

