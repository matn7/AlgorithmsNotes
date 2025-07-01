class Solution(object):
    # O(n^2) time | O(1) space
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        def countPali(i, j):
            count = 0
            while i >= 0 and j <= len(s) - 1:
                if s[i] != s[j]:
                    break
                count += 1
                i -= 1
                j += 1
            return count

        res = 0
        for i in range(len(s)):
            res += countPali(i, i)
            res += countPali(i, i + 1)
        return res
    

solution = Solution()
print(solution.countSubstrings("aaa"))
