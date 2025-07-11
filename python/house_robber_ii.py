class Solution(object):
    # O(n) time | O(n) space
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        n = len(nums)
        return max(self.robHelper(nums[0:n-1]), self.robHelper(nums[1:n]))
        
    def robHelper(self, nums):
        if len(nums) == 1:
            return nums[0]
        
        dp = [0] * len(nums)

        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        
        return dp[-1]


nums = [1, 2, 3, 1]
n = len(nums)
# print(nums[0:n-1])
# print(nums[1:n])

solution = Solution()
print(solution.rob(nums))