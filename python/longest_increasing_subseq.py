class Solution(object):
    # O(n^2) time | O(n) space
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = [1] * len(nums)
        maxSeq = 0
        for i in range(len(nums)):
            for j in range(i, len(nums)):
                if nums[j] > nums[i]:
                    dp[j] = max(dp[j], 1 + dp[i])
            maxSeq = max(maxSeq, dp[i])
        return maxSeq
    

solution = Solution()
nums = [10,9,2,5,3,7,101,18]
print(solution.lengthOfLIS(nums))
