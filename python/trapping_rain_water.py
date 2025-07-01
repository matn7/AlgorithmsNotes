class Solution(object):
    # O(n) time | O(n) space
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        water = [0] * len(height)
        maxLeft = height[0]

        for i, h in enumerate(height):
            water[i] = maxLeft
            maxLeft = max(maxLeft, h)
        
        maxRight = height[-1]
        sum = 0
        for i in range(len(height) - 1, -1, -1):
            h = min(water[i], maxRight) - height[i]
            water[i] = max(h, 0)
            maxRight = max(maxRight, height[i])
            sum = sum + water[i]
        return sum

solution = Solution()

print(solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
