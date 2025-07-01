class Solution(object):
    # O(n * m) time | O(n * m) space
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        dp = {}
        m = len(s)
        n = len(p)

        def dfs(i, j):
            if j == n:
                return i == m
            
            if (i, j) in dp:
                return dp[(i, j)]
            
            match = i < m and (s[i] == p[j] or p[j] == ".")

            if (j + 1) < n and p[j + 1] == "*":
                dp[(i, j)] = dfs(i, j + 2) or (match and dfs(i + 1, j))
            else:
                dp[(i, j)] = match and dfs(i + 1, j + 1)
            return dp[(i, j)]


        return dfs(0, 0)

solution = Solution()
s = "aab"
p = "c*a*b"
print(solution.isMatch(s, p))
