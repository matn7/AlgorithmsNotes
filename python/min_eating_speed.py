import math

class Solution(object):
    # O(log(n)) time | O(1) space
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        R = max(piles)

        minSpeed = R
        L = 1

        while L <= R:
            currSpeed = (L + R) // 2
            time = 0

            for pile in piles:
                time += math.ceil(float(pile) / currSpeed)

            if time <= h:
                minSpeed = min(minSpeed, currSpeed)
                R = currSpeed - 1
            else:
                L = currSpeed + 1

        return minSpeed
    

solution = Solution()


print(solution.minEatingSpeed([3,6,7,11], 8))

print(solution.minEatingSpeed([30,11,23,4,20], 5))

print(solution.minEatingSpeed([30,11,23,4,20], 6))
