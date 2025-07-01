class Solution(object):
    # O(n) time | O(n) space
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        parensMap = {']': '[', '}': '{', ')': '('}

        openingStack = []

        for i,c in enumerate(s):
            if c in "([{":
                openingStack.append(c)
            else:
                if len(openingStack) == 0:
                    return False
                value = openingStack.pop()
                open = parensMap[c]
                if value != open:
                    return False
        return len(openingStack) == 0
    
solution = Solution()
s = "()[]{}"
print(solution.isValid(s))
