class Solution(object):
    # O(1) time | O(1) space
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        while b != 0:
            carry = (a & b) << 1
            a = (a ^ b)
            b = carry
        return a
    
solution = Solution()
a = 1
b = 2
print(solution.getSum(a, b))