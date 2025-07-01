class Solution(object):
    # O(n) time | O(1) space
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = nums[0]
        here = 0
        for num in nums:
            here += num
            here = max(here, num) # we must include
            res = max(res, here)
        
        return res
    
solution = Solution()

nums = [-2,1,-3,4,-1,2,1,-5,4]

print(solution.maxSubArray(nums))