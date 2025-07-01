class Solution(object):
    # O(n) time | O(n) space
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        res = []
        digits[len(digits) - 1] += 1

        carry = 0
        for i in range(len(digits) - 1, -1, -1):
            digit = digits[i]
            sum = digit + carry
            res.append(sum % 10)
            carry = sum // 10
        if carry > 0:
            res.append(carry)
        
        res.reverse()
        return res

solution = Solution()
print(solution.plusOne([9, 9, 9, 9]))
