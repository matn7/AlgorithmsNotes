class Solution(object):
    # O(n) time | O(1) space
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        for num in nums:
            res ^= num
        return res

nums = [4,1,2,1,2]
solution = Solution()
print(solution.singleNumber(nums))