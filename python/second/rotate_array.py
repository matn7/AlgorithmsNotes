class Solution(object):
    # O(n) time | O(1) space
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        l = 0
        r = len(nums) - 1
        k = k % len(nums)
        self.swap(nums, l, r)

        l = 0
        r = k - 1
        self.swap(nums, l, r)

        l = k
        r = len(nums) - 1
        self.swap(nums, l, r)
                 

    def swap(self, nums, l, r):
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1   

solution = Solution()
nums = [-1,-100,3,99]
k = 2
solution.rotate(nums, k)
print(nums)