class Solution(object):
    # O(n * m * t) time | O(n) space
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        dp = [False] * (len(s) + 1)
        dp[-1] = True

        for i in range(len(s) - 1, -1, -1):
            for w in wordDict:
                if i + len(w) <= len(s):
                    word = s[i : i + len(w)]
                    if word == w:
                        dp[i] = dp[i + len(w)]
                if dp[i]:
                    break

        return dp[0]

solution = Solution()
s = "applepenapple"
wordDict = ["apple","pen"]
print(solution.wordBreak(s, wordDict))