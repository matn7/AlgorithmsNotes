class Solution(object):
    # O(n) time | O(n) space
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        start = 0
        countsMap = {}
        res = [0, 0]
        for i, c in enumerate(s):
            if c in countsMap:
                idx = countsMap[c]
                start = max(start, idx + 1)
            countsMap[c] = i
            if i - start > res[1] - res[0]:
                res[0] = start
                res[1] = i
        
        return res[1] - res[0] + 1


solution = Solution()
s = "abcbcbbdefghikkk"
print(solution.lengthOfLongestSubstring(s))