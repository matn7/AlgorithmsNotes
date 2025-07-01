class Solution(object):
    # O(2^n) time | O(2^n) space
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        par = []

        def dfs(open, close):
            if open < n:
                par.append("(")
                dfs(open + 1, close)
                par.pop()
            if close < open:
                par.append(")")
                dfs(open, close + 1)
                par.pop()
            if open == n and close == n:
                res.append("".join(par))

        dfs(0, 0)

        return res
    
solution = Solution()

print(solution.generateParenthesis(3))