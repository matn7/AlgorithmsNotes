class Solution(object):
    # O(n) time | O(n) space
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        kth = len(nums) - k
        self.quickSelect(nums, kth)
        return nums[kth]
    
    def quickSelect(self, nums, kth):
        self.sort(nums, 0, len(nums) - 1, kth)

    def sort(self, nums, start, end, kth):
        if start > end:
            return
        pivot = start
        s = start + 1
        e = end

        while s <= e:
            if nums[s] >= nums[pivot] and nums[e] <= nums[pivot]:
                nums[s], nums[e] = nums[e], nums[s]
            if nums[s] <= nums[pivot]:
                s += 1
            if nums[e] >= nums[pivot]:
                e -= 1
        
        nums[pivot], nums[e] = nums[e], nums[pivot]
        if e == kth:
            return
        
        if (e - 1 - start > end - (e + 1)):
            self.sort(nums, start, e - 1, kth)
            self.sort(nums, e + 1, end, kth)
        else:
            self.sort(nums, e + 1, end, kth)
            self.sort(nums, start, e - 1, kth)

        
nums = [3,2,1,5,6,4]
k = 2        
solution = Solution()
print(solution.findKthLargest(nums, k))        