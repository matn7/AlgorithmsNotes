import math
class Solution(object):
    # O(sqrt(n)) time | O(1) space
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        i = 0
        j = math.sqrt(c)

        while i <= j:
            sum = i * i + j * j
            if sum == c:
                return True
            elif sum > c:
                j -= 1
            else:
                i += 1
        return False