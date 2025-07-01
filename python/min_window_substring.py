class Solution(object):
    # O(n) time | O(m) space
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        pattern = {}

        for i, c in enumerate(t):
            if c not in pattern:
                pattern[c] = 0
            pattern[c] += 1
        
        substr = {}
        count = len(t)
        start = 0
        res = [0, len(s) - 1]
        for i, c in enumerate(s):
            if c not in substr:
                substr[c] = 0
            substr[c] += 1
            if c in pattern and pattern[c] >= substr[c]:
                count -= 1
            
            if count == 0:
                while s[start] not in pattern or substr[s[start]] > pattern[s[start]]:
                    substr[s[start]] -= 1
                    start += 1
                
                if i - start < res[1] - res[0]:
                    res[0] = start
                    res[1] = i
        
        return "" if count > 0 else s[res[0] : res[1] + 1]
    

s = "ADOBECODEBANC"
t = "ABC"
solution = Solution()
print(solution.minWindow(s, t))

