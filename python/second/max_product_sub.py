class Solution(object):
    # O(n) time | O(1) space
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        globalMax = nums[0]
        currMax = 1
        currMin = 1

        for num in nums:
            temp = num * currMax
            currMax = max(num, num * currMax, num * currMin)
            currMin = min(num, temp, num * currMin)
            globalMax = max(globalMax, currMax)
        
        return globalMax
    
nums = [2,3,-2,4]

solution = Solution()
print(solution.maxProduct(nums))

