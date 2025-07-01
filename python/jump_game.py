class Solution(object):
    # O(n) time | O(1) space
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        pos = 0
        reach = 0

        while pos < len(nums):
            if pos > reach:
                return False
            reach = max(reach, pos + nums[pos])
            if reach >= len(nums) - 1:
                return True
            pos += 1
        return False

solution = Solution()
print(solution.canJump([2,3,1,1,4]))