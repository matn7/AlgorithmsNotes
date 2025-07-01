class Solution(object):
    # O(n) time | O(n) space
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        maxArea = 0
        stack = []

        for i, h in enumerate(heights):
            idx = i
            while len(stack) != 0 and stack[-1][1] > h:
                curr = stack.pop()
                currArea = (i - curr[0]) * curr[1]
                idx = curr[0]
                maxArea = max(maxArea, currArea)
            stack.append((idx, h))
        
        while len(stack) != 0:
            curr = stack.pop()
            currArea = (len(heights) - curr[0]) * curr[1]
            maxArea = max(maxArea, currArea)
        
        return maxArea

solution = Solution()
print(solution.largestRectangleArea([2,1,5,6,2,3]))
            
