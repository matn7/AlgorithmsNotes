class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        for i in range(len(haystack) + 1 - len(needle)):
            if haystack[i:i + len(needle)] == needle:
                return i
        return -1

solution = Solution()
haystack = "sadbutsad"
needle = "sad"
print(solution.strStr(haystack, needle))