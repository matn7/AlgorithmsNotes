class Solution(object):
    # O(n) time | O(26) space
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        l = 0
        maxFreq = 0
        counts = [0] * 26
        res = 0

        for r, c in enumerate(s):
            counts[ord(c) - ord('A')] += 1
            maxFreq = max(maxFreq, counts[ord(c) - ord('A')])

            while (r - l + 1) - maxFreq > k:
                t = s[l]
                counts[ord(t) - ord('A')] -= 1
                l += 1
            
            res = max(res, r - l + 1)

        return res
    
solution = Solution()
s = "AABABBA"
k = 1
print(solution.characterReplacement(s, k))