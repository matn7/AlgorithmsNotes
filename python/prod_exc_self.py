class Solution:
    # O(n) time | O(n) space
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [1] * len(nums)
        prod = 1

        for i in range(len(nums)):
            res[i] = prod
            prod = prod * nums[i]
        
        prod = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] = res[i] * prod
            prod = prod * nums[i]
        
        return res
    
solution = Solution()

print(solution.productExceptSelf([1, 2, 3, 4]))

