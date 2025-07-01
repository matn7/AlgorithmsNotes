class Solution(object):
    # O(n) time | O(1) space
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        idx = 0
        pos = 0

        while idx < len(nums):
            curr = nums[idx]
            count = 0
            while idx < len(nums) and nums[idx] == curr:
                idx += 1
                count += 1
            
            nextPos = min(pos + 2, pos + count)
            for i in range(pos, nextPos):
                nums[i] = curr
            pos = nextPos
        return pos

solution = Solution()
nums = [0,0,1,1,1,1,2,3,3]
print(solution.removeDuplicates(nums))
