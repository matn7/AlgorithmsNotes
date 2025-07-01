class Solution(object):
    # O(n * 2^n) time | O(n) space
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        res = []
        part = []

        def isPali(i, j):
            while i < j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1
            return True

        def backtrack(i):
            if i == len(s):
                res.append(part[::])
                return
            
            for j in range(i, len(s)):
                if isPali(i, j):
                    part.append(s[i:j + 1])
                    backtrack(j + 1)
                    part.pop()
        

        backtrack(0)
        return res

solution = Solution()
s = "aab"

print(solution.partition(s))
