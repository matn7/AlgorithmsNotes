class Solution(object):
    # O(n) time | O(1) space
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        i = 0
        j = len(s) - 1

        while i <= j:
            while i < j and not self.isAlphaNum(s[i]):
                i = i + 1
            
            while j > i and not self.isAlphaNum(s[j]):
                j = j - 1

            if s[i].lower() != s[j].lower():
                return False

            i = i + 1
            j = j - 1
        
        return True
    
    def isAlphaNum(self, c):
        return (ord('A') <= ord(c) <= ord('Z') or (ord('a') <= ord(c) <= ord('z') or (ord('0') <= ord(c) <= ord('9'))))
    
solution = Solution()

print(solution.isPalindrome("A man, a plan, a canal: Panama"))
