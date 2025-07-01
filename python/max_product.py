class Solution(object):
    # O(n) time | O(1) space
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = nums[0]
        curMin = 1
        curMax = 1

        for num in nums:
            temp = num * curMax
            curMax = max(num, num * curMax, num * curMin)
            curMin = min(num, num * curMin, temp)

            res = max(res, curMax)
        
        return res
    
solution = Solution()
print(solution.maxProduct([2,3,-2,4]))