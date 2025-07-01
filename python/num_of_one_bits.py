class Solution(object):
    # O(1) time | O(1) space
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n > 0:
            if (n & 1) == 1:
                count += 1
            n = n >> 1
        return count
    
solution = Solution()
n = 2147483645
print(solution.hammingWeight(n))    


