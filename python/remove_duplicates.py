class Solution(object):
    # O(n) time | O(1) space
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0
        j = 0

        while j < len(nums):
            nums[i] = nums[j]
            while j < len(nums) and nums[i] == nums[j]:
                j += 1
            i += 1
        return i