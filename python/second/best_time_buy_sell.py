class Solution(object):
    # O(n) time | O(n) space
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        dp = {}

        def dfs(idx, buying):
            if idx >= len(prices):
                return 0
            if (idx, buying) in dp:
                return dp[(idx, buying)]
            
            if buying:
                buy = dfs(idx + 1, not buying) - prices[idx]
                cooldown = dfs(idx + 1, buying)
                dp[(idx, buying)] = max(buy, cooldown)
            else:
                sell = dfs(idx + 2, not buying) + prices[idx]
                cooldown = dfs(idx + 1, buying)
                dp[(idx, buying)] = max(sell, cooldown)
            return dp[(idx, buying)]

        return dfs(0, True)
    
solution = Solution()
prices = [1,2,3,0,2]
print(solution.maxProfit(prices))