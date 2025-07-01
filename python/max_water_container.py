class Solution(object):
    # O(n) time | O(1) space
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l = 0
        r = len(height) - 1

        maxArea = 0
        while l < r:
            currArea = min(height[l], height[r]) * (r - l)
            maxArea = max(maxArea, currArea)
            if height[r] > height[l]:
                l = l + 1
            else:
                r = r - 1

        return maxArea

solution = Solution()
print(solution.maxArea([2, 8, 6, 2, 5, 4, 8, 3, 7]))