import math

class Solution(object):
    # o(1) time | O(1) space
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        MIN = -2147483648
        MAX = 2147483647
        res = 0
        while x != 0:
            digit = int(math.fmod(x, 10))
            x = int(x / 10)

            test = 10 * res + digit
            if test < MIN or test > MAX:
                return 0
            res = test
        return res
    

solution = Solution()
print(solution.reverse(-123))