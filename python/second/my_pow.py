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
        if x == 1.0:
            return x
        
        return self.helper(x, n) if n > 0 else 1 / self.helper(x, -1 * n)

    def helper(self, x, n):
        if n == 0:
            return 1
        half = self.helper(x, n // 2)
        return half * half if n % 2 == 0 else x * half * half
    

solution = Solution()
# x = 2.00000
# n = 10
x = 2.00000
n = -2
print(solution.myPow(x, n))
