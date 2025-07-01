class Solution(object):
    # O(n * 2^n) time | O(n) space
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        subset = []
        nums.sort()

        def backtrack(i):
            if i == len(nums):
                res.append(subset[::])
                return
            
            subset.append(nums[i])
            backtrack(i + 1)
            subset.pop()
            while i + 1 < len(nums) and nums[i] == nums[i + 1]:
                i += 1
            backtrack(i + 1)

        backtrack(0)

        return res

solution = Solution()
print(solution.subsetsWithDup([1, 2, 2]))    