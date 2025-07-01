class Solution(object):
    # O(n * 2^n) time | O(n) space
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        oneRes = []

        candidates.sort()

        def backtrack(i, sum):
            if sum == target:
                res.append(oneRes[::])
                return
            if i >= len(candidates) or sum > target:
                return
            oneRes.append(candidates[i])
            backtrack(i + 1, sum + candidates[i])
            oneRes.pop()
            while i + 1 < len(candidates) and candidates[i] == candidates[i + 1]:
                i += 1
            backtrack(i + 1, sum)
            pass

        backtrack(0, 0)

        return res
    
solution = Solution()
print(solution.combinationSum2([10,1,2,7,6,1,5], 8))    