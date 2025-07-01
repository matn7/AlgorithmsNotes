class Solution(object):
    # O(n^2) time | O(n) space
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()

        for i, a in enumerate(nums):
            if a > 0:
                break
            if i > 0 and a == nums[i - 1]:
                continue
                
            l = i + 1
            r = len(nums) - 1

            while l < r:
                b = nums[l]
                c = nums[r]
                sum = a + b + c
                if sum > 0:
                    r = r - 1
                elif sum < 0:
                    l = l + 1
                else:
                    res.append([a, b, c])
                    l += 1
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r:
                        l = l + 1
        
        return res
    
solution = Solution()

nums = [-1,0,1,2,-1,-4]
print(solution.threeSum(nums))
