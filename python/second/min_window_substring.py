from collections import defaultdict

class Solution(object):
    # O(n) time | O(n) space
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        tCount = defaultdict(int)
        for i,c in enumerate(t):
            tCount[c] += 1
        sCount = defaultdict(int)
        count = len(t)
        start = 0
        res = [0, len(s)]
        for i in range(len(s)):
            c = s[i]
            sCount[c] += 1
            if c in tCount and sCount[c] <= tCount[c]:
                count -= 1
            if count == 0:
                sc = s[start]
                while sc not in tCount or sCount[sc] > tCount[sc]:
                    start += 1
                    sCount[sc] -= 1
                    sc = s[start]
                
                if i - start < res[1] - res[0]:
                    res[0] = start
                    res[1] = i

        return s[res[0]:res[1] + 1] if count == 0 else ""  

solution = Solution()
s = "ADOBECODEBANC"
t = "ABC"
print(solution.minWindow(s, t))
