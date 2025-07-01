class Solution(object):
    # O(n) time | O(26) space
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False

        sChars = [0] * 26
        tChars = [0] * 26

        for i in range(len(s)):
            sChars[ord(s[i]) - ord('a')] += 1
            tChars[ord(t[i]) - ord('a')] += 1
        
        for i in range(len(sChars)):
            if sChars[i] != tChars[i]:
                return False
        
        return True
    

s = "anagram"
t = "nagaram"

isAnagram = Solution()

print(isAnagram.isAnagram(s, t))
