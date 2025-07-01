class Solution(object):
    # O(n * t) time | O(t) space
    # t - sum of array elements divided by 2
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        sumElem = sum(nums)

        if sumElem % 2 != 0:
            return False
        
        target = sumElem / 2
        dp = set()
        dp.add(0)

        for num in nums:
            newDp = set()
            for t in dp:
                if t + num == target:
                    return True
                newDp.add(t + num)
                newDp.add(t)
            dp = newDp
        return False
    
solution = Solution()
print(solution.canPartition([1,5,11,5]))

