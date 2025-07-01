class Solution(object):
    # O(n * n!) time | O(n * n!) space
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        part = []

        pick = [False] * len(nums)

        def backtrack(i):
            if i == len(nums):
                res.append(part[::])
                return
            if i > len(nums):
                return
            
            for j in range(len(nums)):
                if not pick[j]:
                    pick[j] = True
                    part.append(nums[j])

                    backtrack(i + 1)

                    pick[j] = False
                    part.pop()

        backtrack(0)

        return res


nums = [1,2,3]
solution = Solution()
print(solution.permute(nums))
        