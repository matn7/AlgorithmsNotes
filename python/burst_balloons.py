class Solution(object):
    # O(n^3) time | O(n^2) space
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        newNums = [1] * (len(nums) + 2)
        for i in range(len(nums)):
            newNums[i + 1] = nums[i]

        dp = [ [-1] * (len(newNums) + 1) for _ in range(len(newNums) + 1) ]

        def dfs(l, r):
            if l > r:
                return 0
            if dp[l][r] != -1:
                return dp[l][r]
            
            dp[l][r] = 0
            for i in range(l, r + 1):
                coins = newNums[l - 1] * newNums[i] * newNums[r + 1]
                coins += dfs(l, i - 1) + dfs(i + 1, r)
                dp[l][r] = max(dp[l][r], coins)
            return dp[l][r]


        return dfs(1, len(newNums) - 2)

solution = Solution()
print(solution.maxCoins([3,1,5,8]))