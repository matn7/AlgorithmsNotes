class Solution(object):
    # O(n) time | O(n) space
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if len(heights) == 0:
            return 0
        stack = []
        maxRect = 0
        stack.append([0,0])

        for i in range(1, len(heights)):
            idx = i
            while len(stack) > 0 and heights[stack[-1][1]] >= heights[i]:
                current = stack.pop()
                currRect = (i - current[0]) * heights[current[1]]
                maxRect = max(maxRect, currRect)
                idx = current[0]

            stack.append([idx, i])

        length = len(heights)
        while len(stack) > 0:
            current = stack.pop()
            currRect = (length - current[0]) * heights[current[1]]
            maxRect = max(maxRect, currRect)
        return maxRect
    
solution = Solution()
heights = [2,1,5,6,2,3,1,1,1,1,1,1,1,1]
print(solution.largestRectangleArea(heights))