from collections import deque

class Solution(object):
    # O(n) time | O(n) space
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        q = deque()
        l = 0
        r = 0
        res = []

        while r < len(nums):
            while len(q) > 0 and nums[r] > nums[q[-1]]:
                q.pop()
            q.append(r)
            if l > q[0]:
                q.popleft()
            if r + 1 >= k:
                res.append(nums[q[0]])
                l += 1
            r += 1

        return res

solution = Solution()

nums = [1,3,-1,-3,5,3,6,7]
k = 3

print(solution.maxSlidingWindow(nums, k))
