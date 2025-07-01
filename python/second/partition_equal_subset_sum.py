class Solution(object):
    # O(n * t) time | O(n * t) space
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        sums = sum(nums)
        if sums % 2 != 0:
            return False
        
        target = sums // 2
        dp = set()
        dp.add(0)

        for num in nums:
            newDp = set()
            for d in dp:
                t = num + d
                if t == target:
                    return True
                newDp.add(d)
                newDp.add(t)
            dp = newDp
        
        return False

solution = Solution()
nums = [1,5,11,5]
print(solution.canPartition(nums))
