class Solution(object):
    # O(log(n)) time | O(log(n)) space
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n == 0:
            return 1
        
        def helper(a, b):
            if b == 1:
                return a
            half = helper(a, b // 2)
            return half * half if b % 2 == 0 else a * half * half

        return helper(x, n) if n > 0 else 1 / helper(x, -1 * n)

solution = Solution()
print(solution.myPow(2.0, 10))