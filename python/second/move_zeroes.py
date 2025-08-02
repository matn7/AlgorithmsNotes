class Solution(object):
    # O(n) time | O(1) space
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        posIdx = 0

        for num in nums:
            if num != 0:
                nums[posIdx] = num
                posIdx += 1
        for i in range(posIdx, len(nums)):
            nums[i] = 0


solution = Solution()
nums = [0,1,0,3,12]
solution.moveZeroes(nums)

print(nums)
