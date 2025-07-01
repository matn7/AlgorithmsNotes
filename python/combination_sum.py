class Solution(object):
    # O(n * 2^n) time | O(n) space
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        oneRes = []

        def backtrack(i, sum):
            if i >= len(candidates) or sum > target:
                return
            if sum == target:
                res.append(oneRes[::])
                return
            oneRes.append(candidates[i])
            backtrack(i, sum + candidates[i])
            oneRes.pop()
            backtrack(i + 1, sum)

        backtrack(0, 0)

        return res
    
solution = Solution()
print(solution.combinationSum([2, 3, 6, 7], 7))    