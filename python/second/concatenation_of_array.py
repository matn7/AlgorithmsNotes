class Solution(object):
    # O(n) time | O(n) space
    def getConcatenation(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [0] * 2 * len(nums)

        for i in range(2 * len(nums)):
            res[i] = nums[i % len(nums)]
        return res


solution = Solution()
nums = [1,2,1]
print(solution.getConcatenation(nums))