class Solution(object):
    # O(n) time | O(1) space
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i = 0
        j = len(nums) - 1

        while i <= j:
            while i <= j and nums[i] != val:
                i += 1
            while i <= j and nums[j] == val:
                j -= 1
            if i > j:
                break
            nums[i], nums[j] = nums[j], nums[i]
        return i

solution = Solution()
nums = [0,1,2,2,3,0,4,2]
print(solution.removeElement(nums, 2))