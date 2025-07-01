class Solution(object):
    # O(n) time | O(n) space
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        nums1 = nums[0:len(nums) - 1]
        nums2 = nums[1:len(nums)]

        return max(self.robHelper(nums1), self.robHelper(nums2))
    
    def robHelper(self, nums):
        if len(nums) == 1:
            return nums[0]
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        return dp[-1]

solution = Solution()
nums = [1,2,3,1]
print(solution.rob(nums))
