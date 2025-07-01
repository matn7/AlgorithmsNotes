class Solution(object):
    # O(log(n)) time | O(log(n)) space
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        visited = set()
        while n != 1:
            sum = 0
            x = n
            while x > 0:
                digit = x % 10
                x = x // 10
                sum += digit * digit

            if sum in visited:
                return False
            
            visited.add(sum)
            n = sum

        return True
    
solution = Solution()
print(solution.isHappy(19))