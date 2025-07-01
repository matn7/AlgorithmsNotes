class Solution(object):
    # O(n * m) time | O(n * m) space
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        coins.sort()
        memo = [ [-1] * (amount + 1) for _ in range(len(coins) + 1) ]

        def dfs(i, a):
            if a == 0:
                return 1
            
            if i >= len(coins):
                return 0
            
            if memo[i][a] != -1:
                return memo[i][a]

            res = 0
            if a >= coins[i]:
                res = dfs(i + 1, a)
                res += dfs(i, a - coins[i])
            memo[i][a] = res
            return res 

        return dfs(0, amount)


solution = Solution()
print(solution.change(5, [1, 2, 5]))
