class Solution(object):
    # O(n) time | O(n) space
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        dp = {}

        def helper(i, buying):
            if i >= len(prices):
                return 0
            
            key = (i, buying)
            if key in dp:
                return dp[key]
            
            if buying:
                buy = helper(i + 1, not buying) - prices[i]
                cooldown = helper(i + 1, buying)
                dp[key] = max(buy, cooldown)
            else:
                sell = helper(i + 2, not buying) + prices[i]
                cooldown = helper(i + 1, buying)
                dp[key] = max(sell, cooldown)
            return dp[key]

        return helper(0, True)
    

prices = [1,2,3,0,2]

solution = Solution()
print(solution.maxProfit(prices))
