class Solution(object):
    # O(n) time | O(n) space
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        dp = {}
        dp[len(s)] = 1

        def backtrack(i):
            if i == len(s):
                return 1
            if s[i] == "0":
                return 0
            if i in dp:
                return dp[i]
            res = backtrack(i + 1)
            if i + 1 < len(s) and (s[i] == "1" or (s[i] == "2" and s[i + 1] in "01234567")):
                res += backtrack(i + 2)
            dp[i] = res
            return res

        return backtrack(0)

solution = Solution()
print(solution.numDecodings("226"))

