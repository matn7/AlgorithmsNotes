class Solution(object):
    # O(n^2) time | O(n) space
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []

        for i in range(len(nums)):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            num1 = nums[i]
            j = i + 1
            k = len(nums) - 1
            while j < k:
                num2 = nums[j]
                num3 = nums[k]
                sum = num1 + num2 + num3
                if sum == 0:
                    res.append([num1, num2, num3])
                    j += 1
                    k -= 1
                    while j < k and nums[j] == nums[j - 1]:
                        j += 1
                elif sum > 0:
                    k -= 1
                else:
                    j += 1
        return res
    
solution = Solution()
nums = [-1,0,1,2,-1,-4]
print(solution.threeSum(nums))