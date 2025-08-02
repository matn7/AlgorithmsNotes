class Solution(object):
    # O(log(n)) time | O(1) space
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        l = 0
        r = x
        res = 0
        while l <= r:
            m = l + (r - l) // 2
            if m**2 > x:
                r = m - 1
            elif m**2 < x:
                l = m + 1
                res = m
            else:
                return m

        return res