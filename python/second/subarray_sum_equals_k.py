from collections import defaultdict
class Solution(object):
    # O(n) time | O(n) space
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        curSum = 0
        res = 0
        freqMap = defaultdict(int)
        freqMap[0] = 1

        for num in nums:
            curSum += num
            diff = curSum - k
            res += freqMap[diff]
            freqMap[curSum] += 1
        return res


nums = [1,2,3]
k = 3

solution = Solution()
print(solution.subarraySum(nums, k))
