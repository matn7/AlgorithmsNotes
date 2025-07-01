class Solution(object):
    # O(n) time | O(n) space
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        parenMap = {']': '[', '}': '{', ')' : '('}

        for c in s:
            if c in '[({':
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                opening = stack.pop()
                openingToMatch = parenMap[c]
                if opening != openingToMatch:
                    return False

        return len(stack) == 0
    
solution = Solution()
print(solution.isValid("[{()}]"))