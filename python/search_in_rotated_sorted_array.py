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
            if nums[m] == target:
                return m
            if nums[l] <= nums[m]:
                # left sorted
                if target >= nums[l] and target < nums[m]:
                    # regular BS
                    r = m - 1
                else:
                    l = m + 1
            else:
                # right sorted
                if target > nums[m] and target <= nums[r]:
                    # regular BS
                    l = m + 1
                else:
                    r = m - 1

        return -1
    
solution = Solution()
print(solution.search([4,5,6,7,0,1,2], 4))