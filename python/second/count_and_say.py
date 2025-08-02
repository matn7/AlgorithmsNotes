class Solution(object):
    # O(2^n) time | O(2^n) space
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        
        return self.helper(n, "1")

    def helper(self, n, s):
        if n == 1:
            return s
        
        i = 0
        j = 0
        builder = ""
        while i < len(s):
            while j < len(s) and s[i] == s[j]:
                j += 1
            builder += str(j - i)
            builder += str(s[i])
            i = j

        return self.helper(n - 1, builder)


solution = Solution()
print(solution.countAndSay(5))
