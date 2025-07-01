class Solution(object):
    # O(n * m) time | O(n * m) space
    def findTargetSumWays(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        dp = {}

        def dfs(i, sum):
            if i == len(nums):
                return 1 if sum == target else 0
            key = str(i) + ":" + str(sum)
            if key in dp:
                return dp[key]
            
            res = dfs(i + 1, sum + nums[i]) + dfs(i + 1, sum - nums[i])
            dp[key] = res
            return res

        return dfs(0, 0)


solution = Solution()
nums = [1,1,1,1,1]
target = 3
print(solution.findTargetSumWays(nums, target))
