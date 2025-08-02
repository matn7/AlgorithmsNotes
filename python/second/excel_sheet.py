class Solution(object):
    # O(n) time | O(1) space
    def titleToNumber(self, columnTitle):
        """
        :type columnTitle: str
        :rtype: int
        """
        sum = 0
        pow = 1

        for i in range(len(columnTitle) - 1, -1, -1):
            c = ord(columnTitle[i]) - ord("A") + 1

            sum += pow * c
            pow *= 26
        
        return sum

solution = Solution()
print(solution.titleToNumber("ZY"))