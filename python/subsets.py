class Solution(object):
    # O(n * 2^n) time | O(n) space
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        subset = []

        def backtrack(i):
            if i >= len(nums):
                res.append(subset[::])
                return
            
            subset.append(nums[i])
            backtrack(i + 1)
            subset.pop()
            backtrack(i + 1)
    
        backtrack(0)
        return res


solution = Solution()
print(solution.subsets([1, 2, 3]))