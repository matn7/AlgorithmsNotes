class Solution(object):
    # O(n * 2^n) time | O(n) space
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        part = []

        def dfs(idx, sum):
            if sum == target:
                res.append(part[::])
                return
            if sum > target or idx >= len(candidates):
                return
            part.append(candidates[idx])
            dfs(idx, sum + candidates[idx])
            part.pop()
            dfs(idx + 1, sum)

        dfs(0, 0)
        return res
    
solution = Solution()
candidates = [2,3,6,7]
target = 7
print(solution.combinationSum(candidates, target))
