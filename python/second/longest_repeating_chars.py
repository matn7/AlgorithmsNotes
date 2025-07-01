from collections import defaultdict
class Solution(object):
    # O(n) time | O(m) space
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        j = 0
        freqMap = defaultdict(int)
        maxFreq = 0
        maxLen = 0

        for i,ci in enumerate(s):
            freqMap[ci] += 1
            maxFreq = max(maxFreq, freqMap[ci])

            while i - maxFreq - j >= k:
                cj = s[j]
                freqMap[cj] -= 1
                maxFreq = max(maxFreq, freqMap[cj])
                j += 1
            
            maxLen = max(maxLen, i - j + 1)
        return maxLen
    

solution = Solution()
s = "AABABBA"
k = 1
print(solution.characterReplacement(s, k))


            
