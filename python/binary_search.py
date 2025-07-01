class Solution(object):
    # O(log(n)) time | O(1) space
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = 0
        r = len(nums) - 1

        while l <= r:
            m = l + (r - l) // 2

            if target == nums[m]:
                return m
            elif target > nums[m]:
                l = m + 1
            else:
                r = m - 1
        
        return -1
    
solution = Solution()
print(solution.search([-1,0,3,5,9,12], 9))