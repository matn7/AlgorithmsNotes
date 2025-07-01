class Solution(object):
    # O(n) time | O(1) space
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        buy = prices[0]
        maxProfit = 0

        for i, price in enumerate(prices):
            profit = price - buy
            maxProfit = max(maxProfit, profit)
            buy = min(buy, price)

        return maxProfit
    
solution = Solution()
print(solution.maxProfit([7, 1, 5, 3, 6, 4]))