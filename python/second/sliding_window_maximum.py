class Solution(object):
    # O(n) time | O(n) space
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        queue = []
        res = []

        for i in range(len(nums)):
            num = nums[i]

            if len(queue) > 0 and i - k == queue[0][1]:
                queue.pop(0) # remove fromt

            while len(queue) > 0 and queue[-1][0] < num:
                queue.pop() # remove back
            
            queue.append([num, i]) # add back
            if i >= k - 1:
                res.append(queue[0][0])
        
        return res

solution = Solution()
nums = [1,3,-1,-3,5,3,6,7]
k = 3
# nums = [1,3,1,2,0,5]
# k = 3
print(solution.maxSlidingWindow(nums, k))

