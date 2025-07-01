class Solution(object):
    # O(n) time | O(26) space
    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        pattern = [0] * 26
        for i, c in enumerate(s1):
            pattern[ord(c) - ord('a')] += 1
        
        substr = [0] * 26

        for i in range(len(s2)):
            c = s2[i]
            if i >= len(s1):
                found = True
                for j in range(26):
                    if pattern[j] != substr[j]:
                        found = False
                        break
                
                if found:
                    return True
                
                t = s2[i - len(s1)]
                substr[ord(t) - ord('a')] -= 1

            substr[ord(c) - ord('a')] += 1
        
        for j in range(26):
            if pattern[j] != substr[j]:
                return False
        return True
        



solution = Solution()

s1 = "abc"
s2 = "eidbaocaboo"

print(solution.checkInclusion(s1, s2))