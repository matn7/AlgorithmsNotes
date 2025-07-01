class Solution(object):
    # O(n^2) time | O(n^2) space
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        cache = {}

        def backtrack(i, open):
            if open < 0:
                return False
            if i == len(s):
                return open == 0
            if (i, open) in cache:
                return cache.get((i, open))
            
            c = s[i]
            res = False
            if c == '*':
                res = backtrack(i + 1, open + 1) or backtrack(i + 1, open) or backtrack(i + 1, open - 1)
            elif c == '(':
                res = backtrack(i + 1, open + 1)
            elif c == ')':
                res = backtrack(i + 1, open - 1)
            
            cache[(i, open)] = res
            return res

        return backtrack(0, 0)
        

solution = Solution()
print(solution.checkValidString("(*))"))
