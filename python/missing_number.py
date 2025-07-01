class Solution(object):
    # O(n) time | O(1) space
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = len(nums)

        for i in range(len(nums)):
            res += i - nums[i]
        return res


solution = Solution()
print(solution.missingNumber([9,6,4,2,3,5,7,0,1]))