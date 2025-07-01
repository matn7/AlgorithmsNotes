class Solution(object):
    # O(n * 2^n) time | O(n) space
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        part = []
        candidates.sort()

        def dfs(i, sum):
            if sum == target:
                res.append(part[::])
                return
            if sum > target or i >= len(candidates):
                return
            part.append(candidates[i])
            dfs(i + 1, sum + candidates[i])
            part.pop()
            while i + 1 < len(candidates) and candidates[i + 1] == candidates[i]:
                i += 1
            dfs(i + 1, sum)

        dfs(0, 0)
        return res


candidates = [10,1,2,7,6,1,5]
target = 8

solution = Solution()
print(solution.combinationSum2(candidates, target))
