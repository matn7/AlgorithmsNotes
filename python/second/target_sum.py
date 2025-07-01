class Solution(object):
    # O(n) time | O(n) space
    def findTargetSumWays(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        dp = {}

        def dfs(idx, sum):
            if idx == len(nums):
                return 1 if sum == target else 0
            if (idx, sum) in dp:
                return dp[(idx, sum)]
            dp[(idx, sum)] = dfs(idx + 1, sum + nums[idx]) + dfs(idx + 1, sum - nums[idx])
            return dp[(idx, sum)]

        return dfs(0, 0)


solution = Solution()
nums = [1,1,1,1,1]
target = 3
print(solution.findTargetSumWays(nums, target))
