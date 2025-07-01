class Solution(object):
    # O(n) time | O(1) space
    def maxSubarraySumCircular(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        globalMax = nums[0]
        globalMin = nums[0]
        curMax = 0
        curMin = 0
        total = 0

        for num in nums:
            curMax = max(num, curMax + num)
            curMin = min(num, curMin + num)
            total += num
            globalMax = max(globalMax, curMax)
            globalMin = min(globalMin, curMin)

        return max(globalMax, total - globalMin) if globalMax > 0 else globalMax
    

solution = Solution()
print(solution.maxSubarraySumCircular([5,-3,5]))
