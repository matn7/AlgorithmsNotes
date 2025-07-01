class Solution(object):
    # O(n * n!) time | O(n * n!) space
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        oneRes = []
        pick = [False] * len(nums)
        def backtrack():
            if len(oneRes) == len(nums):
                res.append(oneRes[::])
                return
            
            for i in range(len(nums)):
                if not pick[i]:
                    pick[i] = True
                    oneRes.append(nums[i])
                    backtrack()
                    oneRes.pop()
                    pick[i] = False

        backtrack()

        return res
    
solution = Solution()
print(solution.permute([1, 2, 3]))    